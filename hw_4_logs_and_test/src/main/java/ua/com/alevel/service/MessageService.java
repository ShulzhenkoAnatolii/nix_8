package ua.com.alevel.service;

import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.entity.Message;

public interface MessageService extends BaseService<Message>{
    DynamicArray<Message> findAllByUserId(String userId);
}
