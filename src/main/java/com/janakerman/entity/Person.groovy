package com.janakerman.entity

import java.time.LocalDate

/**
 * Represents a real person.
 * Created by jakerman on 15/03/2017.
 */
class Person {
    Integer id
    String firstName
    String lastName

    @Override
    String toString() {
        return "[($id)$firstName $lastName]"
    }
}
