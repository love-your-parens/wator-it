(require '[hugo :refer [raw-tag] :rename {raw-tag t}]
         '[mixins :refer [link external-link left-column right-column feather-footer]])

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
    [:p "Pragnę, by z mojej pracy był pożytek. Nie wystarczy, że działa. "
     "Musi być wygodne w obsłudze, musi być czytelne, a i oczu razić nie powinno. "
     "Słowem: kładę nacisk na "
     [:em [:abbr {:title "User Experience"} "UX"]]
     " i nie lekceważę niczego, co przekłada się na odczucia odbiorcy."]
    [:p "Schludna powierzchowność to nie wszystko. Nie ma programów skończonych, a większość przechodzi z rąk do rąk. "
     "Dbam zatem, aby moją pracę mogli podjąć lub spożytkować inni, nie głowiąc się przy tym stale - co też autor miał na myśli. "]
    [:p "Dobrze napisany kod mówi ponoć sam za siebie, ale nie mówi wszystkiego. Wymaga didaskaliów."]
    (feather-footer)])
  (left-column
   [:article [:h1 "W warsztacie"]
    [:p "Korzystam z wielu narzędzi. Po niektóre sięgam chętnie, po inne chłodniej, lecz decydują względy praktyczne. "
     "Lwią część codziennej pracy realizuję przy użyciu powszechnych w "
     [:em "Web Developmencie"]
     " technologii."]
    [:p "Po stronie serwera prym wiedzie zatem nieprzesadnie urodziwe, ale sprawdzone " (external-link "https://php.net" "PHP") ". "
     "W przeglądarce rządzi tymczasem JavaScript z domieszką " (external-link "https://www.typescriptlang.org/" "TypeScriptu") ". "
     "Tu i ówdzie - jak rodzynka w serniku - trafi się coś " (external-link "https://react.dev/" "Reactowego") ". "]
    [:p "Dane ładuję do baz relacyjnych (" (interpose ", " [(external-link "https://www.mysql.com/" "MySQL")
                                                            (external-link "https://mariadb.org/" "MariaDB")
                                                            (external-link "https://www.sqlite.org/" "SQLite")])
     "), bądź nierelacyjnych (" (external-link "https://redis.io/" "Redis") "). "]
    [:p "Gdy zachodzi potrzeba rozpowszechnienia znaczącej ilości danych wewnątrz systemu, "
     "sięgam po znakomity serwer kolejek " (external-link "https://www.rabbitmq.com/" "RabbitMQ") ". "]
    [:p "Wirtualizację umożliwia mi natomiast wszechobecny dziś " (external-link "https://www.docker.com/" "Docker") "."]
    (feather-footer)])
  (right-column
   [:article [:h1 "W pracowni"]
    [:p "W samodzielnej pracy sięgam po bardziej frywolne rozwiązania. Oto wybrane."]
    [:h2 "Clojure"]
    [:p "Mam słabość do " (external-link "https://clojure.org/" "Clojure")
     " we wszystkich jego odmianach ("
     (interpose ", " [(external-link "https://clojurescript.org/" "ClojureScript")
                      (external-link "https://babashka.org/" "Babashka")]) " itd.). "
     "To szwajcarski scyzoryk na naboje. Funkcyjny, wielowątkowy, interaktywny ("
     [:abbr {:title "Read-Eval-Print-Loop"} "REPL"]
     "!) i szybki. "
     "A te nawiasy… Kochaj, albo rzuć."]
    [:p "Z pomocą Clojure opracowałem szereg głupstw, między innymi:"]
    [:ul {:class ["list-inside" "list-disc"]}
     [:li "Interaktywną bazę haseł i myśli uporządkowanych hierarchicznie - jako drzewo, "
      "na wzór systemu plików, z użyciem wyszukiwania rozmytego"]
     [:li [:em "Bota"] " łączącego się z aplikacją " [:em "Discord"]
      " by serwować na życzenie (i ku pokrzepieniu serc) zdjęcia uroczych pandek rudych"]]
    [:h2 "Python"]
    [:p "Nie lubię węży, ale dla " (external-link "https://python.org/" "Pythona") " robię wyjątek. "
     "Popełniłem w nim niejeden mały program, "
     "jak choćby prototyp platformy " [:em "blogowej"] " oparty o "
     (external-link "https://bottlepy.org" "Bottle") ", pod tytułem "
     [:em "Graphomania"] " (grafomania) - " [:q "dla tych, co pisać muszą, a niekoniecznie powinni"] ". "
     "Ot, drobna uszczypliwość z mojej strony - również pod adresem własnym. "
     "Czytelnik raczy wybaczyć."]
    (feather-footer)])
  (left-column
   [:article
    [:h1 "READY▮"]
    [:p "Moja przygoda z szeroko rozumianą informatyką rozpoczęła się dawno temu, "
     "gdy jako szkrab po raz pierwszy zetknąłem się z 8-bitowym komputerem Atari. "
     "Było to świeckie objawienie, cud w pudełku. Głowa aż puchła mi od cudów jarzących się na dnie kineskopu."]
    [:h2 "Przyszłość"]
    [:p "Wszystko jak wiadomo płynie, a w świecie cyfrowym zmagamy się ze szczególnie drapieżnym nurtem. "
     "Kto stoi w miejscu - ten tonie. Ja pływam słabo. Wodę lubię w brzuchu, w płucach nie. "
     "Rad-nierad nadstawiam zatem uszu i nie domykam głowy."]
    (feather-footer)])
  (right-column
   [:article
    [:h1 {:id "contact"} "Kontakt"]
    [:h3 "Poczta elektroniczna"]
    [:p "W sprawach zawodowych zapraszam do kontaktu poprzez "
     (let [[tag attrs & content] (link "#" "e-mail")]
       [tag (-> attrs
                (update-in [:class] #(conj % "mailme"))
                (assoc :onclick "return false;"))
        content]) ". "]
    [:h3 "Platformy społecznościowe "]
    [:p "Jestem dostępny na każdej z poniższych platform:"]
    [:ul {:class ["list-inside" "list-disc"]}
     [:li "LinkedIn"]
     [:li "Jira"]
     [:li "Github"]
     [:li "Bitbucket"]]
    (feather-footer)])]
 (t end)
 (t define "footer")
 (left-column [:div (t partial "footer" .)])
 (t end))