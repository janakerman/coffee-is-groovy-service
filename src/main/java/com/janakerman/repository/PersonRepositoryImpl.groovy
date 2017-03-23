package com.janakerman.repository

import com.janakerman.entity.Person
import org.springframework.dao.EmptyResultDataAccessException

import javax.persistence.EntityManager
import javax.persistence.NoResultException
import javax.persistence.PersistenceContext

class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager

    @Override
    Person findByUsername(String username) {
        try {
            return entityManager.createQuery("FROM Person as p WHERE p.username = :username", Person)
                    .setParameter("username", username)
                    .getSingleResult()
        } catch (NoResultException e) {
            return null
        }
    }

}
