package ua.com.alevel.dao;

import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.entity.Message;

public interface MessageDao extends BaseDao<Message>{

    DynamicArray<Message> findAllByUserId(String userId);
}
