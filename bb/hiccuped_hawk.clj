(ns hiccuped-hawk
  "Utilities for processing hiccup templates to html on the fly."
  (:require [hiccup2.core :as h]
            [clojure.string :as s]
            [clojure.java.io :refer [as-relative-path]]))
(defn re-path
  "Normalizes a file system path for use in regex strings.
   Helps avoid issues with backslash-delimited paths (Windows & friends)."
  [path]
  (s/escape (as-relative-path path) {\\ "\\\\"}))

(defn rebase-path
  "Given a `file-path` that resides within `source-dir`, rebases the path to `target-dir`."
  [source-dir target-dir file-path]
  (s/replace (as-relative-path file-path)
             (re-pattern (str "^" (re-path source-dir) "(.*)"))
             (str (re-path target-dir) "$1")))

(defn replace-extension
  "Given a file path or a file name, replaces its extension with `extension`."
  [extension file-path]
  (s/replace file-path #"^(.*)\..*" (str "$1." extension)))

(def compile-target (comp (partial replace-extension "html") rebase-path))

(comment
  (let [base-dir "themes/konrad/hiccup/"
        output-dir "themes\\konrad/layout/"
        file "themes\\konrad\\hiccup\\404.clj"]
    (println (compile-target base-dir output-dir file))))

(defn compile
  ([filename]
   (compile "" "" filename))
  ([base-dir output-dir filename]
   (when-let [markup (load-file filename)]
     (let [output (compile-target base-dir output-dir filename)]
       (println "\nRecompiling template:\t" filename "->" output)
       (spit output (h/html {:escape-strings? (not (-> markup meta :raw))}
                            markup))))))
