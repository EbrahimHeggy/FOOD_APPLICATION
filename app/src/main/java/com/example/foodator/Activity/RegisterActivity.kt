package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.foodapp.database.LoginRequestData
import com.example.foodapp.database.RegisterRequstData
import com.example.foodapp.database.service
import com.example.foodator.R
import com.ntgclarity.authenticator.database.User
import com.ntgclarity.authenticator.database.UsersDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity()  , Callback<Boolean> {

    // var registerData : RegisterRequstData = RegisterRequstData()
   // var registerData : RegisterRequstData = RegisterRequstData("huda","huda@12","5222")
    var etName: EditText? = null
    var etEmail: EditText? = null
    var etPassword: EditText? = null
    var conPassword: EditText? = null
  //  var database: UsersDatabase? = null
    lateinit var registerData : RegisterRequstData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_main)

        etName = findViewById<EditText>(R.id.User)
        etEmail = findViewById<EditText>(R.id.mail)
        etPassword = findViewById<EditText>(R.id.pass)
      //  conPassword = findViewById<EditText>(R.id.co_pass)
        val btnreg = findViewById<Button>(R.id.bnt_register)


        btnreg.setOnClickListener(){
            var userName =etName?.text.toString()
            var password = etPassword?.text.toString()
            var email = etEmail?.text.toString()
         if(userName !=""&& password!="" && email !="")    {
             if(email.contains('@')){
                 registerData  =RegisterRequstData(email,userName, password )
                 service.registerUser(registerData)?.enqueue(this)

             }else{Toast.makeText(this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show()}

         }else{ Toast.makeText(this, "Please Fill All Data", Toast.LENGTH_SHORT).show()}


        }

//        database = Room.databaseBuilder(this, UsersDatabase::class.java, "users.db")
//            .allowMainThreadQueries()
//            .build()
//
//        btnreg.setOnClickListener {
//            saveToDatabase()
//            logUsers()
//            finish()
//        }
    }
    suspend fun register (){
        service.registerUser(registerData)?.enqueue(this)
    }

//
//    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
//                if(response.isSuccessful){
//            Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, LoginActivity::class.java)
//                    startActivity(intent)
//
//             }
//                else
//                    Toast.makeText(this, "Register Failed Please Try Again", Toast.LENGTH_SHORT).show()
//
//    }
//
//    override fun onFailure(call: Call<Unit>, t: Throwable) {
//        Toast.makeText(this, "Register Failed Please Try Again2222222222", Toast.LENGTH_SHORT).show()
//    }

    override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                        if(response.body()==true){
            Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                            println(response.body())
                            println("#######################33")

             }
                else if(response.body()==false){
                    Toast.makeText(this, "Already Have Account", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            println(response.body())
                            println("#######################55555555")

                        }

    }

    override fun onFailure(call: Call<Boolean>, t: Throwable) {

    }

//    fun logUsers() {
//        val users = database?.userDao()?.getAllUsers()
//        Log.d("###", users.toString())
//    }
//
//    fun saveToDatabase() {
//        val name = etName?.text.toString()
//        val email = etEmail?.text.toString()
//        val password = etPassword?.text.toString()
//        val confermpassword = conPassword?.text.toString()
//        val user = User(name = name, email = email, password = password, con_password = confermpassword)
//        database?.userDao()?.insertUser(user)
//    }
}


