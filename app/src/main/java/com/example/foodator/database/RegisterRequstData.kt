package com.example.foodapp.database

import com.google.gson.annotations.SerializedName

data class RegisterRequstData(

    var email      : String? = null,
    var username       : String? = null,
    var password          : String? = null,
)
