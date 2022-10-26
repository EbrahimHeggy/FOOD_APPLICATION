package com.example.foodator.database

import com.example.foodator.Activity.Domain.CategoryDomain
import com.example.foodator.Activity.Domain.FoodDomain
import com.example.foodator.R

object Products  {
    val products : ArrayList<FoodDomain>  = fillData( ArrayList<FoodDomain>())

    fun fillData( lista : ArrayList<FoodDomain>): ArrayList<FoodDomain>{
        lista.add(FoodDomain("Pizza","Motzarilla Pizza","pop_5","cheese Pizza ",15.69,R.drawable.pop_5))
        lista.add((FoodDomain("Pizza","Pepproni Pizza","Drink_3","slices pepproni",9.76, R.drawable.pop_1)))
        lista.add(FoodDomain("Pizza","Vegetables Pizza","pizza2","slices vegetables ",8.0,R.drawable.pop_3))
        lista.add(FoodDomain("Drink","Strawberry Juice","cocktail","Fresh Slices Strawberry ",10.0,R.drawable.cocktail))
        lista.add(FoodDomain("Drink","Orange Juice","download_cocktail_glass_png_images_background_cold_drinks_png_png_for_free_download_dlpng","Fresh orange with little sugar ",7.0,R.drawable.download_cocktail_glass_png_images_background_cold_drinks_png_png_for_free_download_dlpng))
        lista.add(FoodDomain("Drink","Mango Juice","Drink_3","Fresh Mangoooo ",14.0,R.drawable.drink_3))
        lista.add(FoodDomain("Burger","Beef Burger","burger","slice Chicken  ",20.65,R.drawable.burder1))
        lista.add(FoodDomain("Burger","Chicken Burger","burger","beef,cheese",18.0,R.drawable.burger2))
        lista.add(FoodDomain("Burger","Double Chicken Burger","burger","beef,cheese",25.0,R.drawable.burger3))
        lista.add(FoodDomain("Burger","Double Beef Burger","burger","beef,cheese",30.0,R.drawable.burger4))
        lista.add(FoodDomain("Burger","Godzilla Burger","burger","beef,cheese",35.0,R.drawable.pop_2))
        lista.add(FoodDomain("Burger","Cheese Beef Burger","burger","cheese burger",37.0,R.drawable.burger5))
        lista.add(FoodDomain("Dishes","Chicken","burger","Chicken",37.0,R.drawable.d1))
        lista.add(FoodDomain("Dishes","special Chicken","burger","beef,cheese",37.0,R.drawable.d2))
        lista.add(FoodDomain("Dishes","Sushi","burger","fishes",37.0,R.drawable.d3))
        lista.add(FoodDomain("Dishes","special Dish","burger","beef,chicken,cheese",37.0,R.drawable.d4))
        lista.add(FoodDomain("Dishes","Botato","burger","beef,Botato",37.0,R.drawable.d5))



//        lista.add(FoodDomain("MACDONALDS","Big Mac ","pop_6","3 Slices of Burger with Botato ",17.32,R.drawable.pop_6))
//        lista.add(FoodDomain("Special Pizza","Zenger Pizza","pop_7","lahabino small slices Chicken  ",23.0,R.drawable.pop_7))
//        lista.add(FoodDomain("Special Pizza","Sousess Pizza","pop_8","tiny circle hot dog Slices  ",18.0,R.drawable.pop_8))
        return lista
    }


}
