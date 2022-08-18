package com.example.foodator.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.foodapp.LoginActivity
import com.example.foodapp.ProfileActivity
import com.example.foodapp.RegisterActivity
import com.example.foodator.R

class IntroActivity : AppCompatActivity() {

    lateinit var registerButton : Button
    lateinit var loginButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)


        registerButton =findViewById(R.id.bnt_register)
        registerButton.setOnClickListener{
            // Register()
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }
        loginButton = findViewById(R.id.bnt_login)
        loginButton.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}