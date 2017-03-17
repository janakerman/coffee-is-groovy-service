package com.janakerman.repository

import com.janakerman.entity.Trip
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * A trip repository.
 * Created by jakerman on 16/03/2017.
 */
@Repository
interface TripRepository extends JpaRepository<Trip, Integer>, TripRepositoryCustom {}
