package ua.com.alevel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.dao.impl.MessageDaoImpl;
import ua.com.alevel.dao.impl.UserDaoImpl;
import ua.com.alevel.entity.Message;
import ua.com.alevel.service.MessageService;

public class MessageServiceImpl implements MessageService {

    Logger loggerInfo = LoggerFactory.getLogger("info");
    Logger loggerWarn = LoggerFactory.getLogger("warn");

    private final MessageDaoImpl messageDaoImpl = new MessageDaoImpl();
    private final UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    public void create(Message message) {
        loggerInfo.info("start MessageServiceImpl.create");
        if (userDaoImpl.findById(message.getUserId()) != null) {
            messageDaoImpl.create(message);
        } else {
            System.out.println("message creating failed, user not found, userId = " + message.getUserId());
            loggerWarn.warn("message creating failed, user not found, userId = " + message.getUserId());
        }
    }

    @Override
    public void update(Message message) {
        loggerInfo.info("start MessageServiceImpl.update");
        if (userDaoImpl.findById(message.getId()) != null) {
            messageDaoImpl.update(message);
        } else loggerWarn.warn("message updating failed, user not found, messageId = " + message.getId() + ", userId = " + message.getUserId());
    }

    @Override
    public void delete(String id) {
        loggerInfo.info("run MessageServiceImpl.delete, id = " + id);
        messageDaoImpl.delete(id);
    }

    @Override
    public Message findById(String id) {
        loggerInfo.info("run MessageServiceImpl.findById, id = " + id);
        return messageDaoImpl.findById(id);
    }

    @Override
    public DynamicArray<Message> findAll() {
        loggerInfo.info("run MessageServiceImpl.findAll");
        return messageDaoImpl.findAll();
    }

    @Override
    public DynamicArray<Message> findAllByUserId(String userId) {
        loggerInfo.info("run MessageServiceImpl.findAllByUserId = " + userId);
        return messageDaoImpl.findAllByUserId(userId);
    }
}
