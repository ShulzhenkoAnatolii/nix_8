package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;

import java.util.List;

public interface BaseDao<E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(Integer id);
    E findById(Integer id);
    List<E> findAll();
    boolean existById(Integer id);
}