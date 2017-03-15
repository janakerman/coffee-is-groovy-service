package com.janakerman.controller

import com.janakerman.entity.Shop
import com.janakerman.repository.ShopRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * A controller for Shop entities.
 * Created by jakerman on 15/03/2017.
 */
@RestController
class ShopController {

    @Autowired
    ShopRepository repository;

    @RequestMapping(value = "/shop/{id}")
    Shop find(@PathVariable Integer id) {
        println repository.find(id)
        return repository.find(id)
    }

}
