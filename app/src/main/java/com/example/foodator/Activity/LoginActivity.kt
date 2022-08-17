package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.foodapp.database.LoginRequestData
import com.example.foodapp.database.LoginResposeData
import com.example.foodapp.database.RegisterRequstData
import com.example.foodapp.database.service
import com.example.foodator.Activity.MainActivity
import com.example.foodator.R
import com.example.foodator.database.Storage
import com.ntgclarity.authenticator.database.UsersDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), Callback<LoginResposeData?>{
    var etEmail: EditText? = null
    var etPassword: EditText? = null
    lateinit var loginButton : Button
    lateinit var lodinData : LoginRequestData
    var loginData :LoginRequestData = LoginRequestData("huda","5555")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
       checkToken()

        etEmail = findViewById<EditText>(R.id.et_Email)
        etPassword = findViewById<EditText>(R.id.et_Password)
        loginButton =findViewById<Button>(R.id.bnt_login_loginpage)

        loginButton.setOnClickListener(){
            var email = etEmail?.text.toString()
            var password = etPassword?.text.toString()

            if( password!="" && email !="")    {
                service.loginUser(email,password)?.enqueue(this)


            }else{ Toast.makeText(this, "Please Fill All Data", Toast.LENGTH_SHORT).show()}


        }

          //  lodinData  = LoginRequestData(newEmail,newPassword)


        }







//    suspend fun Login (){
//     service.loginUser(loginData)?.enqueue(this)
//    }
    override fun onResponse(call: Call<LoginResposeData?>, response: Response<LoginResposeData?>) {
    println("--------------"+response.body()?.email)
    println("--------------"+response.code())
    println("--------------"+response.message())
            if(response.body()?.token!=null){
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                Storage.token=response.body()?.token
                checkToken()
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
            }
            else if(response.body()?.email==null){
                Toast.makeText(this, "There Is No Account Found ,Please Register First", Toast.LENGTH_SHORT).show()

            }

    }

    override fun onFailure(call: Call<LoginResposeData?>, t: Throwable) {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()

    }

        fun checkToken()
    {
        if(Storage.token!=null)
        {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }

//    override fun onResponse(call: Call<Unit?>, response: Response<Unit?>) {
//        if(response.isSuccessful){
//            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
//        }
////        response.code()==200
//        TODO("Not yet implemented")
//    }
//
//    override fun onFailure(call: Call<Unit?>, t: Throwable) {
//        TODO("Not yet implemented")
//    }
}