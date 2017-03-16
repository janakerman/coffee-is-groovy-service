package com.janakerman.repository

import com.janakerman.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * An order repository.
 * Created by jakerman on 15/03/2017.
 */
@Repository
interface OrderRepository extends JpaRepository<Order, Integer> {}
