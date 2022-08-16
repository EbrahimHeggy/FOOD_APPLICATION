package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.foodapp.database.LoginRequestData
import com.example.foodapp.database.RegisterRequstData
import com.example.foodapp.database.service
import com.example.foodator.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity(), Callback<Boolean> {
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

        var oldname = "HuDa"
      etName?.setText("$oldname", TextView.BufferType.EDITABLE)

        var oldEmail = "had@"
        etEmail?.setText("$oldEmail", TextView.BufferType.EDITABLE)

        var oldpassword="55"
      etPassword?.setText("$oldpassword", TextView.BufferType.EDITABLE)

        updateButton.setOnClickListener(){
                        var newName =etName?.text.toString()
                       var newEmail = etEmail?.text.toString()
                       var newPassword = etPassword?.text.toString()
           updatedData  =RegisterRequstData(newName,newEmail,newPassword)

            service.upateProfile(updatedData)?.enqueue(this)
        }

    }

//     fun upateProfile (updatedData:RegisterRequstData){
//        service.upateProfile(updatedData)?.enqueue(this)
//    }


    override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
        TODO("Not yet implemented")
    }

    override fun onFailure(call: Call<Boolean>, t: Throwable) {
        TODO("Not yet implemented")
    }
}