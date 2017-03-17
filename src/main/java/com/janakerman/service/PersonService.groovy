package com.janakerman.service

import com.janakerman.entity.Person
import org.springframework.stereotype.Service

interface PersonService {
    Person getPerson(Integer id)
    Person create(Person person)
}