package com.janakerman.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import java.time.LocalDateTime

/**
 * Represents a trip.
 * Created by jakerman on 16/03/2017.
 */
@Entity
class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    @ManyToOne
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") // Only serialize the ID of the buyer
    @JsonIdentityReference(alwaysAsId=true)
    Person buyer

    @ManyToOne
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") // Only serialize the ID of the buyer
    @JsonIdentityReference(alwaysAsId=true)
    Shop shop

    LocalDateTime time

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "trip"
    )
    private List<DrinkOrder> orders

    boolean isOpen() { true }

    DrinkOrder addOrder(DrinkOrder order) {
        if (!shop.menu.contains(order.getItem())) {
            // TODO: Throw exception
        }
        if (order.getTrip() != this) {
            // TODO: Can't add an order that isn't for this trip.
        }
        if (!isOpen()) {
            // TODO: Throw exception
        }

        orders.add order
        return order
    }

    List<DrinkOrder> getOrders() { orders }

}
