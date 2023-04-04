(require '[hugo :refer [tag] :rename {tag t}])

[:div.site-emblem
 {:class ["text-4xl"]}
 [:a {:href (t site.Home.RelPermalink)} (t site.Title)]]
