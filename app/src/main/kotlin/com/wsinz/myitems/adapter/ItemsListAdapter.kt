package com.wsinz.myitems.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wsinz.R

class ItemsListAdapter(val context: Context,
                       val listOfItems: List<ItemDataHolder>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        holder?.bind(listOfItems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder =
            ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.row_my_item, null))

    override fun getItemCount(): Int = listOfItems.size
}