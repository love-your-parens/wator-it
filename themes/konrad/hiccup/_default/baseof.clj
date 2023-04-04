(require '[hiccup2.core :refer [raw]]
         '[hugo :refer [raw-tag] :rename {raw-tag t}])

(list
 (raw "<!DOCTYPE html>")
 (raw "<html lang='{{ site.Language.Lang | default \"en\" }}'>")
 [:head
  (t partial "head" .)
  (t block "head" .) (t end)
  [:meta {:name "preload-tailwindcss-classes" :class ["transition-colors"]}]]
 [:body {:class ["bg-slate-50" "text-slate-900" "dark:bg-slate-700" "dark:text-slate-200"]}
  (t partial "header" .)
  [:main (t block "main" .) (t end)]
  (t partial "footer" .)]
 (raw "</html>"))