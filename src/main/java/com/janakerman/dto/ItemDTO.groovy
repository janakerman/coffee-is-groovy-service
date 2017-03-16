package com.janakerman.dto

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.janakerman.entity.Item
import com.janakerman.entity.Shop

/**
 * DTO for an Item
 * Created by jakerman on 16/03/2017.
 */
class ItemDTO {
    Integer id
    String name
    Integer cost

    Item toItem() {
        new Item(
                id: this.getId(),
                name: this.getName(),
                cost: this.getCost(),
        )
    }

    static ItemDTO fromItem(Item item) {
        new ItemDTO(
                id: item.getId(),
                name: item.getName(),
                cost: item.getCost(),
        )
    }
}
