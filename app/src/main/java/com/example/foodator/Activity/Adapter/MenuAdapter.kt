package com.example.foodator.Activity.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.foodator.Activity.Domain.FoodDomain
import com.example.foodator.Activity.ShowDetActivity
import com.example.foodator.R
import com.google.gson.annotations.SerializedName

class MenuAdapter(var FoodList: List<FoodDomain>?,var token:String) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title : TextView
        val fee: TextView
        val addbtn : TextView
        val pic : ImageView
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
        val view = inflater.inflate(R.layout.menucard, parent, false)
        return ViewHolder(view)    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(this.FoodList?.get(position)?.gettitle() ?:"No Data" )
        holder.fee.setText(this.FoodList?.get(position)?.getfee().toString())

        var picUrl:String =""
        holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.context,R.drawable.category_background1))
        holder.pic.setImageDrawable(FoodList?.get(position)?.let {
            ContextCompat.getDrawable(holder.itemView.context,
                it.getpicdraw())
        })

        holder.addbtn.setOnClickListener(){
            val intent = Intent(holder.itemView.context, ShowDetActivity::class.java)
            intent.putExtra("obj", FoodList?.get(position))
            intent.putExtra("token",token)
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return FoodList?.size ?: 0
    }

//    data class word(
//        @SerializedName("word") val word:String,
//        val url:String
//    )
}
