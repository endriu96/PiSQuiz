package com.quizapp



object Constants {

    //  Created  constant variables which are required in the result screen. Uri links are not working from this instance
    //but from QuizQuestionsActivity.
    // START
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    // END

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()


        // 1
        val que1 = Question(
                1, "1.\t\"Kacper Płażyński niestety przegrał\". Który dziennikarz TVP wypowiedział te słowa po przegranej kandydata PiS w wyborach na prezydenta Gdańska ?",
                "Edyta Lewandowska", "Danuta Holecka",
                "Michał Adamczyk", "Krzysztof Ziemiec", 1, "https://pl.wikipedia.org/wiki/Brazylia"
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "2.\t\"Co zrobić, żeby rzeczywiście to pan wygrał\"-który dziennikarz TVP wypowiedział te słowa podczas rozmowy z Andrzejem Dudą w trakcie kampanii wyborczej ? ",
                "Magdalena Ogórek", "Danuta Holecka",
                "Konrad Wąż", "Maciej Sawicki", 2,
                "https://pl.wikipedia.org/wiki/Australia"
        )

        questionsList.add(que2)
        //3
        val que3 = Question(
                3, "3.\tKtóre z prawicowych tygodników otrzymują najwięcej pieniędzy z reklam od spółek Skarbu Państwa w zamian za poparcie i szerzenie propagandy obecnego rządu ? ",
                "Newsweek,Rzeczpospolita, Gazeta Wyborcza", "Gazeta Polska, wSieci, Do Rzeczy",
                "Wprost, Angora, Przegląd ", "Tygodnik Powszechny, Gazeta Finansowa, Polityka", 2, "https://natemat.pl/301599,panstwowe-spolki-wydaly-na-reklamy-w-tvp-i-prawicowych-mediach-1-23-mld-zl#"
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "4.\tW latach 2015-2018 o ile, na koszt podatników, wzrosły wydatki Kancelarii Premiera ?",
                "20,3 mln zł", "47,5 mln zł",
                "45,9 mln zł", "195,7 mln zł", 4, "https://www.money.pl/gospodarka/wydatki-kancelarii-premiera-w-gore-dwukrotny-wzrost-w-trzy-lata-6410900376098433a.html?fbclid=IwAR3-Sdue-60uKI-d1SC4bqecYIMBjkUbQbiChjBlClqg2gBMGTqM2Bwci24"
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "5.\tKtóry z obecnych polityków PiS jeździł taksówką  z Wałbrzycha do Warszawy(460 km) na koszt podatników?",
                "Joachim Brudziński", "Marek Kuchciński",
                "Elżbieta Witek", "Patryk Jaki", 3, "https://www.fakt.pl/wydarzenia/polityka/poslanka-pis-elzbieta-witek-z-walbrzycha-do-warszawy-jechala-taksowka-460-kilometrow/qz1gydt"
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "6.\t \"Te pieniądze im się po prostu należały!\"- Kto wypowiedział te słowa broniąc nagród przyznanych politykom PiS?",
                "Beata Szydło", "Mateusz Morawiecki",
                "Jarosław Kaczyński", "Marek Suski", 1, "https://www.newsweek.pl/polska/polityka/te-pieniadze-im-sie-po-prostu-nalezaly-dlatego-ministrowie-rzadu-szydlo-nie-oddali/5dqskpm"
        )

        questionsList.add(que6)

        //7
        val que7 = Question(
                7, "7.\t \"LGBT  to nie ludzie, to ideologia \"– który polityk PiS wypowiedział te słowa na żywo w programie telewizyjnym ?",
                "Jacek Żalek", "Ryszard Czarnecki",
                "Andrzej Duda", "Janusz Kowalski", 1, "https://www.rp.pl/Polityka/200619803-LGBT-to-nie-ludzie-to-ideologia-Posel-Zalek-wyproszony-z-TVN24.html"
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "8.\tJak nazywa się posłanka PiS która pokazała środkowy palec do posłów opozycji ?",
                "Bernadetta Krynicka", "Joanna Lichocka",
                "Elżbieta Witek", "Krystyna Pawłowicz", 2, "https://www.rp.pl/Prawo-i-Sprawiedliwosc/200909761-Gest-Joanny-Lichockiej-Prezydium-Sejmu-uchylilo-kare.html"
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "9.\tKtóry z polityków PiS pobrał przez 3 lata 90 tys. złotych na  paliwo chociaż nie miał ani auta, ani prawa jazdy ? ",
                "Ryszard Czarnecki", "Adam Andruszkiewicz",
                "Marek Kuchciński", "Janusz Kowalski", 2, "https://wiadomosci.dziennik.pl/wydarzenia/artykuly/603310,andruszkiewicz-kilometrowki-paliwo-sejm.html"
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "10.\tIle pieniędzy polskich podatników zmarnował Jacek Sasin, za przeprowadzenie wyborów , które się nie odbyły ?",
                "13,8 mln zł", "27,55 mln zł",
                "29 mln zł", "68,8 mln zł", 4, "https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html"
        )

