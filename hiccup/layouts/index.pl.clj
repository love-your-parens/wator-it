(require '[hugo :refer [raw-tag] :rename {raw-tag t}])

(list
 (t define "main") 
 [:div {:class ["mx-auto"]}
  [:article {:class ["p-5" "bg-neutral-100" "dark:bg-neutral-900"
                     "mb-3" "lg:mb-0"
                     "w-3/4" "lg:w-1/2"]} 
   
   (t .Content)]
  [:article {:class ["p-5" "bg-neutral-100" "dark:bg-neutral-900"
                     "w-3/4" "ml-[25%]"
                     "lg:w-1/2" "lg:ml-[50%]"]}
   (t .Content)]]
 (t end))