package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.foodapp.database.RegisterRequstData
import com.example.foodapp.database.service
import com.example.foodator.R
import com.example.foodator.database.Storage
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity(), Callback<String> {
    var etName: EditText? = null
    var etEmail: EditText? = null
    var etPassword: EditText? = null
    lateinit var updateButton : Button
    lateinit var updatedData : RegisterRequstData
  //  var updatedData : RegisterRequstData = RegisterRequstData("huda","5555")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        etName = findViewById<EditText>(R.id.et_username)
        etEmail = findViewById<EditText>(R.id.et_mail)
        etPassword = findViewById<EditText>(R.id.et_pass)
       updateButton = findViewById<Button>(R.id.bnt_update)

        var oldname = Storage.username
      etName?.setText("$oldname", TextView.BufferType.EDITABLE)

        var oldEmail = Storage.email
        etEmail?.setText("$oldEmail", TextView.BufferType.EDITABLE)

        var oldpassword="......."
      etPassword?.setText("$oldpassword", TextView.BufferType.EDITABLE)

        updateButton.setOnClickListener(){
                        var newName =etName?.text.toString()
                       var newEmail = etEmail?.text.toString()
                       var newPassword = etPassword?.text.toString()
           updatedData  =RegisterRequstData(newName,newEmail,newPassword)

            println("${Storage.token}")
            println(newEmail)
            println(newName)
            println(newPassword)
            println("#####33")
//            service.upateProfile("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodWRhQDMzLmNvbSIsImlhdCI6MTY2MDgxMjg1MiwiZXhwIjoxNjYwODEzNzUyfQ.4yXlrGJVJBUwYIjtRSGjSFMGPboAMmQnU7-41LMx-XDvV91_wxoXe8bSbCAehorko5rPY9KI2ltkWI8S9g6v5w"
//                ,newEmail,newName,"H5_h511111")?.enqueue(this)

            service.upateProfile2("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodWRhQDMzLmNvbSIsImlhdCI6MTY2MDgxMjg1MiwiZXhwIjoxNjYwODEzNzUyfQ.4yXlrGJVJBUwYIjtRSGjSFMGPboAMmQnU7-41LMx-XDvV91_wxoXe8bSbCAehorko5rPY9KI2ltkWI8S9g6v5w"
                )?.enqueue(this)
            println("${Storage.token}")
        }

    }

//     fun upateProfile (updatedData:RegisterRequstData){
//        service.upateProfile(updatedData)?.enqueue(this)
//    }




    override fun onResponse(call: Call<String>, response: Response<String>) {

         println(response.code())
        println(response.message())
        println(response.errorBody().toString())
        val gson = Gson()
        println(gson.toJson(response.body()))
        Toast.makeText(this, "${gson.toJson(response.body())}", Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(call: Call<String>, t: Throwable) {
        Toast.makeText(this, "faaaaail", Toast.LENGTH_SHORT).show()

    }
}