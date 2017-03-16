package com.janakerman.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * Represents an order.
 * Created by jakerman on 15/03/2017.
 */
@Entity
class DrinkOrder implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    @ManyToOne
    Person person

    @ManyToOne
    Shop shop

    @ManyToOne
    Item item
}
