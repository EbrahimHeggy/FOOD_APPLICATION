package com.example.foodator.Activity

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.foodator.Activity.Domain.FoodDomain
import com.example.foodator.R
import com.example.foodator.helper.ManagmentCart

class ShowDetActivity : AppCompatActivity() {
    lateinit var addToCartBtn : TextView
    lateinit var titletxt : TextView
    lateinit var feetxt : TextView
    lateinit var desctxt : TextView
    lateinit var numberOrdertxt : TextView
    lateinit var plusbtn : ImageView
    lateinit var minusbtn : ImageView
    lateinit var picfood : ImageView
    var numberOrder=1
    lateinit var managementcart:ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_det)
        val i =intent
        managementcart = ManagmentCart(this,i.getStringExtra("token").toString())
        addToCartBtn=findViewById(R.id.addtocart)
        titletxt=findViewById(R.id.titletxt)
        feetxt=findViewById(R.id.pricetxt)
        desctxt=findViewById(R.id.descriptiontxt)
        numberOrdertxt=findViewById(R.id.numberOrdertxt)
        plusbtn=findViewById(R.id.plus)
        minusbtn=findViewById(R.id.minus)
        picfood=findViewById(R.id.picFood)
        getBundle()
    }
    fun getBundle() {
         val  obj2: FoodDomain
        obj2 = intent.getSerializableExtra("obj") as FoodDomain
        var total =obj2.getfee()

        var drawableId = this.resources.getIdentifier(obj2.getpic(), "drawable", this.packageName)
        Glide.with(this).load(drawableId).into(picfood)

        titletxt.setText(obj2.gettitle())
        feetxt.setText("$" + obj2.getfee().toString())
        desctxt.setText(obj2.getdesc())
        numberOrdertxt.setText(numberOrder.toString())


        plusbtn.setOnClickListener(){
                numberOrder=numberOrder+1
                numberOrdertxt.text=numberOrder.toString()
             total =total*2
            feetxt.setText("$" + total)

        }

        minusbtn.setOnClickListener(){

                if(numberOrder>1)  numberOrder=numberOrder-1
               numberOrdertxt.text= numberOrder.toString()
            total =total/2
            feetxt.setText("$" + total)

        }

        addToCartBtn.setOnClickListener(){

                obj2.setnumberInCart(numberOrder)
                managementcart.insertFood(obj2)

        }
    }





}