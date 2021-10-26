package ua.com.alevel.db;

import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDataBase {

    private final DynamicArray<User> users;
    private static UserDataBase instance;

    private UserDataBase() {
        users = new DynamicArray<>();
    }

    public static UserDataBase getInstance() {
        if (instance == null) {
            instance = new UserDataBase();
        }
        return instance;
    }

    public void create(User user) {
        user.setId(generateId());
        users.add(user);
    }

    public DynamicArray<User> findAll() {
        return users;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString(); // ну ... надеяться на несовпадение рандомов - такое дело ...
        /*if (users.stream().anyMatch(user -> user.getId().equals(id))) {
            return generateId();
        }*/
        return id;
    }
}
