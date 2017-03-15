package com.janakerman.repository

import com.janakerman.entity.IEntity

/**
 * A repository interface.
 * Created by jakerman on 15/03/2017.
 */
interface IRepository<T extends IEntity> {
    void save(T t)
    void saveAll(List<T> tList)
    T find(Integer id)
}