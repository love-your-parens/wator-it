(ns mixins 
  {:clj-kondo/ignore [:clojure-lsp/unused-public-var]})

(defn feather
  [& {:keys [size stroke-width inner-width color inner-color rotation class]}]
  [:svg {:xmlns "http://www.w3.org/2000/svg"
         :class (or class [])
         :width (or size 48) :height (or size 48)
         :viewBox "0 0 12 12"
         :style {:transform (format "rotate(%ddeg)"
                                    (or rotation 0))}}
   [:path {:d "M9.436 4.242c0 2.124-2.042 6.073-3.086 7.886-1.054-1.814-3.086-5.762-3.086-7.886C3.264 2.118 4.646.395 6.35.395s3.086 1.723 3.086 3.847z"
           :style {:fill "none"
                   :stroke (or color inner-color)
                   :stroke-width (or stroke-width ".375")
                   :stroke-dasharray "none"}}]
   [:path {:d "M8.348 2.763a1.998 1.998 0 0 1-1.997 1.999 1.998 1.998 0 0 1-2-1.997 1.998 1.998 0 0 1 1.996-2A1.998 1.998 0 0 1 8.348 2.76"
           :style {:fill "none"
                   :stroke (or inner-color color)
                   :stroke-width (or inner-width stroke-width ".375")
                   :stroke-dasharray "none"}}]])

(defn feather-footer
  []
  [:div {:class ["text-right" "leading-[16px]"]
         :alt "Decorative element: two simple geometric shapes resembling peacock feathers"
         :aria-hidden "true"}
   (feather {:size 16 :rotation 90 :stroke-width 0.7 :outer-color "#c2347e"
             :class ["inline-block" "relative" "-top-[1px]" "stroke-neutral-800" "dark:stroke-neutral-100"]})
   (feather {:size 16 :rotation 270 :stroke-width 0.7 :outer-color "#c2347e"
             :class ["inline-block" "stroke-neutral-800" "dark:stroke-neutral-100"]})])

(defn- destructure-container
  [[tag & contents]]
  (if (map? (first contents))
    [tag (first contents) (next contents)]
    [tag {} contents]))

(defn- style-container
  [classes]
  (fn [container]
    (let [[tag properties contents] (destructure-container container)]
      (into [tag
             (merge properties
                    {:class (into (get properties :class [])
                                  classes)})]
            contents))))

(def left-column (style-container
                  ["bg-neutral-100" "dark:bg-neutral-900"
                   "p-3" "md:p-5"
                   "mb-3" "lg:mb-0"
                   "w-3/4" "lg:w-1/2"]))

(def right-column (style-container
                   ["bg-neutral-100" "dark:bg-neutral-900"
                    "p-3" "md:p-5"
                    "w-3/4" "ml-[25%]"
                    "mb-3" "lg:mb-0"
                    "lg:w-1/2" "lg:ml-[50%]"]))

(defn link*
  ([target url alt content]
   [:a {:target target :href url :alt alt
        :class ["border-b" "border-dashed" "hover:border-solid"
                "border-neutral-600" "dark:border-neutral-300"]}
    content])
  ([target url content] (link* target url nil content))
  ([target url] (link* target url nil url)))

(def link (partial link* nil))
(def local-link (partial link* "_self"))
(def external-link (partial link* "_blank"))