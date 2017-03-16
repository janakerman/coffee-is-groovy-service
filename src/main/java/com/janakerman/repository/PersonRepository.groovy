package com.janakerman.repository;

import com.janakerman.entity.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * A repository for Persons.
 * Created by jakerman on 15/03/2017.
 */
@Repository
interface PersonRepository extends JpaRepository<Person, Integer> {}
