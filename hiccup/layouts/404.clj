(require '[hugo :refer [raw-tag] :rename {raw-tag t}])

[:div
 (t define "main ")
 [:h1 {:class ["text-xl"]} "Oh no, you must be lost!"]
 [:p "This is not the page you're looking for..."]
 (t end)]
