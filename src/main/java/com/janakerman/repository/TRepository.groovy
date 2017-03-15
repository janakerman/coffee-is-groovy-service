package com.janakerman.repository

import com.janakerman.entity.IEntity

/**
 * A repository trait.
 * Created by jakerman on 15/03/2017.
 */
trait TRepository<T extends IEntity> implements IRepository<T> {
    private Map<Integer, T> storage = new HashMap<>()

    void save(T t) { this.storage.put(t.getId(), t) }

    void saveAll(List<T> tList) { tList.each { this.storage.put(it.getId(), it) } }

    T find(Integer id) { this.storage.get(id) }
}