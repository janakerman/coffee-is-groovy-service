package com.janakerman.dto

import com.fasterxml.jackson.annotation.JsonView
import com.janakerman.entity.Person

class PersonDTO {

    @JsonView(TripDTO.View.Summary)
    Integer id

    @JsonView(TripDTO.View.Summary)
    String firstName

    @JsonView(TripDTO.View.Summary)
    String lastName

    PersonDTO(Person person) {
        this.id = person.getId()
        this.firstName = person.getFirstName()
        this.lastName = person.getLastName()
    }

}
