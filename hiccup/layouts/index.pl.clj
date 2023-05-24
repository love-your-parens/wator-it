(require '[hugo :refer [raw-tag] :rename {raw-tag t}]
         '[mixins :refer [link external-link left-column right-column feather-footer]])

(list

 (t define "main")
 [:div {:class ["mx-auto" "text-sm" "md:text-base"]}
  (left-column
   [:article
    [:h1 "Programista, " [:span {:class "whitespace-nowrap"} "Web Developer"]]
    [:h2 "Tworzę rzeczy zgrabne i użyteczne"]
    [:p
     "W branży od przeszło dekady, poznałem - i zmogłem - niejedną zagwozdkę. Od prostych stron internetowych, przez "
     [:strong [:abbr {:title "Content Management System"} "CMS-y"]]
     ", po platformy " [:strong "e-commerce"]
     ", oraz złożone konstrukcje, stanowiące trzon działalności marketingu sieciowego, tzw. "
     [:strong [:abbr {:title "Multi-Level Marketing"} "MLM"]]
     "."]
    (feather-footer)])
  (right-column
   [:article
    [:h1 "Wszystko jest dla ludzi"]
    [:h2 "Dla użytkowników"]
    [:p "Za probierz mojej pracy obieram odczucia odbiorcy. Dbam by to, co przygotowuję było wygodne i czytelne w obsłudze, ale też i atrakcyjne z wierzchu. Słowem: zwracam szczególną uwagę na "
     [:strong [:abbr {:title "User Experience"} "UX"]]
     ", chociażby z tej przyczyny, że produkt nieużywany jest też siłą rzeczy nieużyteczny."]
    [:h2 "Dla fachowców"]
    [:p "Schludna oprawa to nie wszystko. Nie ma programów skończonych, a większość przechodzi z rąk do rąk. Dbam zatem, aby moją pracę mogli podjąć lub spożytkować inni, nie głowiąc się przy tym stale - co też autor miał na myśli. Dobrze napisany kod mówi ponoć sam za siebie, ale nie mówi wszystkiego. Wymaga didaskaliów."]
    (feather-footer)])
  (left-column
   [:article
    [:h1 "W warsztacie"]
    [:h2 "Od lamp po dorsze"]
    [:p "Od lat współpracuję z norweską firmą " [:strong (external-link "https://eqology.com" "Eqology")]
     ", niestrudzenie zabiegającą o zapewnienie powszechnej zdrowotności za rozsądne pieniądze. Stoi za tym przedsięwzięciem pokaźny system informatyczny pod opieką kilku zuchów. Jestem jednym z nich. "]
    [:p "Mamy tu cały mikrokosmos usług. Jest sklep internetowy, wraz z systemem "
     [:strong [:abbr {:title "Customer Relationship Management"} "CRM"]]
     ";  Jest tzw. "
     [:em {:class ["whitespace-nowrap"]}
      (external-link "https://en.wikipedia.org/wiki/Back-office_software" "Back-Office")]
     "; System zwrotów; Liczne integracje z usługami zewnętrznymi - bramkami płatności, systemami korespondencji itd.; Jest w końcu serce całego przedsięwzięcia: "
     [:strong "platforma biznesowa"]
     " dla naszych partnerów handlowych."]
    [:p "Eqology jest nietypową firmą, o nietypowych potrzebach. Wymaga rozwiązań szytych na miarę. Wiele tu zatem autorskich programów, opartych jednak - jakby na przekór - na znanych i wprost wszechobecnych w tej dziedzinie technologiach. U podstaw większości usług stoi bowiem sprawdzony zestaw oprogramowania, zaszyty w akronimie "
     [:strong [:abbr {:title "Linux-Apache-MySQL-PHP"} "LAMP"]] ". "]
    (feather-footer)])
  (right-column
   [:article
    [:h1 "W pracowni"]
    [:h2 "Co pan tam zmalował?"]
    [:p "Na co dzień zajmuję się głównie " [:em "Web Developmentem"]
     " w pełnym przekroju, tj. " [:strong {:class ["whitespace-nowrap"]} "Full-Stack"] ". "
     "Po godzinach i do szuflady sięgam natomiast po inne tematy, i inne technologie."]
    [:p "Opracowałem szereg rozmaitych głupstw, między innymi:"]
    [:ul {:class ["list-inside" "list-disc"]}
     [:li "Interaktywną bazę haseł i myśli uporządkowanych hierarchicznie: jako drzewo, z użyciem tzw. "
      (external-link "https://en.wikipedia.org/wiki/Zipper_(data_structure)" "Zipperów") ". "
      "Dostęp do haseł umożliwiają tu: graficzna przeglądarka, podobna do eksploratora plików, oraz funkcja wyszukiwania rozmytego."]
     [:li [:strong "Bota"] " łączącego się z aplikacją " [:strong "Discord"]
      " by serwować na życzenie (i ku pokrzepieniu serc) zdjęcia uroczych pandek rudych. Wskład programu wchodzi również prymitywny mechanizm moderacyjny, obecny tu nie bez kozery. Zdjęcia pochodzą bowiem z internetu i są dobierane z grubsza przypadkowo. Dość powiedzieć, że nie wszystkie nadają się do druku."]
     [:li "Prototyp platformy " [:strong "blogowej"] " oparty o "
      (external-link "https://bottlepy.org" "Bottle") ", pod tytułem "
      [:strong "Graphomania"] " (grafomania) - "
      [:q "dla tych, co pisać muszą, a niekoniecznie powinni"] ". "
      "Ot, drobna uszczypliwość z mojej strony - również pod adresem własnym. Czytelnik raczy wybaczyć."]
     [:li "Bibliotekę pomocniczą o nazwie " [:strong "Phunky"]
      ", przenoszącą kilka zasadniczych idiomów i funkcjonalności języka "
      (external-link "https://clojure.org/" "Clojure")
      " do " (external-link "https://php.net" "PHP") "."]]
    (feather-footer)])
  (left-column
   [:article
    [:h1 "READY▮"]
    [:p "Moja przygoda z szeroko rozumianą informatyką rozpoczęła się dawno temu, gdy jako szkrab po raz pierwszy zetknąłem się z 8-bitowym komputerem Atari. Było to świeckie objawienie, cud w pudełku. Głowa aż puchła mi od czarów jarzących się na dnie kineskopu."]
    [:h2 "Moje Atari"]
    [:p "Oczarowały mnie oczywiście przede wszystkim gry. To słabość, której ulegam po dziś dzień. Kiedy jednak doczekałem się w końcu własnej maszyny ze znakiem góry Fuji, stanąłem przed kolejną przeszkodą. Nie miałem ani magnetofonu, ani stacji dysków. Oprócz instrukcji obsługi, wyposażenie stanowiły: "
     [:em "joystick"] ", oraz jeden jedyny " [:em "cartridge"] " z grą " [:strong "Donkey Kong"] ". "
     "Wiedziałem wszakże, że ta maszyna potrafi znacznie więcej!"]
    [:h2 "Zrób to sam"]
    [:p "Szybko odkryłem, że uruchomione bez "
     [:em "wsadu"] " Atari wyświetla piękne, turkusowe tło, a na nim słowo-klucz: " [:strong "READY"] " (ang.: " [:em "gotowy"] "). Gotowość tę podkreślał, dosłownie i w przenośni, prostokątny kursor - wrota do innego świata. Za morskim błękitem krył się bowiem interaktywny interpreter języka "
     (external-link "https://en.wikipedia.org/wiki/Atari_BASIC" "BASIC")
     ". Tak się zaczęło."]
    [:p "Te korzenie dają o sobie znać. Ich przejawem może być to, że moim ulubionym językiem programowania jest dziś "
     [:strong (external-link "https://clojure.org/" "Clojure")] " - w dużej mierze z uwagi na silnie interaktywną metodę pracy w oparciu o "
     [:abbr {:title "Read-Eval-Print-Loop"} "REPL"]
     ". To pod wieloma względami rozwinięcie tych doświadczeń, które pamiętam z "
     [:strong "BASIC"] "-a."]
    (feather-footer)])
  (right-column
   [:article
    [:h1 {:id "contact"} "Kontakt"]
    [:h2 "Poczta elektroniczna"]
    [:p "W sprawach zawodowych zapraszam do kontaktu przez "
     (let [[tag attrs & content] (link "#" "e-mail")]
       [tag (-> attrs
                (update-in [:class] #(conj % "mailme"))
                (assoc :onclick "return false;"))
        content]) ". "]
    [:h2 "W sieci"]
    [:ul {:class ["list-inside" "list-disc"]}
     (t $ghLight := ((resources.Get "/img/third-party/github-mark-white.svg" :.) RelPermalink))
     (t $ghDark := ((resources.Get "/img/third-party/github-mark.svg" :.) RelPermalink))
     [:li {:class ["my-2" "md:my-0"]}
      (external-link "https://github.com/love-your-parens"
                     (list [:span {:aria-hidden "true"}
                            [:img {:src (t $ghDark) :width 18 :height 18 :class ["inline" "dark:hidden" "h-3" "align-baseline"]}]
                            [:img {:src (t $ghLight) :width 18 :height 18 :class ["hidden" "dark:inline" "h-3" "align-baseline"]}]]
                           " Github"))]
     (t $inWhite := ((resources.Get "img/third-party/In-White-21.png" :.) RelPermalink))
     [:li {:class ["my-2" "md:my-0"]}
      (external-link "https://www.linkedin.com/in/konrad-w%C4%85tor-95538565"
                     (list [:span {:aria-hidden "true"}
                            [:span {:class ["inline-block" "dark:hidden" "align-baseline"
                                            "bg-black" "p-[1px]" "-mb-[1px]" "rounded-sm"]}
                             [:img {:src (t $inWhite) :width 18 :height 18 :class ["h-3"]}]]
                            [:img {:src (t $inWhite) :width 18 :height 18 :class ["hidden" "dark:inline" "h-3" "align-baseline"]}]]
                           " LinkedIn"))]
     [:li {:class ["my-2" "md:my-0"]}
      (external-link "https://www.goldenline.pl/konrad-wator2/" "GoldenLine")]]
    (feather-footer)])]
 (t end)
 (t define "footer")
 (left-column [:div (t partial "footer" .)])
 (t end))