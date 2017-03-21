package com.janakerman.service

import com.janakerman.entity.DrinkOrder
import com.janakerman.entity.Trip

/**
 * A trip service.
 * Created by jakerman on 16/03/2017.
 */
interface TripService {
    Trip create(Integer buyerId, Integer shopID)
    Trip get(Integer tripId)
    List<Trip> getOpen()
    List<Trip> get(Integer personId, Boolean open)
    DrinkOrder addOrder(Integer tripId, Integer itemId, Integer personId)
}