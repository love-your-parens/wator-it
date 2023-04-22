(require '[hugo :refer [raw-tag] :rename {raw-tag t}])

[:nav {:class ["flex space-x-2"]}
 (t partial "navigation-nested" .Site.Menus.main)]
