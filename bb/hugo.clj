(ns hugo
  {:clj-kondo/ignore [:unresolved-symbol]}
  (:require [clojure.string :as s]
            [hiccup.util :as h]))

(declare wrap)

(defn- escape
  [sym]
  (cond
    (string? sym) (format "\"%s\"" sym)
    (list? sym) (apply wrap "(%s)" sym)
    :else (str sym)))

(defn- wrap
  [wrapper & items]
  (format wrapper (s/join " " (map escape items))))

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
