package com.example.foodapp.database

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiInterface {
   @POST("Home/register")
    fun registerUser(@Body registerReqeust : RegisterRequstData): Call<Boolean>?
   // https://foodapplicationecomercial.herokuapp.com/Home/login?email=huda@33.com&password=554

    @GET("Home/login")
     fun loginUser(@Query("email") email: String,@Query("password") password:String): Call<LoginResposeData?>?


   // fun getNews(@Query("category") category: String,@Query("apiKey") apiKey: String): Call<ApiResponse?>? //// return news


//    @Headers(
//        {
//            "Authorization:"
//        }
//    )
   // https://foodapplicationecomercial.herokuapp.com/Home/UpdateProfile?newEmail=huda@33.com&newUsername=huda&newPassword=H5_h511115
    @POST("Home/UpdateProfile/")
     fun upateProfile(@Header("Authorization") Authorization: String, @Query("newEmail") newEmail: String, @Query("newUsername") newUsername:String, @Query("newPassword") newPassword:String): Call<String>?

    @POST("Home/UpdateProfile?newEmail=huda@33.com&newUsername=huda&newPassword=H5_h511116")
    fun upateProfile2(@Header("Authorization") Authorization: String): Call<String>?


}

var retrofit = Retrofit.Builder()
    .baseUrl("https://foodapplicationecomercial.herokuapp.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var service: ApiInterface = retrofit.create(ApiInterface::class.java)