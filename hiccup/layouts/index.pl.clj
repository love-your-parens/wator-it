(require '[hugo :refer [raw-tag] :rename {raw-tag t}]
         '[mixins :refer [external-link left-column right-column feather-footer]])

(list

 (t define "main")
 [:div {:class ["mx-auto" "text-sm" "md:text-base"]}
  (left-column
   [:article
    [:h1 "Programista, Web Developer"]
    [:h2 "Tworzę rzeczy zgrabne i użyteczne"]
    [:p {:class []}
     "W branży od przeszło dekady, poznałem - i zmogłem - niejedną zagwozdkę. Od prostych stron internetowych, przez "
     [:em [:abbr {:title "Content Management System"} "CMS-y"]]
     ", po platformy " [:em "e-commerce"]
     ", oraz złożone konstrukcje, stanowiące trzon działalności marketingu sieciowego, tzw. "
     [:em [:abbr {:title "Multi-Level Marketing"} "MLM"]]
     "."]
    (feather-footer)])
  (right-column
   [:article
    [:h1 "Wszystko jest dla ludzi"]
    [:p "Z tego, co przygotowuję ma być pożytek. Nie wystarczy, że działa. "
     "Musi być wygodne w obsłudze; Musi być czytelne. A i oczu razić nie powinno. "
     "Słowem: kładę nacisk na "
     [:em [:abbr {:title "User Experience"} "UX"]]
     " i nie lekceważę niczego, co przekłada się na odczucia odbiorcy."]
    [:p "Schludna powierzchowność to nie wszystko. Nie ma programów skończonych. Większość przechodzi z rąk do rąk. "
     "Dbam zatem, aby moją pracę mogli podjąć, lub spożytkować inni, nie głowiąc się przy tym stale - co też autor miał na myśli. "
     "Dobrze napisany kod mówi ponoć sam za siebie, ale nie mówi wszystkiego. Wymaga didaskaliów."]
    (feather-footer)])
  (left-column
   [:article [:h1 "Za pazuchą"]
    [:p "W pracy korzystam z wielu narzędzi, które dobieram pragmatycznie. "
     "Lubię co prawda rozwiązania schludne, ale zdaje sobie sprawę, że trzeba czasem odpuścić i sięgnąć po "
     [:em "większy młotek"] ". "]
    [:h3 "Wybrane narzędzia"]
    [:ul {:class ["list-inside" "list-disc"]}
     [:li (interpose " / " [(external-link "https://php.net" "PHP")
                            (external-link "https://symfony.com/" "Symfony")])]
     [:li (interpose " / " [(external-link "https://www.ecma-international.org/publications-and-standards/standards/ecma-262/"
                                           "Javascript")
                            (external-link "https://www.typescriptlang.org/" "TypeScript")
                            (external-link "https://jquery.com/" "jQuery")])]
     [:li (interpose " / " [(external-link "https://clojure.org/" "Clojure")
                            (external-link "https://clojurescript.org/" "ClojureScript")
                            (external-link "https://babashka.org/" "Babashka")])]
     [:li (interpose " / " [(external-link "https://python.org/" "Python")
                            (external-link "https://bottlepy.org" "Bottle")
                            (external-link "https://www.djangoproject.com/" "Django")])]
     [:li (interpose " / " [(external-link "https://www.w3.org/TR/CSS/#css" "CSS")
                            (external-link "https://sass-lang.com/" "SASS")
                            (external-link "https://tailwindcss.com" "Tailwind")])]
     [:li (interpose " / " [(external-link "https://www.mysql.com/" "MySQL")
                            (external-link "https://mariadb.org/" "MariaDB")])]
     [:li (interpose " / " [(external-link "https://www.docker.com/" "Docker")])]]
    (feather-footer)])
  (right-column
   [:article [:h1 {:id "contact"} "Kontakt"]
    [:p]])]
 (t end)
 (t define "footer")
 (left-column [:div (t partial "footer" .)])
 (t end))