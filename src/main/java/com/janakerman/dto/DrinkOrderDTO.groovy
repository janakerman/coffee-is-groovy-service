package com.janakerman.dto

import com.janakerman.entity.DrinkOrder

/**
 * Created by jakerman on 16/03/2017.
 */
class DrinkOrderDTO {
    Integer id
    Integer person
    Integer shop
    Integer item

    static DrinkOrderDTO fromOrder(DrinkOrder order) {
        new DrinkOrderDTO(
                id: order.getId(),
                person: order.getPerson().getId(),
                shop: order.getShop().getId(),
                item: order.getItem().getId()
        )
    }
}
