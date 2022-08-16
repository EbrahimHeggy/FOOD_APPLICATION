package com.example.foodapp.database

import com.google.gson.annotations.SerializedName

data class LoginResposeData(

    @SerializedName("email") var email       : String? = null,
    @SerializedName("username") var username : String? = null,
   // var token : String?= null
)
