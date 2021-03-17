package com.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.quizapp.databinding.ActivityMainBinding
import com.quizapp.musicService.BackgroundSoundService

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        //Calling the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnOurMission.setOnClickListener {
            val intent = Intent(this, AppMissionActivity::class.java)
            startActivity(intent)
        }
        binding.btnAboutApp.setOnClickListener {
            val intent = Intent(this, AboutQuizActivity::class.java)
            startActivity(intent)
        }
        binding.btnStartQuiz.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            startActivity(intent)
        }
        //Commented for not showing this button
        /*  binding.btnSupportUs.setOnClickListener {
              val intent=Intent(this,SupportUsActivity::class.java)
              startActivity(intent)
          } */

        PlayBackgroundSound()

        button = findViewById(R.id.btn_our_mission)
        btn_our_mission

    }


    fun PlayBackgroundSound() {
        val intent = Intent(this@MainActivity, BackgroundSoundService::class.java)
        startService(intent)
    }

}
