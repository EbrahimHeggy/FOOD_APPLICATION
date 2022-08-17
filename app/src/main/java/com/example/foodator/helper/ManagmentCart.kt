package com.example.foodator.helper

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.foodator.Activity.Adapter.ChangeNumberItemsListener
import com.example.foodator.Activity.Domain.FoodDomain
import java.text.FieldPosition
import kotlin.math.log

class ManagmentCart {
    lateinit var  context:Context
    lateinit var  tiny : TinyDB

    constructor(context: Context){
        this.context=context
        this.tiny= TinyDB(context)
    }


    fun insertFood(item:FoodDomain){
        val listFood:ArrayList<FoodDomain> = getListCart()
        var existAlready = false
        var n  =0
        for (i in 0..listFood.size-1){
            Log.d("###",listFood.get(i).gettitle().toString())
            if (listFood.get(i).gettitle().equals(item.gettitle())){
                existAlready=true
                n=i
                break
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

    fun plusNumberFood(listfood: ArrayList<FoodDomain>, position: Int, changeNumberItemsListener: () -> Unit) {
        listfood.get(position).setnumberInCart(listfood.get(position).getnumInCart()+1)
        tiny.putListObject("CartList",listfood)
        changeNumberItemsListener
    }


    fun minusNumberFood( listfood : ArrayList<FoodDomain>,position: Int , changeNumberItemsListener: ChangeNumberItemsListener) {
        if (listfood.get(position).getnumInCart()==1){
            listfood.removeAt(position)
        }
        else{
            listfood.get(position).setnumberInCart(listfood.get(position).getnumInCart()-1)

        }
        tiny.putListObject("CartList",listfood)
        //changeNumberItemsListener.changed()
    }
    fun getTotalfee():Double{
        val listfood :ArrayList<FoodDomain> =getListCart()
        var fee =0.0
        for (i in 0..listfood.size-1){
            fee=fee+(listfood.get(i).getfee()*listfood.get(i).numberInCart)

        }
        return fee
    }
}