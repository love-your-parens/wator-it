(require '[hiccup2.core :refer [raw]]
         '[hugo :refer [raw-tag] :rename {raw-tag t}]
         '[mixins :refer [feather]])

(list
 (raw "<!DOCTYPE html>")
 (raw "<html lang='{{ site.Language.Lang | default \"en\" }}'>")
 [:head
  (t partial "head" .)
  (t block "head" .) (t end)]
 [:div {:class ["hidden"]}
  (t $bg := resources.Get "img/bg-photo.png") (t $bg.RelPermalink)
  (t $bg2 := resources.Get "img/face-outlines.svg") (t $bg2.RelPermalink)]
 [:body {:id "bottom-layer"
         :class ["bg-neutral-400" "text-neutral-800" "font-serif"
                 "dark:bg-neutral-700" "dark:text-neutral-200"
                 "max-w-screen-2xl" "m-auto" "transition-colors"]}
  (let [sizing ["fixed" "w-screen" "h-screen" "bottom-0" "-z-10"]
        bg ["bg-fixed" "bg-no-repeat" "bg-contain"]]
    [:div {:id "intermediate-layers" :aria-hidden "true"}
     [:div {:class (concat sizing bg
                           ["panoramic:hidden"
                            "bg-two-face-light" "dark:bg-two-face-dark"
                            "landscape:bg-[right_-50vh_bottom_-25vh]"
                            "portrait:bg-[right_-50vw_bottom_-7vh]"
                            "lg:landscape:bg-[center_bottom_-12vh]"
                            "lg:portrait:bg-[center_bottom_-5vh]"])}]
     [:div {:class (concat sizing bg
                           ["panoramic:hidden"
                            "bg-two-face-outline"
                            "landscape:bg-[right_-50vh_bottom_-25vh]"
                            "portrait:bg-[right_-50vw_bottom_-7vh]"
                            "lg:landscape:bg-[center_bottom_-12vh]"
                            "lg:portrait:bg-[center_bottom_-5vh]"])}]
     [:div {:class (concat sizing bg
                           ["lg:hidden"
                            "dark:bg-two-face-dark" "bg-two-face-light"
                            "landscape:bg-[left_-50vh_bottom_-25vh]"
                            "portrait:bg-[left_-50vw_bottom_-7vh]"])}]
     [:div {:class (concat sizing bg
                           ["lg:hidden"
                            "bg-two-face-outline"
                            "landscape:bg-[left_-50vh_bottom_-25vh]"
                            "portrait:bg-[left_-50vw_bottom_-7vh]"])}]
     [:div {:class (into sizing ["opacity-90" "flex" "justify-evenly" "items-start" "px-8"])}
      [:span {:class ["feather-fall" "feather-fall--delay-2"]}
       (feather {:size 32 :rotation 180 :stroke-width ".5" :color "#6c65ca"})]
      [:span {:class ["feather-fall" "feather-fall--delay-5"]}
       (feather {:size 32 :rotation 180 :stroke-width ".5" :color "#11efef"})]
      [:span {:class ["feather-fall" "feather-fall--delay-1"]}
       (feather {:size 32 :rotation 180 :stroke-width ".5" :color "#f00f74"})]
      [:span {:class ["feather-fall" "feather-fall--delay-0"]}
       (feather {:size 32 :rotation 180 :stroke-width ".5" :color "#6c65ca"})]
      [:span {:class ["feather-fall" "feather-fall--delay-3"]}
       (feather {:size 32 :rotation 180 :stroke-width ".5" :color "#11efef"})]
      [:span {:class ["feather-fall" "feather-fall--delay-2"]}
       (feather {:size 32 :rotation 180 :stroke-width ".5" :color "#f00f74"})]]])
  [:div {:id "top-layer"}
   [:header (t partial "header" .)]
   [:main (t block "main" .) (t end)]
   [:footer (t block "footer" .) (t end)]]]
 (raw "</html>"))