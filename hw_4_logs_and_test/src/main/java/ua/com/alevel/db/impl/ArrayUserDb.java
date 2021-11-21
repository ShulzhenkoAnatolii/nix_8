package ua.com.alevel.db.impl;

import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.db.UserDb;
import ua.com.alevel.entity.User;

import java.util.UUID;

public class ArrayUserDb implements UserDb {

    private final DynamicArray<User> users;
    private static ArrayUserDb instance;

    private ArrayUserDb() {
        users = new DynamicArray<>();
    }

    public static ArrayUserDb getInstance() {
        if (instance == null) {
            instance = new ArrayUserDb();
        }
        return instance;
    }

    @Override
    public void create(User user) {
        user.setId(generateId());
        users.add(user);
    }

    @Override
    public void update(User user) {
        User current = findById(user.getId());
        current.setFirstName(user.getFirstName());
        current.setLastName(user.getLastName());
    }

    @Override
    public void delete(String id) {
        try {
            users.delete(findPositionById(id));
        } catch (Exception e) {
            System.out.println("user is not found");
        }
    }

    @Override
    public User findById(String id) {
        User user;
        try {
            user = (User) users.getElement(findPositionById(id));
        } catch (Exception e) {
            System.out.println("user is not found");
            user = null;
        }
        return user;
    }

    @Override
    public DynamicArray findByAll() {
        return (DynamicArray<User>) users;
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
        User user;
        for (int i = 0; i < users.size(); i++) {
            user = (User) users.getElement(i);
            if (user.getId().equals(id)) {
                position = i;
                break;
            }
        }
        return position;
    }
}
