package ua.com.alevel.dao.impl;

import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.db.impl.ArrayUserDb;
import ua.com.alevel.entity.User;

public class UserDaoImpl implements UserDao {

    @Override
    public void create(User entity) {
        ArrayUserDb.getInstance().create(entity);
    }

    @Override
    public void update(User entity) {
        ArrayUserDb.getInstance().update(entity);
    }

    @Override
    public void delete(String id) {
        ArrayUserDb.getInstance().delete(id);
    }

    @Override
    public User findById(String id) {
        return ArrayUserDb.getInstance().findById(id);
    }

    @Override
    public DynamicArray<User> findAll() {
        return ArrayUserDb.getInstance().findByAll();
    }
}
