(require '[hugo :refer [raw-tag -raw-tag-] :rename {raw-tag t -raw-tag- -t-}]
         '[mixins :refer [left-column right-column]])

(list
 (-t- define "main")
 (left-column [:article {:class ["min-h-[90vh]"]}
               [:h1 (t .Title)]
               (t .Content)])
 (-t- end)
 (t define "footer")
 (right-column [:footer (t partial "footer" .)])
 (t end))
