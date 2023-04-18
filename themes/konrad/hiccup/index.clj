(require '[hugo :refer [raw-tag] :rename {raw-tag t}]
         '[hiccup2.core :refer [raw]])

(list
 (t define "main") 
 [:div {:class ["mx-auto"]}
  [:article {:class ["p-5" "bg-neutral-100" "dark:bg-neutral-900" "w-1/2"]} 
   (t .Content)]
  [:article {:class ["p-5" "bg-neutral-100" "dark:bg-neutral-900" "w-1/2" "ml-[50%]"]}
   (t .Content)]]
 (t end))