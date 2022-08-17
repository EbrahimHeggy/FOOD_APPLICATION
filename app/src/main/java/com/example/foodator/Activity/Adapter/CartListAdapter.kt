package com.example.foodator.Activity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodator.Activity.Domain.FoodDomain
import com.example.foodator.R
import com.example.foodator.helper.ManagmentCart


interface ChangeNumberItemsListener{
    fun changed()
}

class CartListAdapter() : RecyclerView.Adapter<CartListAdapter.ViewHolder>() {
    lateinit var foodDomain: ArrayList<FoodDomain>
    lateinit var managmentCart: ManagmentCart
    lateinit var changeNumberItemsListener: ChangeNumberItemsListener

    constructor(foodDomain: ArrayList<FoodDomain>, context: Context, changeNumberItemsListener: () -> Unit) : this() {
        this.managmentCart=ManagmentCart(context)
        this.foodDomain=foodDomain
        //this.changeNumberItemsListener=changeNumberItemsListener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var title:TextView
        var feeEachItem:TextView
        var pic:ImageView
        var plusitem:ImageView
        var minusitem:ImageView
        var totalEachItem: TextView
        var num: TextView
        init {
            super.itemView
            title=itemView.findViewById(R.id.titletxt)
            feeEachItem=itemView.findViewById(R.id.feeEachitem)
            pic=itemView.findViewById(R.id.piccart)
            totalEachItem=itemView.findViewById(R.id.totalEachitem)
            num=itemView.findViewById(R.id.numberitemtxt)
            plusitem=itemView.findViewById(R.id.pluscartbtn)
            minusitem=itemView.findViewById(R.id.minuscartbtn)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartListAdapter.ViewHolder {
        val inflate :View = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_cart,parent,false)

        return  ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: CartListAdapter.ViewHolder, position: Int) {
        holder.title.setText(foodDomain.get(position).gettitle())
        holder.feeEachItem.setText(foodDomain.get(position).getfee().toString())
        holder.totalEachItem.setText(Math.round((foodDomain.get(position).getnumInCart()*foodDomain.get(position).getfee()*100)/100).toString())
        holder.num.setText(foodDomain.get(position).getnumInCart().toString())


        var  drawableResourceId : Int = getImage(position)

        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.pic)

        holder.plusitem.setOnClickListener(){ managmentCart.plusNumberFood(foodDomain,position) {

                    notifyDataSetChanged()
                    changeNumberItemsListener.changed()
            }
        }


        holder.minusitem.setOnClickListener(){
            managmentCart.plusNumberFood(foodDomain,position) {
                fun changed() {
                    notifyDataSetChanged()
                    changeNumberItemsListener.changed()
                }
            }
        }

        }

    fun getImage(position: Int):Int{
        var picUrl:String =""
        when(position){
            0 -> {
                picUrl="pop_1"
              //  holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background1))
               // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.pop_1))
                return R.drawable.pop_1
            }
            1 -> {
                picUrl="pop_2"
             //   holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background2))
               // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_2))
                return R.drawable.pop_2
            }
            2-> {
                picUrl="pop_3"
             //   holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background3))
               // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_3))
                return R.drawable.pop_3
            }
            else -> {
                return R.drawable.pop_1
            }
    }
}



    override fun getItemCount(): Int {
       return foodDomain.size
    }

}