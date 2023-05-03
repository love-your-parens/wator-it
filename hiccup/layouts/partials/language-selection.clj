(require '[hugo :as h :refer [raw-tag raw-tag-] :rename {raw-tag t raw-tag- t-}])

(list 
 (t- range .Translations)
 [:a {:href (t .RelPermalink) :class ["flex" "items-center" "hover:underline"]} 
  (t .Site.Language.LanguageName)
  (t $flag := resources.Get (printf "img/flag-%s.svg" .Lang))
  [:img {:src (t $flag.RelPermalink) :width 36 :class ["mx-1"]}]]
 (t- end))
