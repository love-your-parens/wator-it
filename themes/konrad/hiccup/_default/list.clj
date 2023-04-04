(require '[hugo :refer [raw-tag] :rename {raw-tag t}])

(list
 (t define "main")
 [:article {:class "m-5"}
  [:h1 (t .Title)]
  (t .Content)
  [:h2 (t i18n "recentPosts")]
  (t if .Pages)
  , [:ul
     (t range sort .Pages ".Date" "desc")
     , [:li [:a {:href (t .RelPermalink)} (t .Title)]]
     (t end)]
  (t else)
  , [:p (t i18n "noPosts")]
  (t end)]
 (t end))