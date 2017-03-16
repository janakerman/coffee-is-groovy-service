package com.janakerman.service

import com.janakerman.entity.Item
import com.janakerman.entity.Shop

/**
 * A service providing operations on Shops
 * Created by jakerman on 16/03/2017.
 */
interface ShopService {
    Shop createShop(Shop shop)
    Shop getShop(Integer id)
}