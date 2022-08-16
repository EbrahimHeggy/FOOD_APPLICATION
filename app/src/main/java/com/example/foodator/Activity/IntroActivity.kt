package com.example.foodator.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.foodapp.WelcomeActivity
import com.example.foodator.R

class IntroActivity : AppCompatActivity() {

      lateinit var startBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        startBtn=findViewById(R.id.btn_start)
        startBtn.setOnClickListener(){
                val intent = Intent(this,WelcomeActivity::class.java)
                startActivity(intent)
        }
    }
}