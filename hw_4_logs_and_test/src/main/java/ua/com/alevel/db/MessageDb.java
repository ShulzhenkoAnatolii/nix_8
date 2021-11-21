package ua.com.alevel.db;

import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.entity.Message;

public interface MessageDb extends BaseDb<Message> {

    DynamicArray<Message> findAllByUserId(String userId);
}
