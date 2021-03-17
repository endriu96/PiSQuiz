package com.quizapp

//Question constructor but at this moment last ,,uri" parameter does not have any impact
data class Question(
        val id: Int,
        val question: String,
        val optionOne: String,
        val optionTwo: String,
        val optionThree: String,
        val optionFour: String?,
        val correctAnswer: Int,
        val uri: String
)


