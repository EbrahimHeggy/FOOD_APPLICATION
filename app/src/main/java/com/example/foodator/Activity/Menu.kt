package com.example.foodator.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.database.retrofit
import com.example.foodapp.database.retrofit2
import com.example.foodator.Activity.Adapter.MenuAdapter
import com.example.foodator.Activity.Adapter.PopularAdapter
import com.example.foodator.Activity.Domain.FoodDomain
import com.example.foodator.R
import com.example.foodator.database.CurrentCategory
import com.example.foodator.database.Products
import com.example.foodator.helper.ManagmentCart
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Menu : AppCompatActivity() {
     var adapter3: MenuAdapter?=null
    lateinit var recyclerViewMenuList: RecyclerView
    lateinit var managementcart:ManagmentCart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        recyclerViewPopular()
        requestProducts()

    }


    private fun recyclerViewPopular() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewMenuList = findViewById(R.id.recyclerView3)
        recyclerViewMenuList.setLayoutManager(linearLayoutManager)
        //recyclerViewMenuList.setLayoutManager(GridLayoutManager(this, 2))
        val i =intent
        managementcart = ManagmentCart(this,i.getStringExtra("token").toString())
        println(CurrentCategory.currentcategory)
       if(CurrentCategory.currentcategory=="pizza"){
           println(CurrentCategory.currentcategory)
           val PizzaList: ArrayList<FoodDomain>
           PizzaList= Products.products?.filter {it.category=="Pizza"} as ArrayList<FoodDomain>
//           adapter3 = MenuAdapter(emptyList<FoodDomain>())
           adapter3 = MenuAdapter(PizzaList,managementcart.token)
           recyclerViewMenuList.setAdapter(adapter3)
       }

        else if(CurrentCategory.currentcategory=="burger"){
           val BurgerList: ArrayList<FoodDomain>
           BurgerList= Products.products?.filter {it.category=="Burger"} as ArrayList<FoodDomain>
           adapter3 = MenuAdapter(BurgerList,managementcart.token)
           recyclerViewMenuList.setAdapter(adapter3)
        }
       else if(CurrentCategory.currentcategory=="drink"){
           val DrinkList: ArrayList<FoodDomain>
           DrinkList= Products.products?.filter {it.category=="Drink"} as ArrayList<FoodDomain>
           adapter3 = MenuAdapter(DrinkList,managementcart.token)
           recyclerViewMenuList.setAdapter(adapter3)

       } else if(CurrentCategory.currentcategory=="Dishes"){
           val dishList: ArrayList<FoodDomain>
           dishList= Products.products?.filter {it.category=="Dishes"} as ArrayList<FoodDomain>
           adapter3 = MenuAdapter(dishList,managementcart.token)
           recyclerViewMenuList.setAdapter(adapter3)

       }
    }

    private fun requestProducts(){
        retrofit2.getProducts().enqueue(object : Callback<List<FoodDomain>>{

            override fun onResponse(call: Call<List<FoodDomain>>, response: Response<List<FoodDomain>>
            ) {
                if(response.isSuccessful){
                    Log.d("****","onResponse ${response.body().toString()}")
                    adapter3?.FoodList= response.body()
                    adapter3?.notifyDataSetChanged()
                }else{
                    Log.d("***","onResponse ${response.code()}")


                }
            }

            override fun onFailure(call: Call<List<FoodDomain>>, t: Throwable) {
                Log.d("***","onResponse ${t.localizedMessage}")
            }

        })
    }

}