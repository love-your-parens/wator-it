(ns mixins)

(defn feather
  [& {:keys [size stroke-width outer-color inner-color rotation]}]
  [:svg {:xmlns "http://www.w3.org/2000/svg"
         :width (or size 48) :height (or size 48)
         :viewBox "0 0 12 12"
         :style {:transform (format "rotate(%ddeg)" 
                                    (or rotation 0))}}
   [:path {:d "M9.436 4.242c0 2.124-2.042 6.073-3.086 7.886-1.054-1.814-3.086-5.762-3.086-7.886C3.264 2.118 4.646.395 6.35.395s3.086 1.723 3.086 3.847z"
           :style {:fill "none"
                   :stroke (or outer-color inner-color "#000")
                   :stroke-width (or stroke-width ".375")
                   :stroke-dasharray "none"}}]
   [:path {:d "M8.348 2.763a1.998 1.998 0 0 1-1.997 1.999 1.998 1.998 0 0 1-2-1.997 1.998 1.998 0 0 1 1.996-2A1.998 1.998 0 0 1 8.348 2.76"
           :style {:fill "none"
                   :stroke (or inner-color outer-color "#000")
                   :stroke-width (or stroke-width ".375")
                   :stroke-dasharray "none"}}]])
