package sc.android.quizapp

object Constants {

    const val USERNAME: String = "user_name"
    const val TOTAL_QUESTIONS: String= "total_questions"
    const val CORRECT_ANSWERS: String="correct_answers"

    fun getQuestions() : List<Question>{

        val question1 = Question(
            id = 1,
            question = "Which country has this flag?",
            image = R.drawable.ic_flag_of_india,
            optionOne = "India",
            optionTwo = "Ireland",
            optionThree = "France",
            optionFour = "Italy",
            correctAnswer = 1
        )

        val question2 = Question(
            id = 2,
            question = "Which country's flag is this?",
            image = R.drawable.ic_flag_of_argentina,
            optionOne = "Uruguay",
            optionTwo = "Argentina",
            optionThree = "Chile",
            optionFour = "Paraguay",
            correctAnswer = 2
        )

        val question3 = Question(
            id = 3,
            question = "Which country's flag is this?",
            image = R.drawable.ic_flag_of_australia,
            optionOne = "New Zealand",
            optionTwo = "United Kingdom",
            optionThree = "Australia",
            optionFour = "Fiji",
            correctAnswer = 3
        )

        val question4 = Question(
            id = 4,
            question = "Which country's flag is this?",
            image = R.drawable.ic_flag_of_belgium,
            optionOne = "Germany",
            optionTwo = "Belgium",
            optionThree = "France",
            optionFour = "Romania",
            correctAnswer = 2
        )

        val question5 = Question(
            id = 5,
            question = "Which country's flag is this?",
            image = R.drawable.ic_flag_of_brazil,
            optionOne = "Brazil",
            optionTwo = "Portugal",
            optionThree = "Colombia",
            optionFour = "Mexico",
            correctAnswer = 1
        )

        val question6 = Question(
            id = 6,
            question = "Which country's flag is this?",
            image = R.drawable.ic_flag_of_denmark,
            optionOne = "Norway",
            optionTwo = "Switzerland",
            optionThree = "Sweden",
            optionFour = "Denmark",
            correctAnswer = 4
        )

        val question7 = Question(
            id = 7,
            question = "Which country's flag is this?",
            image = R.drawable.ic_flag_of_fiji,
            optionOne = "Fiji",
            optionTwo = "Australia",
            optionThree = "Samoa",
            optionFour = "New Zealand",
            correctAnswer = 1
        )

        val question8 = Question(
            id = 8,
            question = "Which country's flag is this?",
            image = R.drawable.ic_flag_of_germany,
            optionOne = "Belgium",
            optionTwo = "Austria",
            optionThree = "Germany",
            optionFour = "Netherlands",
            correctAnswer = 3
        )

        val question9 = Question(
            id = 9,
            question = "Which country's flag is this?",
            image = R.drawable.ic_flag_of_kuwait,
            optionOne = "Jordan",
            optionTwo = "Palestine",
            optionThree = "Kuwait",
            optionFour = "United Arab Emirates",
            correctAnswer = 3
        )

        val question10 = Question(
            id = 10,
            question = "Which country's flag is this?",
            image = R.drawable.ic_flag_of_new_zealand,
            optionOne = "Australia",
            optionTwo = "New Zealand",
            optionThree = "Fiji",
            optionFour = "Samoa",
            correctAnswer = 2
        )

        val questionsList = listOf(
            question1, question2, question3, question4, question5, question6, question7, question8, question9, question10
        )

        return questionsList
    }
}