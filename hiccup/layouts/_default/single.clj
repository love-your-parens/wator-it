(require '[hugo :refer [raw-tag -raw-tag-] :rename {raw-tag t -raw-tag- -t-}])

(list
 (-t- define "main")
 [:article {:class ["bg-neutral-100" "dark:bg-neutral-900"
                    "w-3/4" "p-5" "lg:w-1/2"
                    "min-h-[calc(100vh)]"]}
  [:h1 (t .Title)] (t .Content)] 
 (-t- end)
 (t define "footer")
 [:div {:class ["bg-neutral-100" "dark:bg-neutral-900"
                "p-1" "w-3/4" "mt-2"
                "lg:w-1/2" "lg:ml-[50%]" "lg:mt-0"
                "text-right"]}
  (t partial "footer" .)]
 (t end))
