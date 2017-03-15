package com.janakerman.entity

/**
 * Represents a real shop.
 * Created by jakerman on 15/03/2017.
 */
class Shop {
    Integer id
    String name
    List<Item> menu

    @Override
    String toString() {
        return "[($id)$name]"
    }
}
