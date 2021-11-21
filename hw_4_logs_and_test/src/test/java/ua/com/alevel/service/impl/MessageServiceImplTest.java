package ua.com.alevel.service.impl;

import org.junit.jupiter.api.*;
import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.entity.Message;
import ua.com.alevel.entity.User;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageServiceImplTest extends EntityTestHelper {

    private static final UserServiceImpl userService = new UserServiceImpl();
    private static final MessageServiceImpl messageService = new MessageServiceImpl();

    @Test
    @Order(1)
    public void shouldDoReturnZeroPostListSizeIfMessageListIsEmpty() {
        Assertions.assertEquals(0, messageService.findAll().size());
    }

    @Test
    @Order(2)
    public void shouldDoReturnCorrectMessageListSize() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            User user = generateRandomUser();
            userService.create(user);
        }
        DynamicArray<User> users = userService.findAll();
        User user = (User) users.getElement(0);
        Message message = new Message();
        message.setText(MASSAGE);
        message.setUserId(user.getId());
        messageService.create(message);
        Assertions.assertEquals(1, messageService.findAll().size());
    }

    @Test
    @Order(3)
    public void shouldDoCreateMessageWithoutThrow() {
        DynamicArray users = userService.findAll();
        User user = (User) users.getElement(0);
        Assertions.assertDoesNotThrow(() -> messageService.create(generateRandomMessage(user.getId())));
    }

    @Test
    @Order(4)
    public void shouldDoReturnNullIfMessageNotFound() {
        Assertions.assertNull(messageService.findById("Random UserId"));
    }

    @Test
    @Order(5)
    public void shouldDoUpdateMessageWithoutThrow() {
        DynamicArray users = userService.findAll();
        User user = (User) users.getElement(0);
        Assertions.assertDoesNotThrow(() -> messageService.update(generateRandomMessage(user.getId())));
    }

    @Test
    @Order(6)
    public void shouldReturnAnUpdatedMessage() {
        Message message = new Message();
        DynamicArray<User> users = userService.findAll();
        User user = (User) users.getElement(DEFAULT_SIZE - 1);
        message.setText(NEW_MASSAGE);
        message.setUserId(user.getId());
        messageService.update(message);
        Assertions.assertEquals(message.getText(), NEW_MASSAGE);
    }

    @Test
    @Order(7)
    void shouldReturnCurrentMessageById() {
        DynamicArray<Message> messages = messageService.findAll();
        Message message = (Message) messages.getElement(0);
        Message messageOne = messageService.findById(message.getId());
        Assertions.assertEquals(message, messageOne);
    }

    @Test
    @Order(8)
    public void shouldReturnCurrentSizeAfterDeleteMessage() {
        DynamicArray<Message> messages = messageService.findAll();
        int size = messages.size();
        Message message = (Message) messages.getElement(0);
        String idMessage = message.getId();
        messageService.delete(idMessage);
        Assertions.assertEquals(messageService.findAll().size(), size - 1);
    }

    @AfterAll
    public static void clear() {
        clearDB();
    }
}
