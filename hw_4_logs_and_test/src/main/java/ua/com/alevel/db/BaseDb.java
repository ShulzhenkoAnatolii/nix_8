package ua.com.alevel.db;

import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.entity.BaseEntity;

public interface BaseDb<ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(String id);
    ENTITY findById(String id);
    DynamicArray<ENTITY> findByAll();
}
