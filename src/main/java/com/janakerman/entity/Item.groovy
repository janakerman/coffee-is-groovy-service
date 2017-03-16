package com.janakerman.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

/**
 * Represents a real item.
 * Created by jakerman on 15/03/2017.
 */
@Entity
class Item implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    @ManyToOne
    @JoinColumn(
            name = "shop_id"  // Defines the name of the join column used to hold the reference to Shop
    )
    Shop shop

    String name

    Integer cost

    @Override
    String toString() { "[($id)$name]" }
}
