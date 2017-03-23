package com.janakerman.repository

import com.janakerman.entity.Trip

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import java.time.LocalDateTime
import java.util.List

class TripRepositoryImpl implements TripRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager

    @Override
    List<Trip> getOpenTrips() {
        entityManager.createQuery("FROM Trip as t WHERE t.time > :time", Trip)
                .setParameter("time", LocalDateTime.now())
                .getResultList()
    }

    @Override
    List<Trip> get(Integer personId, Boolean open) {
        return null
    }

}
