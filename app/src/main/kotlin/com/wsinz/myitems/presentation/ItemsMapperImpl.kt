package com.wsinz.myitems.presentation

import com.wsinz.myitems.adapter.ItemDataHolder
import com.wsinz.network.items.model.Item

class ItemsMapperImpl : ItemsMapper {

    override fun map(items: List<Item>): List<ItemDataHolder> =
            items.map { item ->
                ItemDataHolder(name = item.name,
                        description = item.description,
                        dateOfAddition = item.dateOfAddition,
                        companyCode = item.companyCode,
                        itemToken = item.itemToken)
            }
}