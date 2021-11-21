package ua.com.alevel.db.impl;

import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.db.MessageDb;
import ua.com.alevel.entity.Message;
import ua.com.alevel.entity.User;

import java.util.UUID;

public class ArrayMessageDb implements MessageDb {

    private final DynamicArray<Message> messages;
    private static ArrayMessageDb instance;

    private ArrayMessageDb() {
        messages = new DynamicArray<>();
    }

    public static ArrayMessageDb getInstance() {
        if (instance == null) {
            instance = new ArrayMessageDb();
        }
        return instance;
    }

    @Override
    public void create(Message message) {
        message.setId(generateId());
        messages.add(message);
    }

    @Override
    public void update(Message message) {
        Message current = findById(message.getId());
        current.setUserId(message.getUserId());
        current.setText(message.getText());
    }

    @Override
    public void delete(String id) {
        try {
            messages.delete(findPositionById(id));
        } catch (Exception e) {
            System.out.println("Message is not found");
        }
    }

    @Override
    public Message findById(String id) {
        Message message;
        try {
            message = (Message) messages.getElement(findPositionById(id));
        } catch (Exception e) {
            System.out.println("user is not found");
            message = null;
        }
        return message;
    }

    @Override
    public DynamicArray<Message> findByAll() {
        return (DynamicArray<Message>) messages;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (findPositionById(id) != -1) {
            return generateId();
        }
        return id;
    }

    private int findPositionById(String id) {
        int position = -1;
        Message message;
        for (int i = 0; i < messages.size(); i++) {
            message = (Message) messages.getElement(i);
            if (message.getId().equals(id)) {
                position = i;
                break;
            }
        }
        return position;
    }

    @Override
    public DynamicArray<Message> findAllByUserId(String userId) {
        Message message;
        DynamicArray<Message> userMessage = new DynamicArray<>();
        for (int i = 0; i < messages.size(); i++) {
            message = (Message) messages.getElement(i);
            if (userId.equals(message.getUserId())){
                userMessage.add(message);
            }
        }
        return userMessage;
    }
}
