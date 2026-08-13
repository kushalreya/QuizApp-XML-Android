package sc.android.quizapp

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mUserName : String? = null
    private var mCurrentPosition : Int = 1
    private var mQuestionsList : List<Question> = Constants.getQuestions()
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers : Int = 0


    private var progressBar : ProgressBar? = null
    private var progressText : TextView? = null

    private var tv_question : TextView? = null
    private var iv_image : ImageView? = null

    private var option1 : TextView? = null
    private var option2 : TextView? = null
    private var option3 : TextView? = null
    private var option4 : TextView? = null
    private var submitButton : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mUserName = intent.getStringExtra(Constants.USERNAME)

        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.tv_progressText)

        tv_question = findViewById(R.id.tv_question)
        iv_image = findViewById(R.id.iv_image)

        option1 = findViewById(R.id.tv_optionOne)
        option1?.setOnClickListener(this)

        option2 = findViewById(R.id.tv_optionTwo)
        option2?.setOnClickListener(this)

        option3 = findViewById(R.id.tv_optionThree)
        option3?.setOnClickListener(this)

        option4 = findViewById(R.id.tv_optionFour)
        option4?.setOnClickListener(this)

        submitButton = findViewById(R.id.btn_submit)
        submitButton?.setOnClickListener(this)

        mSelectedOptionPosition = 0
        setQuestion()

    }

    private fun setQuestion() {

        defaultOptionsView()

        //re-enable options when setting question
        option1?.isEnabled = true
        option2?.isEnabled = true
        option3?.isEnabled = true
        option4?.isEnabled = true

        val question = mQuestionsList[mCurrentPosition - 1]

        progressBar?.progress = mCurrentPosition
        progressText?.text = "$mCurrentPosition/${progressBar?.max}"

        tv_question?.text = question.question
        iv_image?.setImageResource(question.image)

        option1?.text = question.optionOne
        option2?.text = question.optionTwo
        option3?.text = question.optionThree
        option4?.text = question.optionFour

        submitButton?.text = "Next"

    }

    //how each option would look
    private fun defaultOptionsView(){

        val optionsList = listOf(
            option1, option2, option3, option4
        )

        for (option in optionsList){
            option?.setTextColor("#60606F".toColorInt())
            option?.typeface = Typeface.DEFAULT
            option?.background = ContextCompat
                .getDrawable(this, R.drawable.default_border_bg)
        }

    }

    //how the selected option would look
    private fun selectedOptionView(tv : TextView, selectedOptionNumber : Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor("#5061CA".toColorInt())
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat
            .getDrawable(this, R.drawable.selected_border_bg)

        submitButton?.text = "Check Answer"

    }

    override fun onClick(view : View?) {

        when (view?.id){

            R.id.tv_optionOne -> {
                option1?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_optionTwo -> {
                option2?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_optionThree -> {
                option3?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_optionFour -> {
                option4?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btn_submit -> {

                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList.size -> { setQuestion() }
                        else -> {

                            val intent = Intent(this, ResultActivity:: class.java)

                            intent.putExtra(Constants.USERNAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList.size)

                            startActivity(intent)
                            finish()
                        }
                    }

                } else {

                    val question = mQuestionsList[mCurrentPosition - 1]

                    if (question.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.incorrect_border_bg)
                    } else { mCorrectAnswers++ }

                    answerView(question.correctAnswer, R.drawable.correct_border_bg)

                    // Disable options after checking the answer
                    option1?.isEnabled = false
                    option2?.isEnabled = false
                    option3?.isEnabled = false
                    option4?.isEnabled = false

                    mSelectedOptionPosition = 0

                    if (mCurrentPosition == mQuestionsList.size) {
                        submitButton?.text = "Submit"
                    } else {
                        submitButton?.text = "Next"
                    }

                }

            }

        }

    }

    private fun answerView(answer : Int, drawableView : Int) {

        when (answer) {

            1 -> {
                option1?.background = ContextCompat
                    .getDrawable(this, drawableView)
                option1?.setTextColor("#000000".toColorInt())
                option1?.setTypeface(option1?.typeface, Typeface.BOLD)
            }

            2 -> {
                option2?.background = ContextCompat
                    .getDrawable(this, drawableView)
                option2?.setTextColor("#000000".toColorInt())
                option2?.setTypeface(option2?.typeface, Typeface.BOLD)
            }

            3 -> {
                option3?.background = ContextCompat
                    .getDrawable(this, drawableView)
                option3?.setTextColor("#000000".toColorInt())
                option3?.setTypeface(option3?.typeface, Typeface.BOLD)
            }

            4 -> {
                option4?.background = ContextCompat
                    .getDrawable(this, drawableView)
                option4?.setTextColor("#000000".toColorInt())
                option4?.setTypeface(option4?.typeface, Typeface.BOLD)
            }

        }

    }

}