package com.example.foodator.Activity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

class CartListAdapter(val token :String, foodDomain: ArrayList<FoodDomain>, context: Context,) : RecyclerView.Adapter<CartListAdapter.ViewHolder>() {
    lateinit var foodDomain: ArrayList<FoodDomain>
    lateinit var managmentCart: ManagmentCart
    lateinit var changeNumberItemsListener: ChangeNumberItemsListener

    init {
        this.managmentCart = ManagmentCart(context,token)
        this.foodDomain = foodDomain
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var feeEachItem: TextView
        var pic: ImageView
        var plusitem: ImageView
        var minusitem: ImageView
        var num: TextView

        init {
            super.itemView
            title = itemView.findViewById(R.id.titletxt)
            feeEachItem = itemView.findViewById(R.id.feeEachitem)
            pic = itemView.findViewById(R.id.piccart)
            num = itemView.findViewById(R.id.numberitemtxt)
            plusitem = itemView.findViewById(R.id.pluscartbtn)
            minusitem = itemView.findViewById(R.id.minuscartbtn)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartListAdapter.ViewHolder {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_cart, parent, false)

        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: CartListAdapter.ViewHolder, position: Int) {
        holder.title.setText(foodDomain.get(position).gettitle())
        holder.feeEachItem.setText(foodDomain.get(position).getfee().toString())
        holder.num.setText(foodDomain.get(position).getnumInCart().toString())
        var drawableResourceId: Int = getImage(foodDomain.get(position).gettitle())

        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.pic)

        holder.plusitem.setOnClickListener() {
            managmentCart.plusNumberFood(foodDomain, position) {
                holder.num.setText(foodDomain.get(position).getnumInCart().toString())
                notifyDataSetChanged()
                changeNumberItemsListener.changed()

            }
        }


        holder.minusitem.setOnClickListener() {
            managmentCart.minusNumberFood(foodDomain, position) {
                holder.num.setText(foodDomain.get(position).getnumInCart().toString())
                notifyDataSetChanged()
                changeNumberItemsListener.changed()
            }
        }

    }


    fun getImage(title: String): Int {
        var picUrl: String = ""
        when (title) {
            "Pepproni Pizza" -> {
                picUrl = "pop_1"
                //  holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background1))
                // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.pop_1))
                return R.drawable.pop_1
            }
            "Cheese Burger" -> {
                picUrl = "pop_2"
                //   holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background2))
                // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_2))
                return R.drawable.pop_2
            }
            "Vegetables Pizza" -> {
                picUrl = "pop_3"
                //   holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background3))
                // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_3))
                return R.drawable.pop_3
            }
            "Strawberry Juice" -> {
                picUrl = "pop_3"
                //   holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background3))
                // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_3))
                return R.drawable.cocktail
            }
            "Orange Juice" -> {
                picUrl = "pop_3"
                //   holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background3))
                // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_3))
                return R.drawable.download_cocktail_glass_png_images_background_cold_drinks_png_png_for_free_download_dlpng
            }
            "Mango Juice" -> {
                picUrl = "pop_3"
                //   holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background3))
                // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_3))
                return R.drawable.drink_3
            }
            "Motzarilla Pizza" -> {
                picUrl = "pop_3"
                //   holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background3))
                // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_3))
                return R.drawable.pop_5
            }
            "Chicken Burger" -> {
                picUrl = "pop_3"
                //   holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background3))
                // holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_3))
                return R.drawable.mcdonalds_burger_png_high_quality_image_chicken_burger_kfc_png_transparent_png600x600_png_find
            }
            else -> {
                return R.drawable.mcdonalds_burger_png_high_quality_image_chicken_burger_kfc_png_transparent_png600x600_png_find
            }
        }
    }



    override fun getItemCount(): Int {
       return foodDomain.size
    }

}
