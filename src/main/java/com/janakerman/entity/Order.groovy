package com.janakerman.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne

/**
 * Represents an order.
 * Created by jakerman on 15/03/2017.
 */
@Entity
class Order implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    @OneToOne
    Person person

    @OneToOne
    Shop shop

    @OneToOne
    Item item
}
