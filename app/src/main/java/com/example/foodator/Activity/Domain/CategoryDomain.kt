package com.example.foodator.Activity.Domain

import android.icu.text.CaseMap

class CategoryDomain {
     var title : String
     var pic : String
     constructor(title:String , pic:String){
         this.pic=pic
         this.title=title
     }

    fun gettitle():String{
        return this.title
    }

    fun getpic():String{
        return this.pic
    }


}

