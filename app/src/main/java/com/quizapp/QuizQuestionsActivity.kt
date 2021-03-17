package com.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

import com.quizapp.databinding.ActivityQuizQuestionsBinding
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null


    private var buttonClickCount: Int = 0
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0


    // Variable for getting the name from intent.)
    // START
    private var mUserName: String? = null
    // END

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_quiz_questions)


        // START
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        // END

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
        buttonNetLink.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.tv_option_one -> {

                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two -> {

                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three -> {

                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four -> {

                selectedOptionView(tv_option_four, 4)
            }

            R.id.btn_submit -> {


                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++
                    buttonClickCount++
                    buttonNetLink.visibility = View.GONE

                    when {

                        mCurrentPosition <= mQuestionsList!!.size -> {

                            setQuestion()
                        }
                        else -> {

                            //  Removing the toast message and launch the result screen which was created
                            // START
                            val intent =
                                    Intent(this@QuizQuestionsActivity, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                            // END
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {

                        startGameOverActivity()
                    } else {
                        mCorrectAnswers++
                        buttonNetLink.visibility = View.VISIBLE
                        linkButton()

                    }

                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "ZAKOŃCZ"
                    } else {
                        btn_submit.text = "NASTĘPNE PYTANIE"


                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    /**
     * A function for setting the question to UI components.
     */
    private fun setQuestion() {

        val question =
                mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "ZAKOŃCZ"
        } else {
            btn_submit.text = "POTWIERDŹ"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = question.question
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
                Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.selected_option_border_bg
        )
    }

    /**
     * A function to set default options view when the new question is loaded or when the answer is reselected.
     */
    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    R.drawable.default_option_border_bg
            )
        }
    }


    private fun startGameOverActivity() {
        var intent2 = Intent(this, GameOverActivity::class.java)
        startActivity(intent2)
    }

    /**
     * A function for answer view which is used to highlight the answer is wrong or right.
     */
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                        this@QuizQuestionsActivity,
                        drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                        this@QuizQuestionsActivity,
                        drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                        this@QuizQuestionsActivity,
                        drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                        this@QuizQuestionsActivity,
                        drawableView
                )
            }
        }
    }


    fun linkButton() {


        var browserIntent: Intent



        buttonNetLink.setOnClickListener {

            if (buttonClickCount == 0) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.wirtualnemedia.pl/artykul/wybory-samorzadowe-ii-tura-wyniki-w-tvp-info-niestety-plazynski-przegral-dane-trzaskowskiego-i-jakiego-z-wiezien")

                )
                startActivity(browserIntent)

            } else if (buttonClickCount == 1) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.wprost.pl/wybory-prezydenckie-2020/10342823/holecka-do-prezydenta-w-tvp-co-zrobic-zeby-rzeczywiscie-to-pan-wygral.html")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 2) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://natemat.pl/301599,panstwowe-spolki-wydaly-na-reklamy-w-tvp-i-prawicowych-mediach-1-23-mld-zl")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 3) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.money.pl/gospodarka/wydatki-kancelarii-premiera-w-gore-dwukrotny-wzrost-w-trzy-lata-6410900376098433a.html?fbclid=IwAR3-Sdue-60uKI-d1SC4bqecYIMBjkUbQbiChjBlClqg2gBMGTqM2Bwci24")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 4) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.fakt.pl/wydarzenia/polityka/poslanka-pis-elzbieta-witek-z-walbrzycha-do-warszawy-jechala-taksowka-460-kilometrow/qz1gydt")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 5) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.newsweek.pl/polska/polityka/te-pieniadze-im-sie-po-prostu-nalezaly-dlatego-ministrowie-rzadu-szydlo-nie-oddali/5dqskpm")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 6) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.rp.pl/Polityka/200619803-LGBT-to-nie-ludzie-to-ideologia-Posel-Zalek-wyproszony-z-TVN24.html")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 7) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.rp.pl/Prawo-i-Sprawiedliwosc/200909761-Gest-Joanny-Lichockiej-Prezydium-Sejmu-uchylilo-kare.html")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 8) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://wiadomosci.dziennik.pl/wydarzenia/artykuly/603310,andruszkiewicz-kilometrowki-paliwo-sejm.html")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 9) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.money.pl/gospodarka/prawie-70-mln-zlotych-za-wybory-ktorych-nie-bylo-6514740942337665a.html")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 10) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://natemat.pl/240923,o-co-chodzi-w-aferze-getback-o-wielkie-pieniadze-i-uklad-powiazan-z-wladza")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 11) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://natemat.pl/246917,anna-zalewska-nowe-informacje-na-temat-afery-z-pck")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 12) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://gazetakrakowska.pl/krakow-turysci-o-kamienicy-szefa-nik-slychac-bylo-odglosy-orgii/ar/c1-14456299")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 13) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://tech.wp.pl/antonov-225-dostarczyl-do-polski-felerne-maseczki-ministerstwo-zdrowia-maski-nie-spelniaja-norm-6511914547255425a")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 14) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://wiadomosci.onet.pl/kraj/afera-w-trojce-cenzura-kazika-morawiecki-komentuje/6ceznm0")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 15) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.onet.pl/?utm_source=100aferpis.pl_viasg_fakt&utm_medium=referal&utm_campaign=leo_automatic&srcc=ucs&pid=c3c650b1-3ef2-51d3-991b-56a57a034e19&sid=f13b499b-dba8-44e4-a9ae-cb9ebb087cc8&utm_v=2")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 16) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.donald.pl/artykuly/Tu2pAUzR/twitter-przypomina-w-firmie-rochstar-ktora-wygrala-przetarg-w-nbp-wart-6-mln-zl-pracuje-szwagier-slynnej-rusycystki")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 17) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://businessinsider.com.pl/polityka/nagrody-w-rzadzie-pis-ministrowie-rozdali-113-mln-zl/2pqbvy2")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 18) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(
                                "https://www.rp.pl/Media/201129506-Projekt-budzetu-Kolejne-2-miliardy-zl-dla-TVP.html")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 19) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(
                                "https://www.tvn24.pl/wiadomosci-z-kraju,3/afera-billboardowa-rada-polskiej-fundacji-narodowej-zajmie-sie-kampania,774426.html")
                )
                startActivity(browserIntent)
            } else if (buttonClickCount == 20) {
                browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(
                                "https://wiadomosci.wp.pl/kaczynski-do-niepelnosprawnej-prosze-nas-popierac-a-nie-przeszkadzac-6376012850038913a")
                )
                startActivity(browserIntent)
            }


        }


    }


}


