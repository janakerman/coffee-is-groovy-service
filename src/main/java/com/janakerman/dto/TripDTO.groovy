package com.janakerman.dto

import com.fasterxml.jackson.annotation.JsonView
import com.janakerman.entity.Trip

import java.sql.Timestamp

class TripDTO {

    @JsonView(View.Summary)
    Integer id

    @JsonView(View.Summary)
    PersonDTO buyer

    @JsonView(View.Summary)
    ShopDTO shop

    @JsonView(View.Summary)
    Timestamp time

    TripDTO(Trip trip) {
        this.id = trip.getId()
        this.buyer = new PersonDTO(trip.getBuyer())
        this.shop = new ShopDTO(trip.getShop())
        this.time = Timestamp.valueOf(trip.getTime())
    }

    static class View {
        static interface Summary {}
    }

}
