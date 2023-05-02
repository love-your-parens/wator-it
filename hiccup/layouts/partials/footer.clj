(require '[hiccup.util :refer [raw-string] :rename {raw-string r}]
         '[hugo :refer [raw-tag] :rename {raw-tag t}])

[:a {:href (t .Site.BaseURL)
     :class ["font-sans" "font-black"]}
 (r "&copy;"
    (t now.Format "2006")
    " " (t .Site.Copyright | default .Site.Author | safeHTML))]