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
        lista.add((FoodDomain("Pizza","Pepproni Pizza","pizza1","slices pepproni",9.76)))
        lista.add(FoodDomain("Burger","Cheese Burger","burger","beef,cheese",10.0))
        lista.add(FoodDomain("Special Pizza","Vegetables Pizza","pizza2","slices vegetables ",8.0))
    return lista
    }

    private fun recyclerViewPopular() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
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