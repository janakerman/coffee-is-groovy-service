package com.janakerman.repository

import com.janakerman.entity.Item
import com.janakerman.entity.Shop
import org.springframework.stereotype.Repository

import java.util.concurrent.ThreadLocalRandom

/**
 * A repository for shops.
 * Created by jakerman on 15/03/2017.
 */
@Repository
class ShopRepository implements IRepository<Shop>, TRepository<Shop> {

    ShopRepository() {
        this.saveAll(generateMocks())
    }

    private static generateMocks() {
        def shops = []

        (1..20).each { i ->
            shops.add new Shop(
                    id: i,
                    name: "CoffeeShop $i",
                    menu: mockItems()
            )
        }
        return shops
    }

    private static mockItems() {
        def items = [
                new Item(id: 1, name: "Americano", cost: 250),
                new Item(id: 2, name: "Mocha", cost: 350),
                new Item(id: 3, name: "Latte", cost: 250),
                new Item(id: 4, name: "cappuccino", cost: 290),
                new Item(id: 5, name: "Flat white", cost: 260),
        ]

        def numItemsOnMenu = ThreadLocalRandom.current().nextInt(3, items.size())

        def itemsOnMenu = []
        (0..numItemsOnMenu).each {
            def item = items.first()
            items.remove item
            itemsOnMenu.add item
        }
        return itemsOnMenu
    }

}
