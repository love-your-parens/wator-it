(ns hiccuped-hawk
  "Utilities for processing hiccup templates to html on the fly."
  (:require [hiccup2.core :as h]
            [clojure.string :as s]
            [clojure.java.io :refer [as-relative-path make-parents]]
            [babashka.fs :as fs]))
(defn re-path
  "Normalizes a file system path for use in regex strings.
   Helps avoid issues with backslash-delimited paths (Windows & friends)."
  [path]
  (s/escape (as-relative-path path) {\\ "\\\\"}))

(defn rebase-path
  "Given a `file-path` that resides within `source-dir`, rebases the path to `target-dir`.
   TODO throw if `file-path` is not inside `source-dir`"
  [source-dir target-dir file-path]
  (s/replace (as-relative-path file-path)
             (re-pattern (str "^" (re-path source-dir) "(.*)"))
             (str (re-path target-dir) "$1")))

(comment
  (rebase-path "dir1/dir2/"
               "dir1/dir4"
               "dir1/dir2/dir3/myfile"))

(defn replace-extension
  "Given a file path or a file name, replaces its extension with `extension`."
  [extension file-path]
  (s/replace file-path #"^(.*)\..*" (str "$1." extension)))

(def compile-target
  ^{:doc "Resolves the compile-target of a template file."
    :usage (comment
             "General example."
             "Note that Unix-like paths should work in any OS."
             (let [base-dir "themes/konrad/hiccup/"
                   output-dir "themes/konrad/layout/"
                   file "themes/konrad/hiccup/404.clj"]
               (compile-target base-dir output-dir file))
             "Example usage with mixed path separators."
             "Works in Windows, doesn't work in *nix."
             (let [base-dir "themes/konrad/hiccup/"
                   output-dir "themes\\konrad/layout/"
                   file "themes\\konrad\\hiccup\\404.clj"]
               (compile-target base-dir output-dir file)))}
  (comp (partial replace-extension "html") rebase-path))

(defn compile
  "Compiles a single Hiccup template to HTML.
   `base-dir` represents the relative root of the source; defaults to workdir
   `output-dir` represens the relative root of the output; defaults to workdir
   `filename` is the path of the template file; it must be inside `base-dir`"
  ([filename]
   (compile "" "" filename))
  ([base-dir output-dir filename]
   (try
     (when-let [markup (load-file filename)]
       (let [output (compile-target base-dir output-dir filename)]
         (println "\nRecompiling template:\t" filename "->" output)
         (make-parents output)
         (spit output (h/html {:escape-strings? (not (-> markup meta :raw))}
                              markup))))
     (catch Exception e
       (println "ERROR!"
                "Failed to compile template"
                (format "[%s]:" filename)
                (.getMessage e))))))

(defn compile-all
  "Recursively seeks out *all* templates in `base-dir` and compiles them to `output-dir`."
  [base-dir output-dir]
  (fs/walk-file-tree (fs/file base-dir)
                     {:visit-file (fn [path & _]
                                    (when (s/ends-with? path ".clj")
                                      (compile base-dir output-dir (str path)))
                                    :continue)}))

(comment
  (compile-all "hiccup" "themes/konrad"))
