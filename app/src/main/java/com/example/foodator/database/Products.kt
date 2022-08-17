package com.example.foodator.database

import com.example.foodator.Activity.Domain.CategoryDomain
import com.example.foodator.Activity.Domain.FoodDomain

object Products {
    val products : ArrayList<FoodDomain>  = ArrayList()


    fun fillData(){
        products.add((FoodDomain("Pizza","Pepproni Pizza","pizza1","slices pepproni",9.76)))
        products.add(FoodDomain("Burger","Cheese Burger","burger","beef,cheese",10.0))
        products.add(FoodDomain("Special Pizza","Vegetables Pizza","pizza2","slices vegetables ",8.0))
    }
}
