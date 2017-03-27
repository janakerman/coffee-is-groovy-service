package com.janakerman.service

import com.janakerman.entity.Person
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

interface PersonService {
    Person getCurrent()
    Person getPerson(Integer id)
    Person getPerson(String username)
    Person create(Person person)
}