package com.janakerman.controller

import com.janakerman.entity.Shop
import com.janakerman.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * A controller for Shop entities.
 * Created by jakerman on 15/03/2017.
 */
@RestController
@CrossOrigin
class ShopController {

    @Autowired
    private ShopService shopService

    @GetMapping(value = "/shop/{id}")
    Shop get(@PathVariable Integer id) {
        shopService.getShop(id)
    }

    @GetMapping(value = "/shops")
    List<Shop> getAll() {
        shopService.getAll()
    }

    @PostMapping(value = "/shop")
    Shop post(@RequestBody Shop newShop) {
        shopService.createShop newShop
    }

}
