package com.janakerman.entity

/**
 * Represents an order.
 * Created by jakerman on 15/03/2017.
 */
class Order implements IEntity {
    Integer id
    Person person
    Shop shop
    Item item
}
