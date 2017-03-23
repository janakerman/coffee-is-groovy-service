package com.janakerman.repository

import com.janakerman.entity.Person

interface PersonRepositoryCustom {
    Person findByUsername(String username)
}