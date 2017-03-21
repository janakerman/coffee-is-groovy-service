package com.janakerman.service

import com.janakerman.entity.Item
import com.janakerman.entity.Shop
import com.janakerman.repository.ShopRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * A service providing operations on Shops.
 * Created by jakerman on 16/03/2017.
 */
@Service
class ShopServiceImpl implements ShopService{

    @Autowired
    ShopRepository repository

    @Override
    @Transactional
    Shop createShop(Shop shop) {
        // Set the bi-directional relationship for the items.
        shop.menu.forEach {
            it.setShop shop
        }

        repository.saveAndFlush(shop)
    }

    @Override
    @Transactional
    Shop getShop(Integer id) { repository.findOne(id) }

    @Override
    @Transactional
    List<Shop> getAll() { repository.findAll() }
}
