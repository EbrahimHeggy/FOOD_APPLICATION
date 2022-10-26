package com.example.foodapp.database

import com.example.foodator.Activity.Domain.FoodDomain
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

      // foodapplicationecomercial.herokuapp.com/Home/allFoodProducts
    @GET("Home/allFoodProducts")
    fun getProducts() : Call<List<FoodDomain>>

   // https://foodapplicationecomercial.herokuapp.com/Home/UpdateProfile?newEmail=huda@33.com&newUsername=huda&newPassword=H5_h511115
    @POST("Home/UpdateProfile/")
     fun upateProfile(@Header("Authorization") Authorization: String, @Query("newEmail") newEmail: String, @Query("newUsername") newUsername:String, @Query("newPassword") newPassword:String): Call<String>?

    @POST("Home/UpdateProfile?newEmail=huda@33.com&newUsername=huda&newPassword=H5_h511116")
    fun upateProfile2(@Header("Authorization") Authorization: String): Call<String>?


}

var retrofit2 = Retrofit.Builder()
    .baseUrl("https://newsapi.org/")
    .addConverterFactory(GsonConverterFactory.create())
    .build().create(ApiInterface::class.java)

var retrofit = Retrofit.Builder()
    .baseUrl("https://foodapplicationecomercial.herokuapp.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var service: ApiInterface = retrofit.create(ApiInterface::class.java)