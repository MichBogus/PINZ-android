package com.wsinz.myitems.presentation

import com.wsinz.myitems.adapter.ItemDataHolder
import com.wsinz.network.items.model.Item

interface ItemsMapper {

    fun map(items: List<Item>): List<ItemDataHolder>
}