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
   lateinit var managmentCart : ManagmentCart
    lateinit var deliverytxt:TextView
    lateinit var totalitems:TextView
    lateinit var totaltxt:TextView
    lateinit var emptytxt:TextView
    lateinit var scrollView: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_list)
//        recyclerViewList=findViewById(R.id.recyclerView)
        totaltxt=findViewById(R.id.totaltxt)
        totalitems=findViewById(R.id.totalitemstxt)
        deliverytxt=findViewById(R.id.totaldeliverytxt)
        emptytxt=findViewById(R.id.empty)
        scrollView=findViewById(R.id.scrollView)
        recyclerViewList=findViewById(R.id.cartView)
         managmentCart = ManagmentCart(applicationContext)

        initList()
        calculateCart()
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
        val delivery =10.0
        var total : Long =Math.round((managmentCart.getTotalfee()+delivery)*100)/100
//        totalitems.setText(managmentCart.getListCart().size)
//

       // totalfeetxt.setText("$"+itemtotal)
        deliverytxt.setText("$"+delivery)
        totaltxt.setText("$"+total)
    }


}