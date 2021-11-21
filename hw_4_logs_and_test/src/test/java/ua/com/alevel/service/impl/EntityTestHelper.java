package ua.com.alevel.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.entity.Message;
import ua.com.alevel.entity.User;

public class EntityTestHelper {

    private static final UserServiceImpl userService = new UserServiceImpl();
    private static final MessageServiceImpl messageService = new MessageServiceImpl();

    public static final String FIRST_NAME = "Bob";
    public static final String SECOND_FIRST_NAME = "Alan";
    public static final String LAST_NAME = "Ivanov";
    public static final String SECOND_LAST_NAME = "Petrov";
    public static final String MASSAGE = "Bob Ivanov";
    public static final String NEW_MASSAGE = "New Message";
    public static final int STRING_LENGTH = 10;
    public static final int DEFAULT_SIZE = 5;

    public static User generateRandomUser() {
        User user = new User();
        user.setFirstName(RandomStringUtils.randomAlphabetic(STRING_LENGTH));
        user.setLastName(RandomStringUtils.randomAlphabetic(STRING_LENGTH));
        return user;
    }

    public static User generateUser() {
        User user = new User();
        user.setFirstName(SECOND_FIRST_NAME);
        user.setLastName(SECOND_LAST_NAME);
        return user;
    }

    public static Message generateRandomMessage(String userId) {
        Message message = new Message();
        message.setText(RandomStringUtils.randomAlphabetic(STRING_LENGTH));
        message.setUserId(userId);
        return message;
    }

    public static void clearDB() {
        DynamicArray posts = messageService.findAll();
        for (int i = 0; i < posts.size(); i++) {
            Message message = (Message) posts.getElement(i);
            messageService.delete(message.getId());
            i--;
        }
        DynamicArray users = userService.findAll();
        for (int i = 0; i < users.size(); i++) {
            User user = (User) users.getElement(i);
            userService.delete(user.getId());
            i--;
        }
    }
}
