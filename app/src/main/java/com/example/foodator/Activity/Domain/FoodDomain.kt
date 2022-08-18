package com.example.foodator.Activity.Domain

import java.io.Serializable

//[11:13 am, 18/08/2022] Eng :EBrahim Muhamed:
//[11:14 am, 18/08/2022] Eng :EBrahim Muhamed: var pictureDrawable = 0
//pictureDrawable:Int



open class FoodDomain : Serializable {
    var title: String
    var pic: String
    lateinit var category: String
    var description: String
    var fee: Double
    var numberInCart: Int = 0
    var pictureDrawable = 0

    constructor(
        category: String,
        title: String,
        pic: String,
        description: String,
        fee: Double,
        pictureDrawable: Int
    ) {
        this.pic = pic
        this.title = title
        this.description = description
        this.fee = fee
        this.category = category
        this.pictureDrawable = pictureDrawable
    }

    constructor(title: String, pic: String, description: String, fee: Double, numberInCart: Int) {
        this.pic = pic
        this.title = title
        this.description = description
        this.fee = fee
        this.numberInCart = numberInCart
    }

    fun gettitle(): String {
        return this.title
    }


    fun getcatogery(): String {
        return this.category
    }

    fun getpic(): String {
        return this.pic
    }

    fun getdesc(): String {
        return this.description
    }

    fun getfee(): Double {
        return this.fee
    }

    fun getnumInCart(): Int {
        return this.numberInCart
    }

    fun setnumberInCart(getnumInCart: Int) {
        this.numberInCart = getnumInCart
    }

    fun getpicdraw(): Int {
        return this.pictureDrawable

    }
}