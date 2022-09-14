package com.example.foodator.Activity
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.foodapp.LoginActivity
import com.example.foodapp.RegisterActivity
import com.example.foodator.R
import kotlinx.coroutines.NonCancellable.start

class startActivity : AppCompatActivity() {

    lateinit var registerButton : Button
    lateinit var loginButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        setContentView(R.layout.activity_start)
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