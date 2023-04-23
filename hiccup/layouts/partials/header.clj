(require '[hugo :as h :refer [raw-tag] :rename {raw-tag t}])

[:section {:class ["m-1"]}
 [:div {:class ["flex" "justify-between" "items-baseline" "font-sans"]}
  [:nav {:class ["flex"]}
   (t partial "navigation-nested" .Site.Menus.main)]
  [:div {:class ["flex"]}
   (t partial "language-selection" .)
   (t partial "dark-mode-switch" .)]]
 [:div {:class ["text-center" "my-4"]}
  (t partial "emblem" .)]]
