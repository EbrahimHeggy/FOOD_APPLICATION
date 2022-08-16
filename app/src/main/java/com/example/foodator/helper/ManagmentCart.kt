package com.example.foodator.helper

import android.content.Context
import android.widget.Toast
import com.example.foodator.Activity.Domain.FoodDomain

class ManagmentCart {
    lateinit var  context:Context
     lateinit var  tiny : TinyDB

     constructor(context: Context){
         this.context=context
         this.tiny= TinyDB(context)
     }

    fun insertFood(item:FoodDomain){
        var listFood:ArrayList<FoodDomain> = getListCart()
        var existAlready : Boolean = false
        var n :Int =0
        for (i in 0..listFood.size){
            if (listFood.get(i).gettitle().equals(item.gettitle())){
                existAlready=true
                n=i
                return
            }
        }

        if (existAlready){
            listFood.get(n).setnumberInCart(item.getnumInCart())
        }
        else{
            listFood.add(item)
        }
        tiny.putListObject("CartList",listFood)
        Toast.makeText(context,"Added To Cart",Toast.LENGTH_LONG).show()

    }

    fun getListCart():ArrayList<FoodDomain>{
        return tiny.getListObject("CartList")
    }
}