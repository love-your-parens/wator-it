(ns hugo (:require [clojure.string :as s]
                   [clojure.set :refer [intersection]]
                   [hiccup.util :as h]
                   [cheshire.core :as json]))

(def aggregations {:. "."
                   :_ ""})
(def aggregators (set (keys aggregations)))

(defn- aggregates
  [symbol]
  (or (-> symbol meta keys set (intersection aggregators) first)
      (and (list? symbol)
           (-> symbol last hash-set (intersection aggregators) first))))

(defn- aggregates?
  [symbol]
  (some? (aggregates symbol)))

(comment
  (aggregates '1)
  (aggregates '(1 2))
  (aggregates '(1 2 :.))
  (aggregates ^:. [1 2])
  (aggregates (with-meta '(1 2) {:_ true})))

(defn- deaggregate-meta
  [symbol]
  (if-let [m (meta symbol)]
    (with-meta symbol
      (reduce (fn [m [k v]]
                (if (contains? aggregators k) m (assoc m k v)))
              {} m))
    symbol))

(defn- deaggregate-list
  [symbol]
  (if (and (list? symbol) (contains? aggregators (last symbol)))
    (recur (butlast symbol))
    symbol))

(defn deaggregate
  [symbol]
  (deaggregate-list
   (deaggregate-meta symbol)))

(comment 
  (aggregates (deaggregate (with-meta '(1 2) {:_ true})))
  (aggregates (deaggregate '(1 2 :.)))
  )

(defn- escape-symbols
  ([symbols]
   (escape-symbols []  (first symbols) (next symbols)))
  ([escaped symbols]
   (escape-symbols escaped (first symbols) (next symbols)))
  ([escaped sym symbols]
   (if sym
     (if-let [aggregator (aggregates sym)]
       (s/join " " (conj escaped
                         (str
                          (escape-symbols (list (deaggregate sym)))
                          (aggregations aggregator)
                          (escape-symbols symbols))))
       (recur (conj escaped
                    (cond
                      (list? sym) (format "(%s)" (escape-symbols sym))
                      (string? sym) (format "\"%s\"" sym)
                      :else (str sym)))
              (first symbols)
              (next symbols)))
     (s/join " " escaped))))

(comment
  ;; Observe how different kinds of symbols and symbol combinations are treated.
  (escape-symbols '(someVar := (resources.Get "img/image.png" :.) RelPermalink | TransformSomehow))
  ;; You can use aggregators to splice individual symbols.
  (escape-symbols '((these items) .will be separated))
  (escape-symbols '((these items :.) ^:_ will (not be separated))))

(defn- wrap
  [wrapper & symbols]
  (format wrapper (escape-symbols symbols)))

(defmacro tag
  [& symbols]
  (apply wrap "{{ %s }}" symbols))

(defmacro -tag
  [& symbols]
  (apply wrap "{{- %s }}" symbols))

(defmacro tag-
  [& symbols]
  (apply wrap "{{ %s -}}" symbols))

(defmacro -tag-
  [& symbols]
  (apply wrap "{{- %s -}}" symbols))

(defmacro raw-tag [& symbols]
  `(h/raw-string (tag ~@symbols)))

(defmacro -raw-tag [& symbols]
  `(h/raw-string (-tag ~@symbols)))

(defmacro raw-tag- [& symbols]
  `(h/raw-string (tag- ~@symbols)))

(defmacro -raw-tag- [& symbols]
  `(h/raw-string (-tag- ~@symbols)))

(defn front-matter [m]
  (h/raw-string (format "%s\n" (json/generate-string m))))

(comment
  ;; Examples.
  (tag define "main")
  (tag- .Content)
  (-raw-tag- someVar := (resources.Get "img/image.png" :.) RelPermalink | TransformSomehow))