package com.janakerman.controller

import com.janakerman.dto.DrinkOrderDTO
import com.janakerman.dto.NewOrderDTO
import com.janakerman.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * A controller for orders
 * Created by jakerman on 15/03/2017.
 */
@RestController
class OrderController {

    @Autowired
    private OrderService orderService

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    DrinkOrderDTO get(@PathVariable Integer id) {
        DrinkOrderDTO.fromOrder orderService.get(id)
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    DrinkOrderDTO post(@RequestBody NewOrderDTO newOrder) {
        def order = orderService.createOrder(newOrder.shop, newOrder.person, newOrder.item)
        DrinkOrderDTO.fromOrder order
    }

}
