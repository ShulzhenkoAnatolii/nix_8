package ua.com.alevel.service.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.entity.User;

class UserServiceImplTest extends EntityTestHelper {

    private final User user = new User();
    private final UserServiceImpl userService = new UserServiceImpl();

    @Test
    @Order(1)
    public void shouldDoReturnZeroUserListSizeIfUserListIsEmpty() {
        Assertions.assertEquals(0, userService.findAll().size());
    }

    @Test
    @Order(2)
    void shouldReturnTheCreatedUserIfAllFieldsAreEnteredCorrectly() {
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        userService.create(user);
        Assertions.assertEquals(user.getFirstName(), FIRST_NAME);
        Assertions.assertEquals(user.getLastName(), LAST_NAME);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(1, userService.findAll().size());
    }

    @Test
    @Order(3)
    void shouldReturnCurrentUserById() {
        DynamicArray<User> users = userService.findAll();
        User user = (User) users.getElement(0);
        User userOne = userService.findById(user.getId());
        Assertions.assertEquals(user, userOne);
    }

    @Test
    @Order(4)
    public void shouldDoReturnCorrectUserListSize() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            User user = generateRandomUser();
            userService.create(user);
        }
        Assertions.assertEquals(DEFAULT_SIZE + 1, userService.findAll().size());
    }

    @Test
    @Order(5)
    public void shouldDoCreateUserWithoutThrow() {
        Assertions.assertDoesNotThrow(() -> userService.create(generateRandomUser()));
    }

    @Test
    @Order(6)
    public void shouldDoCreateUserIfUserIsEmpty() {
        Assertions.assertThrows(RuntimeException.class, () -> userService.create(null));
    }

    @Test
    @Order(7)
    public void shouldDoReturnNullIfUserNotFound() {
        Assertions.assertNull(userService.findById("null"));
    }

    @Test
    @Order(8)
    public void shouldReturnAnUpdatedUser() {
        User userGenerate = generateUser();
        DynamicArray<User> users = userService.findAll();
        User user = (User) users.getElement(0);
        userGenerate.setId(user.getId());
        userService.update(userGenerate);
        Assertions.assertEquals(user.getFirstName(), SECOND_FIRST_NAME);
        Assertions.assertEquals(user.getLastName(), SECOND_LAST_NAME);
    }

    @Test
    @Order(9)
    public void shouldReturnCurrentSizeAfterDeleteUser() {
        DynamicArray<User> users = userService.findAll();
        int size = users.size();
        User user = (User) users.getElement(3);
        String idUser = user.getId();
        userService.delete(idUser);
        Assertions.assertEquals(userService.findAll().size(), size - 1);
    }

    @AfterAll
    public static void clear() {
        clearDB();
    }
}