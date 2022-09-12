package com.example.foodator.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.ProfileActivity
import com.example.foodator.Activity.Adapter.CategoryAdapter
import com.example.foodator.Activity.Adapter.PopularAdapter
import com.example.foodator.Activity.Domain.CategoryDomain
import com.example.foodator.Activity.Domain.FoodDomain
import com.example.foodator.R
import com.example.foodator.database.CurrentCategory
import com.example.foodator.database.Storage

class MainActivity : AppCompatActivity(),CategoryAdapter.OnItemClickListener {
  lateinit var adapter2 : PopularAdapter
   lateinit var adapter:CategoryAdapter

//  lateinit var adapter2 : RecyclerView.Adapter

    lateinit var recyclerViewCategoryList: RecyclerView
    lateinit var recyclerViewPopularList: RecyclerView
    lateinit var profile:TextView
    lateinit var tv_3 :TextView
    lateinit var iv_Lougout :ImageView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        profile=findViewById(R.id.profile)
        tv_3=findViewById(R.id.textView3)
        iv_Lougout=findViewById(R.id.imageView2)


        iv_Lougout.setOnClickListener(){
            Storage.token=null
            val intent = Intent(this, startActivity()::class.java)
            intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        tv_3.text = "${tv_3.text}${Storage.username}"
        recyclerViewCategory()
        recyclerViewPopular()
        bottomnavbar()


        profile.setOnClickListener(){
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    fun bottomnavbar(){
        var cartbtn=findViewById<ImageButton>(R.id.cartBtn)
        var homebtn =findViewById<LinearLayout>(R.id.homeBtn)

        cartbtn.setOnClickListener(){
            val intent = Intent(this, CartListActivity::class.java)
            startActivity(intent)
        }
        homebtn.setOnClickListener(){
            cartbtn.setOnClickListener(){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
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

        adapter= CategoryAdapter(category,this)
        recyclerViewCategoryList.setAdapter(adapter)
    }

    private fun recyclerViewPopular() {
        val  linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewPopularList=findViewById(R.id.recyclerView2)
        recyclerViewPopularList.setLayoutManager(linearLayoutManager)

        val FoodList : ArrayList<FoodDomain>  = ArrayList()
        FoodList.add(FoodDomain("Pizza","Pepproni Pizza","pizza1","slices pepproni",9.76,R.drawable.pop_1))
        FoodList.add(FoodDomain("Burger","Cheese Burger","burger","beef,cheese",10.0,R.drawable.pop_2))
        FoodList.add(FoodDomain("Special Pizza","Vegetables Pizza","pizza2","slices vegetables ",8.0,R.drawable.pop_3))
         adapter2 = PopularAdapter(FoodList)
        recyclerViewPopularList.setAdapter(adapter2)
    }

    override fun onItemClick(category: String) {
        CurrentCategory.currentcategory=category
        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
    }


}