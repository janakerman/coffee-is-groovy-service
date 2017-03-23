package com.janakerman.dto

import com.fasterxml.jackson.annotation.JsonView
import com.janakerman.entity.Item

class ItemDTO {

    Integer id

    String name

    Integer cost

    ItemDTO(Item item) {
        this.id = item.getId()
        this.name = item.getName()
        this.cost = item.getCost()
    }

}
