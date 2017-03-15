package com.janakerman.controller

import com.janakerman.entity.Person
import com.janakerman.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * A controller for Person entities.
 * Created by jakerman on 15/03/2017.
 */
@RestController
class PersonController {

    @Autowired
    private PersonRepository repository

    @RequestMapping(value="/person/{id}", method = RequestMethod.GET)
    Person find(@PathVariable Integer id) {
        return repository.find(id)
    }
}
