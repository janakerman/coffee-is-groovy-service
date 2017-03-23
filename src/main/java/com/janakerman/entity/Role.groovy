package com.janakerman.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    String name

    @ManyToMany(mappedBy = "roles")
    Set<Person> users

}
