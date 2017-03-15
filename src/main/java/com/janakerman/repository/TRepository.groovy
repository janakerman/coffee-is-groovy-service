package com.janakerman.repository

import com.janakerman.entity.IEntity

/**
 * A repository trait.
 * Created by jakerman on 15/03/2017.
 */
trait TRepository<T extends IEntity> implements IRepository<T> {
    abstract Map<Integer, T> getStorage()

    void save(T t) { getStorage().put(t.getId(), t) }

    void saveAll(List<T> tList) { tList.each { getStorage().put(it.getId(), it) } }

    T find(Integer id) { getStorage().get(id) }
}