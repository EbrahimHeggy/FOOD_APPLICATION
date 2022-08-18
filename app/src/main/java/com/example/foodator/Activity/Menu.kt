package com.example.foodator.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodator.Activity.Adapter.PopularAdapter
import com.example.foodator.Activity.Domain.FoodDomain
import com.example.foodator.R
import com.example.foodator.database.Products

class Menu : AppCompatActivity() {
    lateinit var adapter3: PopularAdapter
    lateinit var recyclerViewMenuList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        recyclerViewPopular()
    }

    fun fillData( lista : ArrayList<FoodDomain>): ArrayList<FoodDomain>{
        lista.add((FoodDomain("Pizza","Pepproni Pizza","Drink_3","slices pepproni",9.76)))
        lista.add(FoodDomain("Burger","Cheese Burger","burger","beef,cheese",10.0))
        lista.add(FoodDomain("Pizza","Vegetables Pizza","pizza2","slices vegetables ",8.0))
        lista.add(FoodDomain("Drink","Strawberry Juice","Drink_1","Fresh Slices Strawberry ",10.0))
        lista.add(FoodDomain("Drink","Orange Juice","Drink_3","Fresh orange with little sugar ",7.0))
        lista.add(FoodDomain("Drink","Mango Juice","Drink_3","Fresh Mangoooo ",14.0))
        lista.add(FoodDomain("Chicken","Chicken magdo","pop_4","slice Chicken  ",20.65))
        lista.add(FoodDomain("Pizza","Motzarilla Pizza","pop_5","cheese Pizza ",15.69))
        lista.add(FoodDomain("MACDONALDS","Big Mac ","pop_6","3 Slices of Burger with Botato ",17.32))
        lista.add(FoodDomain("Special Pizza","Zenger Pizza","pop_7","lahabino small slices Chicken  ",23.0))
        lista.add(FoodDomain("Special Pizza","Sousess Pizza","pop_8","tiny circle hot dog Slices  ",18.0))
    return lista
    }

    private fun recyclerViewPopular() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewMenuList = findViewById(R.id.recyclerView3)
        recyclerViewMenuList.setLayoutManager(linearLayoutManager)

        val FoodList: ArrayList<FoodDomain> = ArrayList()
//        FoodList.add((FoodDomain("Pizza","Pepproni Pizza","pizza1","slices pepproni",9.76)))
//        FoodList.add(FoodDomain("Burger","Cheese Burger","burger","beef,cheese",10.0))
//        FoodList.add(FoodDomain("Special Pizza","Vegetables Pizza","pizza2","slices vegetables ",8.0))

//        adapter3 = PopularAdapter(Products.products)

        adapter3 = PopularAdapter(fillData(FoodList))
        recyclerViewMenuList.setAdapter(adapter3)
    }
}