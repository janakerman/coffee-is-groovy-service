package com.janakerman.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

/**
 * Represents a real shop.
 * Created by jakerman on 15/03/2017.
 */
@Entity
class Shop implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    String name

    @OneToMany
    List<Item> menu

    @Override
    String toString() { "[($id)$name]" }
}