        questionsList.add(que10)

        val que11 = Question(
                11, "11.\tIle pieniędzy stracili Polacy w aferze spółki GetBack, która przez długi czas była chroniona przez PiS ?",
                "410 mln zł", "270 mln zł",
                "15 mln zł", "2,5 miliarda zł", 4, "https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html"
        )

        questionsList.add(que11)


        val que12 = Question(
                12, "12.\tIle pieniędzy z dolnośląskiego oddziału PCK wyprowadziła polityk PiS Anna Zalewska ?",
                "13,8 tys zł", "149 ts zł",
                "1200 tys  zł", "70 tys zł", 3, "https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html"
        )

        questionsList.add(que12)

        val que13 = Question(
                13, "13.\tJak się nazywa obecny prezes NIK, którego wyznaczył PiS , a który w posiadanej przez siebie kamienicy wynajmował pokoje na godziny dla mafii sutenerskiej?",
                "Krzysztof Kwiatkowski", "Marian Banaś",
                "Daniel Obajtek", "Jacek Sasin", 2, "https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html"
        )

        questionsList.add(que13)

        val que14 = Question(
                14, "14.\tIle kosztowały maseczki, które  nie nadawały się do użytku, a które osobiście odbierał M.Morawiecki  z samolotu Antonow An-225 Mrija?",
                "150 tys zł", "470 tys zł",
                "475 tys zł", "5,5 mln zł", 4, "https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html"
        )

        questionsList.add(que14)

        val que15 = Question(
                15, "15. Po  bezpośrednio jakim wydarzeniu PiS doprowadził do zniszczenia programu trzeciego Polskiego Radia? ",
                "Po zatrudnieniu Agnieszki Kamińskiej", "Po zmianach personalnych  ",
                "Po ocenzurowaniu piosenki 'Twój ból jest lepszy niz mój'", "Po zwolnieniu Marka Niedźwiedzkiego", 3, "https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html"
        )

        questionsList.add(que15)
        val que16 = Question(
                16, "16.\tKtóry polityk PiS latał samolotem razem ze swoją rodziną, oczywiście na koszt podatników ?",
                "Marek Kuchciński", "Ryszard Czarnecki",
                "Marek Suski", "Adam Bielan", 1, "https://www.onet.pl/?utm_source=100aferpis.pl_viasg_fakt&utm_medium=referal&utm_campaign=leo_automatic&srcc=ucs&pid=c3c650b1-3ef2-51d3-991b-56a57a034e19&sid=f13b499b-dba8-44e4-a9ae-cb9ebb087cc8&utm_v=2"
        )

        questionsList.add(que16)

        val que17 = Question(
                17, "17.Kim dla Martyny Wojciechowskiej(tzw. aniołka Glapińskiego) był właściciel firmy marketingowej Rochstar która wygrała przetarg ogłoszony przez NBP ?",
                "Zupełnie obcą osobą", "Znajomym",
                "Mężem jej siostry(szwagrem)", "Współpracownikiem w NBP", 3, "https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html"
        )

        questionsList.add(que17)

        val que18 = Question(
                18, "18.Ile w 2017 roku rozdała na nagrody ówczesna premier rządu PiS B.Szydło ? ",
                "13,7 mln zł", "14,7 mln zł",
                "37 mln zł", "113,7 mln zł", 4, "https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html"
        )

        questionsList.add(que18)
        val que19 = Question(
                19, "19.Ile każdego roku pieniędzy za rządów PiS idzie na podtrzymanie propagandy w mediach pseudo-publicznych ?",
                "10 mln zł", "2 miliardy zł",
                "27,5 mln zł", "15 mln zł", 2, "https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html"
        )

        questionsList.add(que19)

        val que20 = Question(
                20, "20.Ile  pieniędzy podatników  wydała PFN na akcje,, Sprawiedliwe Sądy”, oczerniającą i szkalującą polskich sędziów ?",
                "19 mln zł", "170 tys zł",
                "3 mln zł", "3,7 mln zł", 1, "https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html"
        )

        questionsList.add(que20)



        return questionsList

    }


}