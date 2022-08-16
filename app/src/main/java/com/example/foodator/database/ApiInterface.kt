package com.example.foodapp.database

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiInterface {
   @POST("Home/Register")
    fun registerUser(@Body registerReqeust : RegisterRequstData): Call<Boolean>?

    @GET("Home/login")
     fun loginUser(@Query("email") email: String,@Query("password") password:String): Call<LoginResposeData?>?


   // fun getNews(@Query("category") category: String,@Query("apiKey") apiKey: String): Call<ApiResponse?>? //// return news


    @PUT("PUT/profile")
     fun upateProfile(@Body registerReqeust : RegisterRequstData): Call<Boolean>?


}
var retrofit = Retrofit.Builder()
    .baseUrl("https://intense-oasis-47535.herokuapp.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var service: ApiInterface = retrofit.create(ApiInterface::class.java)