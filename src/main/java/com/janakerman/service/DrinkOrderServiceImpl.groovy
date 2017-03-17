package com.janakerman.service

import com.janakerman.entity.Item
import com.janakerman.entity.DrinkOrder
import com.janakerman.entity.Shop
import com.janakerman.repository.ItemRepository
import com.janakerman.repository.OrderRepository
import com.janakerman.repository.PersonRepository
import com.janakerman.repository.ShopRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * A service that provides actions relating to orders.
 * Created by jakerman on 16/03/2017.
 */
@Service
class DrinkOrderServiceImpl implements DrinkOrderService {

    @Autowired
    OrderRepository orderRepository

    @Override
    @Transactional
    DrinkOrder get(Integer orderId) { orderRepository.saveAndFlush orderId }
}
