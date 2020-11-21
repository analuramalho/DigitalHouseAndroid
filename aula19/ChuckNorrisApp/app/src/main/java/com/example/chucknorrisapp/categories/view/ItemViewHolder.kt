package com.example.chucknorrisapp.categories.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapp.R

class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val category = view.findViewById<TextView>(R.id.txtCategory)

    fun bind(categories: String){
        category.text=categories.capitalize()
    }

}
