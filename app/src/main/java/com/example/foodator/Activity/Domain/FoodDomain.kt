package com.example.foodator.Activity.Domain

import java.io.Serializable

open class FoodDomain : Serializable {
    var title : String
    var pic : String
    lateinit var category : String
    var description : String
    var fee : Double
    var numberInCart : Int = 0

    constructor(category : String, title:String , pic:String,description : String,fee : Double){
        this.pic=pic
        this.title=title
        this.description=description
        this.fee=fee
        this.category=category
    }

    constructor(title:String , pic:String,description : String,fee : Double,numberInCart:Int){
        this.pic=pic
        this.title=title
        this.description=description
        this.fee=fee
        this.numberInCart=numberInCart
    }

    fun gettitle():String{
        return this.title
    }


    fun getcatogery():String{
        return this.category
    }

    fun getpic():String{
        return this.pic
    } fun getdesc():String{
        return this.description
    } fun getfee():Double{
        return this.fee
    } fun getnumInCart():Int{
        return this.numberInCart
    }

    fun setnumberInCart(getnumInCart: Int) {
        this.numberInCart=getnumInCart
    }

}