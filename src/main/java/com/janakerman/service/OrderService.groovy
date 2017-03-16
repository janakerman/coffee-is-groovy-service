package com.janakerman.service

import com.janakerman.entity.DrinkOrder

/**
 * A service providing actions related to Orders.
 * Created by jakerman on 16/03/2017.
 */
interface OrderService {

    DrinkOrder createOrder(Integer shopId, Integer personId, Integer itemId)
    DrinkOrder get(Integer orderId)

}
