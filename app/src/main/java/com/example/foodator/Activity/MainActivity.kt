package com.example.foodator.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.ProfileActivity
import com.example.foodator.Activity.Adapter.CategoryAdapter
import com.example.foodator.Activity.Adapter.PopularAdapter
import com.example.foodator.Activity.Domain.CategoryDomain
import com.example.foodator.Activity.Domain.FoodDomain
import com.example.foodator.R

class MainActivity : AppCompatActivity() {
  lateinit var adapter2 : PopularAdapter
   lateinit var adapter:CategoryAdapter

//  lateinit var adapter2 : RecyclerView.Adapter

    lateinit var recyclerViewCategoryList: RecyclerView
    lateinit var recyclerViewPopularList: RecyclerView
    lateinit var profile:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        profile=findViewById(R.id.profile)

        recyclerViewCategory()
        recyclerViewPopular()

        profile.setOnClickListener(){
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }



    private fun recyclerViewCategory() {
      val  linearLayoutManager  = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewCategoryList=findViewById(R.id.recyclerView)
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager)

        val category : ArrayList<CategoryDomain>  = ArrayList()
        category.add(CategoryDomain("Pizza","cat_1"))
        category.add(CategoryDomain("Burger","cat_2"))
        category.add(CategoryDomain("Hotdog","cat_3"))
        category.add(CategoryDomain("Drink","cat_4"))
        category.add(CategoryDomain("Donat","cat_5"))

        adapter= CategoryAdapter(category)
        recyclerViewCategoryList.setAdapter(adapter)
    }

    private fun recyclerViewPopular() {
        val  linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewPopularList=findViewById(R.id.recyclerView2)
        recyclerViewPopularList.setLayoutManager(linearLayoutManager)

        val FoodList : ArrayList<FoodDomain>  = ArrayList()
        FoodList.add(FoodDomain("Pepproni Pizza","pizza1","slices pepproni",9.76))
        FoodList.add(FoodDomain("Cheese Burger","burger","beef,cheese",10.0))
        FoodList.add(FoodDomain("Vegetables Pizza","pizza2","slices vegetables ",8.0))

         adapter2 = PopularAdapter(FoodList)
        recyclerViewPopularList.setAdapter(adapter2)
    }

}