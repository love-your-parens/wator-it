(require '[hugo :as h :refer [raw-tag] :rename {raw-tag t}])

[:header {:class ["mx-3" "md:mx-5" "my-4" "flex" "justify-between" "items-baseline"]}
 [:div
  [:div {:class ["inline-block" "font-serif"]} (t partial "emblem" .)]
  [:div {:class ["inline-block" "ml-5"]} (t partial "navigation" .)]]
 [:div
  [:div {:class ["inline-block"]} (t partial "language-selection" .)]
  [:div {:class ["inline-block"]} (t partial "dark-mode-switch" .)]]]
