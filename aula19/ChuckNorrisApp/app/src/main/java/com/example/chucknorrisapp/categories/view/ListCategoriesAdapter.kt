package com.example.chucknorrisapp.categories.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapp.R

class ListCategoriesAdapter(
    private val categories: List<String>,
    private val clickListener: (String) ->Unit
) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_categories, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       holder.bind(categories[position])
        holder.itemView.setOnClickListener{clickListener(categories[position])}
    }
}