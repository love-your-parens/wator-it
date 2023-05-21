(require '[hugo :as h :refer [raw-tag raw-tag-] :rename {raw-tag t raw-tag- t-}])

(list
 (t- range .Translations)
 (t $linkAlt := (printf "Switch to the %s language" .Site.Language.LanguageName))
 (t $flagAlt := (printf "Flag representing the %s language" .Site.Language.LanguageName))
 (t $flagRes := resources.Get (printf "img/flag-%s.svg" .Lang))
 [:a {:href (t .RelPermalink) :class ["flex" "items-center" "hover:underline"] :alt (t $linkAlt)}
  (t .Site.Language.LanguageName)
  [:img {:src (t $flagRes.RelPermalink) :width 36 :class ["mx-1"] :alt (t $flagAlt)}]]
 (t- end))
