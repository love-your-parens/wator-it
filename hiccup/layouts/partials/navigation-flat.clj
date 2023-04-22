(require '[hugo :refer [tag] :rename {tag t}])

;; The context must be a menu item!
[:ul (t range .) (t if not .HasChildren)
 [:li
  (t .Pre)
  [:a {:href (t .URL)} [:span (t .Name)]]
  (t .Post)]
 (t end) (t end)]
