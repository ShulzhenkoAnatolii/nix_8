package ua.com.alevel.persistence.dao;

import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.Optional;

public interface BaseDao<ENTITY extends BaseEntity> {

    void create (ENTITY entity);

    void update (ENTITY entity);

    void delete (Integer id);

    Optional<ENTITY> findById(Integer id);
}
