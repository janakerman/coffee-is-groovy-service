package com.janakerman.entity

/**
 * Represents a real item.
 * Created by jakerman on 15/03/2017.
 */
class Item implements IEntity {
    Integer id
    String name
    Integer cost

    @Override
    String toString() {
        return "[($id)$name]"
    }
}
