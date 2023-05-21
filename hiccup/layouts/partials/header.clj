(require '[hugo :as h :refer [raw-tag] :rename {raw-tag t}])

[:section {:class ["m-1"] :aria-description "Page heading and general navigation"}
 [:div {:class ["flex" "justify-between" "items-baseline" "font-sans"]}
  [:nav {:class ["mx-1"] :alt "Front page navigation"} 
   [:a {:href "#contact" :class ["hover:underline"]} (t i18n "contact")]]
  [:nav {:class ["flex"] :alt "Subsite navigation"} 
   (t partial "navigation-nested" .Site.Menus.main)]
  [:div {:class ["flex" "items-center"]}
   [:div {:class ["mx-2"]} (t partial "language-selection" .)]
   [:div {:class ["mx-1"]} (t partial "dark-mode-switch" .)]]]
 [:div {:class ["text-center" "my-4"]}
  (t partial "emblem" .)]]
