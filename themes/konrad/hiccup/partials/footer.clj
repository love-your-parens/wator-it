(require '[hiccup.util :refer [raw-string] :rename {raw-string r}]
         '[hugo :refer [tag] :rename {tag t}])

[:footer {:class ["m-5"
                  "text-right"
                  "text-xs"
                  "font-sans"]}
 [:a {:href (t .Site.BaseURL)}
  (r "&copy;"
     (t now.Format "2006")
     " " (t .Site.Copyright | default .Site.Author | safeHTML))]]