(require '[hugo :refer [raw-tag] :rename {raw-tag t}])

(list
 [:label.dark-mode-controls
  {:class ["block" "cursor-pointer" "select-none" "h-[36px]" "overflow-hidden"]}
  [:input.dark-mode-toggle.hidden {:type :checkbox 
                                   :alt "Switch controlling whether the site is displayed in light, or dark colours"}]
  (t $sun := resources.Get ("img/sun.svg"))
  (t $moon := resources.Get ("img/moon.svg"))
  [:div {:class ["relative" "transition-all" "hover:-mt-[36px]" "dark:-mt-[36px]" "dark:hover:mt-0"]}
   [:img {:src (t $sun.RelPermalink) :width 36 :height 36 :class ["bg-neutral-200" "rounded-full" "p-[3px]"]
          :alt "Icon of the sun, representing the bright colour theme"}]
   [:img {:src (t $moon.RelPermalink) :width 36 :height 36 :class ["bg-neutral-200" "rounded-full" "p-[2px]"]
          :alt "Icon of the moon, representing the dark colour theme"}]]]
 [:script "document.darkModeSwitchesPresent = true"])
