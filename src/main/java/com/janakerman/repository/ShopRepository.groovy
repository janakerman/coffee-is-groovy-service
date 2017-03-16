package com.janakerman.repository

import com.janakerman.entity.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * A repository for shops.
 * Created by jakerman on 15/03/2017.
 */
@Repository
interface ShopRepository  extends JpaRepository<Shop, Integer> {}
