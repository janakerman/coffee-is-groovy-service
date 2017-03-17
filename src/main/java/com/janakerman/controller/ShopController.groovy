package com.janakerman.controller

import com.janakerman.entity.Shop
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
    Shop get(@PathVariable Integer id) {
        shopService.getShop(id)
    }

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    Shop post(@RequestBody Shop newShop) {
        shopService.createShop newShop
    }

}
