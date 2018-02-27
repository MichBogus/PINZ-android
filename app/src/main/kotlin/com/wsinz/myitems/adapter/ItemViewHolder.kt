package com.wsinz.myitems.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.wsinz.R

class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(data: ItemDataHolder) {
        view.findViewById<TextView>(R.id.item_name).apply { text = data.name }
        view.findViewById<TextView>(R.id.item_description).apply { text = data.description }
        view.findViewById<TextView>(R.id.item_date_of_addition).apply { text = data.dateOfAddition }
        view.findViewById<TextView>(R.id.item_token).apply { text = data.itemToken }
        view.findViewById<TextView>(R.id.delete_button).setOnClickListener { data.onDeleteClickAction.invoke(data.itemToken) }
    }
}