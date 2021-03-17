package com.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.quizapp.databinding.ActivityGameOverBinding


class GameOverActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameOverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_over)



        binding.tryAgainButton.setOnClickListener {
            val intent3 = Intent(this, QuizQuestionsActivity::class.java)
            startActivity(intent3)
        }
    }


}