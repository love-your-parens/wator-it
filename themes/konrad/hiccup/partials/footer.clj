(require '[hiccup.util :refer [raw-string] :rename {raw-string r}]
         '[hugo :refer [tag] :rename {tag t}])

[:footer {:class ["text-right" "text-xs" "font-sans" "m-1" "mt-3"]}
 [:a {:href (t .Site.BaseURL)
      :class ["bg-neutral-400" "text-neutral-800" "dark:bg-neutral-700" "dark:text-neutral-200"
              "px-0.5" "pb-0.5"]}
  (r "&copy;"
     (t now.Format "2006")
     " " (t .Site.Copyright | default .Site.Author | safeHTML))]]