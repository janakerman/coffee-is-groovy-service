package com.janakerman.repository

import com.janakerman.entity.Trip

/**
 * Created by jakerman on 16/03/2017.
 */
interface TripRepositoryCustom {
    List<Trip> get(Boolean open)
    List<Trip> get(Integer personId, Boolean open)
}