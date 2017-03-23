package com.janakerman.repository;

import com.janakerman.entity.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {}
