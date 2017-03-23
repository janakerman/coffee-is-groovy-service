package com.janakerman.dto

import com.fasterxml.jackson.annotation.JsonView
import com.janakerman.entity.Shop

import java.util.stream.Collectors

class ShopDTO {

    @JsonView(TripDTO.View.Summary)
    Integer id

    @JsonView(TripDTO.View.Summary)
    String name

    List<ItemDTO> menu

    ShopDTO(Shop shop) {
        this.id = shop.getId()
        this.name = shop.getName()
        this.menu = shop.menu.stream().map({ item -> new ItemDTO(item) }).collect(Collectors.toList())
    }

}
