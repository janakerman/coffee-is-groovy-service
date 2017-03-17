package com.janakerman.repository

import com.janakerman.entity.Trip

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import java.util.List

/**
 * Created by jakerman on 16/03/2017.
 */
class TripRepositoryImpl implements TripRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager

    @Override
    List<Trip> get(Boolean open) {
        return null
    }

    @Override
    List<Trip> get(Integer personId, Boolean open) {
        return null
    }

}
