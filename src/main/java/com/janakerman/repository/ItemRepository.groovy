package com.janakerman.repository

import com.janakerman.entity.Item
import org.springframework.stereotype.Repository

/**
 * An Item repository.
 * Created by jakerman on 15/03/2017.
 */
@Repository
class ItemRepository implements IRepository<Item>, TRepository<Item> {}
