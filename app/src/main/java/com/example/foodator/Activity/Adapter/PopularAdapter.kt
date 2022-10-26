package com.example.foodator.Activity.Adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodator.Activity.Domain.CategoryDomain
import com.example.foodator.Activity.Domain.FoodDomain
import com.example.foodator.Activity.ShowDetActivity
import com.example.foodator.R

class PopularAdapter(var FoodList: ArrayList<FoodDomain>,var token:String) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title : TextView
        val fee: TextView
        val addbtn : TextView
        val pic :ImageView
        val mainlayout : ConstraintLayout

    init {

            title = view.findViewById(R.id.poptitle)
            pic=view.findViewById(R.id.poppic)
            addbtn=view.findViewById(R.id.addbtn)
            fee=view.findViewById(R.id.popfee)
            mainlayout=view.findViewById(R.id.mainlay)
    }

    }

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.viewholder_popular, parent, false)
        return ViewHolder(view)    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(this.FoodList.get(position).gettitle())
        holder.fee.setText(this.FoodList.get(position).getfee().toString())

        var picUrl:String =""
        when(position){
            0 -> {
                picUrl="pop_1"
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background1))
                holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.caridea))

            }
            1 -> {
                picUrl="pop_2"
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background2))
                holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.pop_2))

            }
            2-> {
            picUrl="pop_3"
            holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background3))
                holder.pic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.pop_3))
            }

            }

        holder.addbtn.setOnClickListener(){
            val intent = Intent(holder.itemView.context,ShowDetActivity::class.java)
            intent.putExtra("obj",FoodList.get(position))
            intent.putExtra("token",token)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return FoodList.size
    }
}
