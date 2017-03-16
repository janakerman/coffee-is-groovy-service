package com.janakerman.controller

import com.janakerman.entity.Order
import com.janakerman.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * A controller for orders
 * Created by jakerman on 15/03/2017.
 */
@Controller
class OrderController {

    @Autowired
    private OrderRepository repository;

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    Order get(@PathVariable Integer id) { repository.findOne id }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    Order post(@PathVariable Order order) { repository.save order }

}
