package ua.com.alevel.dao.impl;

import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.dao.MessageDao;
import ua.com.alevel.db.impl.ArrayMessageDb;
import ua.com.alevel.entity.Message;

public class MessageDaoImpl implements MessageDao {


    @Override
    public void create(Message entity) {
        ArrayMessageDb.getInstance().create(entity);
    }

    @Override
    public void update(Message entity) {
        ArrayMessageDb.getInstance().update(entity);
    }

    @Override
    public void delete(String id) {
        ArrayMessageDb.getInstance().delete(id);
    }

    @Override
    public Message findById(String id) {
        return ArrayMessageDb.getInstance().findById(id);
    }

    @Override
    public DynamicArray<Message> findAll() {
        return ArrayMessageDb.getInstance().findByAll();
    }

    public DynamicArray<Message> findAllByUserId(String userId){
        return ArrayMessageDb.getInstance().findAllByUserId(userId);
    }
}
