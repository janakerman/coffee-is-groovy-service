package com.janakerman.controller

import com.janakerman.dto.ShopDTO
import com.janakerman.entity.Shop
import com.janakerman.repository.ShopRepository
import com.janakerman.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * A controller for Shop entities.
 * Created by jakerman on 15/03/2017.
 */
@RestController
class ShopController {

    @Autowired
    private ShopService shopService

    @RequestMapping(value = "/shop/{id}", method = RequestMethod.GET)
    ShopDTO get(@PathVariable Integer id) {
        ShopDTO.fromShop shopService.getShop(id)
    }

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    ShopDTO post(@RequestBody ShopDTO newShop) {
        def shop = shopService.createShop newShop.toShop()
        ShopDTO.fromShop(shop)
    }

}
