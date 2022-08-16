package com.example.foodator.Activity.Adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodator.Activity.Domain.CategoryDomain
import com.example.foodator.R

class CategoryAdapter(var categoryDomains: ArrayList<CategoryDomain>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
//    var categoryDomains : ArrayList<CategoryDomain> = ArrayList()

//constructor(categoryDomains: ArrayList<CategoryDomain>){
//    this.categoryDomains=categoryDomains
//}
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val CategoryName: TextView
        val CategoryPic: ImageView
        val mainlayout : ConstraintLayout
        init {
            super.itemView
            CategoryName=itemView.findViewById(R.id.categoryName)
            CategoryPic=itemView.findViewById(R.id.categoryPic)
            mainlayout=itemView.findViewById(R.id.mainLayout)
        }

    }

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.viewholder_category, parent, false)
        return ViewHolder(view)    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.CategoryName.setText(this.categoryDomains.get(position).gettitle())
        var picUrl:String =""
        when(position){
            0 -> {
                picUrl="cat_1"
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background1))
                holder.CategoryPic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_1))

            }
            1 -> {
                picUrl="cat_2"
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background2))
                holder.CategoryPic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_2))

            }
            2-> {
            picUrl="cat_3"
            holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background3))
                holder.CategoryPic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_3))

            } 3 -> {
            picUrl="cat_4"
            holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background4))
            holder.CategoryPic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_4))

        }
            4-> {
            picUrl="cat_5"
            holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background5))
                holder.CategoryPic.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,R.drawable.cat_5))

            }
        }
//      val  drawableResourceId : Int = holder.itemView.context.resources.getIdentifier(picUrl,"drawable",holder.itemView.context.packageName)

//        Glide.with(holder.itemView.context)
//            .load(drawableResourceId)
//            .into(holder.CategoryPic)


    }

    override fun getItemCount(): Int {
       return categoryDomains.size
    }
}
