package com.example.foodator.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodator.Activity.Adapter.CartListAdapter
import com.example.foodator.R
import com.example.foodator.helper.ManagmentCart

class CartListActivity : AppCompatActivity() {
    lateinit var adapter: CartListAdapter
    lateinit var recyclerViewList: RecyclerView
    lateinit var totalfeetxt:TextView
   lateinit var managmentCart : ManagmentCart
    lateinit var totaltxt:TextView
    lateinit var taxtxt:TextView
    lateinit var deliverytxt:TextView
    lateinit var emptytxt:TextView
    lateinit var scrollView: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_list)
//        recyclerViewList=findViewById(R.id.recyclerView)
        totalfeetxt=findViewById(R.id.totaltxt)
        taxtxt=findViewById(R.id.totaltaxtxt)
        deliverytxt=findViewById(R.id.deliverytxt)
        totaltxt=findViewById(R.id.totaltxt)
        emptytxt=findViewById(R.id.empty)
        scrollView=findViewById(R.id.scrollView)
        recyclerViewList=findViewById(R.id.cartView)
         managmentCart = ManagmentCart(applicationContext)


        initList()
        calculateCart()
        bottomnavbar()
    }


    fun bottomnavbar(){
      var cartbtn=findViewById<ImageButton>(R.id.cartBtn)
        var homebtn =findViewById<LinearLayout>(R.id.homeBtn)

//        cartbtn.setOnClickListener(){
//            val intent = Intent(this, CartListActivity::class.java)
//            startActivity(intent)
//        }

        homebtn.setOnClickListener(){
            cartbtn.setOnClickListener(){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun initList(){
        val  linearLayoutManager  = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerViewList.setLayoutManager(linearLayoutManager)
        adapter= CartListAdapter(managmentCart.getListCart(),this) {
            fun changed() {
                calculateCart()
            }

        }


        recyclerViewList.setAdapter(adapter)
        if (managmentCart.getListCart().isEmpty()){
            emptytxt.setVisibility(View.VISIBLE)
            scrollView.setVisibility(View.GONE)
        }
        else{
            emptytxt.setVisibility(View.GONE)
            scrollView.setVisibility(View.VISIBLE)
        }
    }



    fun calculateCart(){
        val percenttax =0.02
        val delivery =10.0
        var tax : Long =Math.round((managmentCart.getTotalfee()*percenttax)*100)/100
        var total : Long =Math.round((managmentCart.getTotalfee()+tax+delivery)*100)/100
        var itemtotal : Long =Math.round(managmentCart.getTotalfee()*100)/100


        totalfeetxt.setText("$"+itemtotal)
        taxtxt.setText("$"+tax)
        deliverytxt.setText("$"+delivery)
        totaltxt.setText("$"+total)
    }


}