(require '[hugo :refer [raw-tag -raw-tag-] :rename {raw-tag t -raw-tag- -t-}])

(list
 (-t- define "main")
 [:article {:class ["m-5"]}
  [:h1 (t .Title)] (t .Content)]
 (-t- end))