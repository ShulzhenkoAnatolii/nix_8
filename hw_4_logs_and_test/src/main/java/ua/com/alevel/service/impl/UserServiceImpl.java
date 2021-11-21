package ua.com.alevel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.dao.impl.MessageDaoImpl;
import ua.com.alevel.dao.impl.UserDaoImpl;
import ua.com.alevel.entity.Message;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

public class UserServiceImpl implements UserService {

    Logger loggerInfo = LoggerFactory.getLogger("info");

    UserDaoImpl userDaoImpl = new UserDaoImpl();
    MessageDaoImpl messageDaoImpl = new MessageDaoImpl();

    @Override
    public void create(User entity) {
        loggerInfo.info("start UserServiceImpl.create");
        userDaoImpl.create(entity);
        loggerInfo.info("user added, userId=" + entity.getId());
    }

    @Override
    public void update(User entity) {
        loggerInfo.info("start UserServiceImpl.update");
        userDaoImpl.update(entity);
        loggerInfo.info("user update, userId=" + entity.getId());
    }

    @Override
    public void delete(String id) {
        loggerInfo.info("start UserServiceImpl.delete, userId=" + id);
        DynamicArray<Message> messages = messageDaoImpl.findAll();
        for (int i = 0; i < messages.size(); i++) {
            Message message = (Message) messages.getElement(i);
            loggerInfo.info("related post found, messageId=" + message.getId());
            if (message.getUserId().equals(id)) {
                messageDaoImpl.delete(message.getId());
                i--;
            }
        }
        userDaoImpl.delete(id);
    }

    @Override
    public User findById(String id) {
        loggerInfo.info("run UserServiceImpl.findById");
        return userDaoImpl.findById(id);
    }

    @Override
    public DynamicArray findAll() {
        loggerInfo.info("run UserServiceImpl.findAll");
        return userDaoImpl.findAll();
    }
}
