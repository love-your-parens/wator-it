(require '[hiccup.util :refer [raw-string] :rename {raw-string r}]
         '[hugo :refer [tag] :rename {tag t}])

[:a {:href (t .Site.BaseURL)
     :class []}
 (r "&copy;"
    (t now.Format "2006")
    " " (t .Site.Copyright | default .Site.Author | safeHTML))]