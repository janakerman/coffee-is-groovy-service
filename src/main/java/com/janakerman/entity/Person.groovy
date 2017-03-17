package com.janakerman.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Represents a real person.
 * Created by jakerman on 15/03/2017.
 */
@Entity
class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    String firstName

    String lastName

    @Override
    String toString() { "[($id)$firstName $lastName]" }
}
