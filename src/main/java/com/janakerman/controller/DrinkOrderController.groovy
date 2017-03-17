package com.janakerman.controller


import com.janakerman.dto.NewOrderDTO
import com.janakerman.entity.DrinkOrder
import com.janakerman.service.DrinkOrderService
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
class DrinkOrderController {

    @Autowired
    private DrinkOrderService orderService

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
      get(@PathVariable Integer id) {
        orderService.get(id)
    }

}
