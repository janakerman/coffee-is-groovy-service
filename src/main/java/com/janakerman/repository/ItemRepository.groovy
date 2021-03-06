package com.janakerman.repository

import com.janakerman.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * An Item repository.
 * Created by jakerman on 15/03/2017.
 */
@Repository
interface ItemRepository  extends JpaRepository<Item, Integer> {}
