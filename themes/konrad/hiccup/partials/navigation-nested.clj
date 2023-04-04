(require '[hugo :refer [raw-tag] :rename {raw-tag t}])

;; The context must be a menu item!
[:ul (t range .)
 [:li
  (t if .HasChildren)
  , (t partial "navigation-nested" .Children)
  (t else)
  , (t .Pre)
  , [:a {:href (t .URL)} [:span (t .Name)]]
  , (t .Post)
  (t end)]
 (t end)]
