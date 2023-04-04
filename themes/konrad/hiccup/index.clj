(require '[hugo :refer [raw-tag] :rename {raw-tag t}])

(list
 (t define "main")
 [:div {:class ["md:grid" "grid-cols-2" "max-w-7x1" "mx-auto"]}
  [:article {:class ["m-3 md:m-5 float-left"]}
   [:span {:id ["inline-graphic"]
           :class ["hidden" "sm:inline" "md:hidden" "float-right" "w-1/4" "m-2"]}
    [:img {:src "/some-image.jpt" :alt "Portrait of the author. He looks like a trustworthy chap."}]]
   (t .Content)]
  [:div {:id "side-graphic" :class ["text-center" "hidden" "md:block" "my-5"]}
   [:img {:src "/some-image.jpt"
          :class ["sticky" "object-contain" "top-0"]
          :alt "Portrait of the author. He looks like a trustworthy chap."}]]]
 (t end))