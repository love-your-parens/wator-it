(require '[hugo :refer [raw-tag] :rename {raw-tag t}]
         '[mixins :refer [link external-link left-column right-column feather-footer]])

(list

 (t define "main")
 [:div {:class ["mx-auto" "text-sm" "md:text-base"]}
  (left-column
   [:article
    [:h1 "Programmer, " [:span {:class "whitespace-nowrap"} "Web Developer"]]
    [:h2 "I design useful & neat things"]
    [:p
     "In the business for over a decade, I've come across - and solved - many a riddle. From simple web pages, through "
     [:strong "Content Management Systems"]
     ", " [:strong "e-commerce"]
     " platforms, and complex, bespoke models at the core of network-marketing ("
     [:strong [:abbr {:title "Multi-Level Marketing"} "MLM"]]
     ") solutions."]
    (feather-footer)])
  (right-column
   [:article
    [:h1 "Designing for humans"]
    [:h2 "For the end-user"]
    [:p "The most important measure of my work's worth is the end-user's experience. I take great care so that everything I produce is pleasant to use, intuitive and easy on the eyes. Put briefly: I pay a lot of attention to  "
     [:strong [:abbr {:title "User Experience"} "UX"]]
     ", if only for the simple reason that things not in use can't be considered useful."]
    [:h2 "For the expert"]
    [:p "A pretty face isn't all it takes. There exist no " [:em "complete"] " programs. Most will eventually change hands. It's critical to me that my work can be taken up and continued by others - without having them scratch their heads, trying to figure out what the author had in mind. There's a popular belief that well-written code documents itself, and perhaps it does - but that's only part of a wider context."]
    (feather-footer)])
  (left-column
   [:article
    [:h1 "In the Workshop"]
    [:h2 "Of lamps and cod(e)"]
    [:p "For many years, I've been involved with " [:strong (external-link "https://eqology.com" "Eqology")]
     ", a company that strives ceaselessly to ensure wellness and health without the price. Behind this endeavour, there's a sizeable software solution, maintained by a few braves. I'm one of them."]
    [:p "It's an entire microcosm of services. There's the e-commerce platform, paired with a " 
     
     [:strong [:abbr {:title "Customer Relationship Management"} "CRM"]]
     " system; Then a "
     [:em {:class ["whitespace-nowrap"]}
      (external-link "https://en.wikipedia.org/wiki/Back-office_software" "Back-Office")]
     "; A return-order management system; Numerous integrations with third party services: payment platforms, newsletter systems etc. Finally, the heart of the matter: a " 
     [:strong "business management platform"]
     " for our business-partners."]
    [:p "Eqology is an unusual company with unusual needs. It requires bespoke solutions. There's hence a number of original, in-house programs, which tend to be - ironically - based on some of the most common and ubiquitous technologies of the Web. Most of them employ the tried & true software stack concealed within the acronym of "
     [:strong [:abbr {:title "Linux-Apache-MySQL-PHP"} "LAMP"]] ". "]
    (feather-footer)])
  (right-column
   [:article
    [:h1 "In the Atelier"]
    [:h2 "Ideas great and small"]
    [:p "My daily work pertains chiefly to " [:em "Web Development"]
     " from the bottom up, i.e. " [:strong {:class ["whitespace-nowrap"]} "Full-Stack"] ". "
     "After-hours, and for my own amusement, I reach for a different range of topics and technologies."] 
    [:p "I've developed a variety of silly little things, such as:"] 
    [:ul {:class ["list-inside" "list-disc"]}
     [:li "An interactive database of keywords and thoughts, arranged hierarchically as a tree, employing the use of so-called "
      (external-link "https://en.wikipedia.org/wiki/Zipper_(data_structure)" "Zippers") ". "
      "Navigation is facilitated  by a graphical browser, resembling a file explorer, as well as a fuzzy-search feature."]
     [:li "A " [:strong "bot"] " connected to the " [:strong "Discord"]
      " application, serving photographs of red pandas on demand. Adorable and uplifting! The service includes a primitive, cooperative moderation system. It's there for a good (if sordid) reason. The photos come from the internet, chiefly at random. Suffice it to say that they're not all valid for print."]
     [:li "A prototype of a " [:strong "blogging platform"] " based on "
      (external-link "https://bottlepy.org" "Bottle") ", titled "
      [:strong "Graphomania"] " - "
      [:q "for those who must write, but probably shouldn't"] ". "
      " A minor quibble, partly at my own expense - do forgive the mischief."]
     [:li "A helper library called " [:strong "Phunky"]
      ", translating some of the basic idioms and features from "
      (external-link "https://clojure.org/" "Clojure")
      " to " (external-link "https://php.net" "PHP") "."]]
    (feather-footer)])
  (left-column
   [:article
    [:h1 "READY▮"]
    [:p
     "My adventure with general computing began a long time ago, when as a wee lad I came across the 8-bit Atari computer for the very first time. It was akin to a secular revelation, a miracle in a box. My head was about to burst from all the wonders projected by the cathode-ray tube."]
    [:h2 "My Atari"]
    [:p "It's the video games that had me smitten first and foremost - an affliction still pending. Tough luck then that once I finally received my very own Mount-Fuji-branded machine, new obstacles arose. I owned no tape recorder, much less a floppy disk drive. Aside from the manual, my only accessories were: a "
     [:em "joystick"] ", and my sole video game cartridge: " [:strong "Donkey Kong"] ". I knew for a fact that this machine could offer so much more!"]
    [:h2 "Do it yourself"]
    [:p "I soon discovered that in the absence of storage media, my Atari would go on to display a lush, turquoise background, and write out the key-word: " [:strong "READY"] ". The readiness was underlined, proverbially and literally, by a rectangular cursor - a gateway to another world. Beyond the teal was a live interpreter of the programming language: "
     (external-link "https://en.wikipedia.org/wiki/Atari_BASIC" "BASIC")
     ". That's how it all began."]
    [:p "These origins manifest here and again. They might explain my affinity for the "
     [:strong (external-link "https://clojure.org/" "Clojure")] 
     " programming language. I cherish its highly interactive workflow based on the "
     [:abbr {:title "Read-Eval-Print-Loop"} "REPL"]
     ". In many ways, it's a natural evolution of my experiences with Atari's " [:strong "BASIC"] "."]
    (feather-footer)])
  (right-column
   [:article
    [:h1 {:id "contact"} "Contact"]
    [:h3 "E-mail"]
    [:p "Concerning professional inquiries, please contact me via "
     (let [[tag attrs & content] (link "#" "e-mail")]
       [tag (-> attrs
                (update-in [:class] #(conj % "mailme"))
                (assoc :onclick "return false;"))
        content]) ". "]
    [:h3 "On the Web"]
    [:ul {:class ["list-inside" "list-disc"]}
     [:li (external-link "https://github.com/love-your-parens" "Github")]
     [:li (external-link "https://www.linkedin.com/in/konrad-w%C4%85tor-95538565" "LinkedIn")]
     [:li (external-link "https://www.goldenline.pl/konrad-wator2/" "GoldenLine")]]
    (feather-footer)])]
 (t end)
 (t define "footer")
 (left-column [:div (t partial "footer" .)])
 (t end))