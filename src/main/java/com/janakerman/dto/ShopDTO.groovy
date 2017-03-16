package com.janakerman.dto

import com.fasterxml.jackson.annotation.JsonBackReference
import com.janakerman.entity.Item
import com.janakerman.entity.Shop

import java.util.stream.Collectors

/**
 * DTO for a Shop.
 * Created by jakerman on 16/03/2017.
 */
class ShopDTO {
    Integer id
    String name
    List<ItemDTO> menu

    Shop toShop() {
        def shop = new Shop(id: this.getId(), name: this.getName())

        def items = this.menu.stream()
                .map({ it.toItem() }).collect(Collectors.toList())

        shop.setMenu items
        return shop
    }

    static ShopDTO fromShop(Shop shop) {
        new ShopDTO(
                id: shop.getId(),
                name: shop.getName(),
                menu: shop.menu.stream().map(ItemDTO.&fromItem).collect(Collectors.toList())
        )
    }

}
