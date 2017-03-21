package com.janakerman.dto

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.JsonView
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.janakerman.entity.Person
import com.janakerman.entity.Shop

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import java.sql.Timestamp

class OpenTripDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    @JsonView(Views.Basic)
    Person buyer

    @JsonView(Views.Basic)
    Shop shop

    @JsonView
    Timestamp time

    static class Views {
        static class Basic {}
    }
}
