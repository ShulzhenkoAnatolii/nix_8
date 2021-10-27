package ua.com.alevel.db;

import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.entity.User;

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

    public void update(User user) {
        User current = findById(user.getId());
        current.setAge(user.getAge());
        current.setName(user.getName());
        current.setLastName(user.getLastName());
        current.setEmail(user.getEmail());
    }

    public void delete(String id) {
        try {
            users.delete(findPositionById(id));
        } catch (Exception e) {
            System.out.println("user is not found");
        }
    }

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

    public DynamicArray<User> findAll() {
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
