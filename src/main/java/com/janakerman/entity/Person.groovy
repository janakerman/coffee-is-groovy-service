package com.janakerman.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Transient

/**
 * Represents a real person.
 * Created by jakerman on 15/03/2017.
 */
@Entity
class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    String username

    String password

    @Transient
    String passwordConfirm

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles

    String firstName

    String lastName

    @Override
    String toString() { "[($id)$firstName $lastName]" }
}
