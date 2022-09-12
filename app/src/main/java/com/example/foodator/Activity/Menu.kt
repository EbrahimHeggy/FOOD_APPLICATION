package com.example.foodator.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodator.Activity.Adapter.MenuAdapter
import com.example.foodator.Activity.Adapter.PopularAdapter
import com.example.foodator.Activity.Domain.FoodDomain
import com.example.foodator.R
import com.example.foodator.database.CurrentCategory
import com.example.foodator.database.Products

class Menu : AppCompatActivity() {
    lateinit var adapter3: MenuAdapter
    lateinit var recyclerViewMenuList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        recyclerViewPopular()
    }


    private fun recyclerViewPopular() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewMenuList = findViewById(R.id.recyclerView3)
        recyclerViewMenuList.setLayoutManager(linearLayoutManager)
        //recyclerViewMenuList.setLayoutManager(GridLayoutManager(this, 2))

        val FoodList: ArrayList<FoodDomain> = ArrayList()
//        FoodList.add((FoodDomain("Pizza","Pepproni Pizza","pizza1","slices pepproni",9.76)))
//        FoodList.add(FoodDomain("Burger","Cheese Burger","burger","beef,cheese",10.0))
//        FoodList.add(FoodDomain("Special Pizza","Vegetables Pizza","pizza2","slices vegetables ",8.0))

//        adapter3 = PopularAdapter(Products.products)

        println(CurrentCategory.currentcategory)
       if(CurrentCategory.currentcategory=="pizza"){
           println(CurrentCategory.currentcategory)
           val PizzaList: ArrayList<FoodDomain>
           PizzaList= Products.products?.filter {it.category=="Pizza"} as ArrayList<FoodDomain>
           adapter3 = MenuAdapter(PizzaList)
           recyclerViewMenuList.setAdapter(adapter3)
       }
        else if(CurrentCategory.currentcategory=="burger"){
           val BurgerList: ArrayList<FoodDomain>
           BurgerList= Products.products?.filter {it.category=="Burger"} as ArrayList<FoodDomain>
           adapter3 = MenuAdapter(BurgerList)
           recyclerViewMenuList.setAdapter(adapter3)
        }
       else if(CurrentCategory.currentcategory=="drink"){
           val DrinkList: ArrayList<FoodDomain>
           DrinkList= Products.products?.filter {it.category=="Drink"} as ArrayList<FoodDomain>
           adapter3 = MenuAdapter(DrinkList)
           recyclerViewMenuList.setAdapter(adapter3)

       }
    }
}