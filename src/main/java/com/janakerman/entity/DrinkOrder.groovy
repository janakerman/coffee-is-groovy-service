package com.janakerman.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators

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
class DrinkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    @ManyToOne
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") // Only serialize the ID of the buyer
    @JsonIdentityReference(alwaysAsId=true)
    Person person

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") // Only serialize the ID of the buyer
    @JsonIdentityReference(alwaysAsId=true)
    @ManyToOne
    Trip trip

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") // Only serialize the ID of the buyer
    @JsonIdentityReference(alwaysAsId=true)
    @ManyToOne
    Item item
}
