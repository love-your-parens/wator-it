(require '[hugo :as h :refer [raw-tag raw-tag-] :rename {raw-tag t raw-tag- t-}])

[:ul
 (t- range .Translations)
 [:li
  [:a {:href (t .Permalink)}
   (t .Lang)
   (t replace .Lang "en" "gb" | printf ":flag_%s:" | emojify)]]
 (t- end)]
