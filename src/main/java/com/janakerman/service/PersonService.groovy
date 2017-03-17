package com.janakerman.service

import com.janakerman.entity.Person
import org.springframework.stereotype.Service

interface PersonService {
    Person get(Integer id)
    Person create(Person person)
}