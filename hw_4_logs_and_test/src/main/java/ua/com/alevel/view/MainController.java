package ua.com.alevel.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.array.DynamicArray;
import ua.com.alevel.entity.Message;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.impl.MessageServiceImpl;
import ua.com.alevel.service.impl.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {

    Logger loggerInfo = LoggerFactory.getLogger("info");
    Logger loggerError = LoggerFactory.getLogger("error");

    private final UserServiceImpl userServiceImpl = new UserServiceImpl();
    private final MessageServiceImpl messageService = new MessageServiceImpl();

    public void run() {
        loggerInfo.info("Start Program");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your Option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null && !position.equals("0")) {
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
            loggerError.error("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println("-------------User Interface-------------" +
                "\nif you want create user, please enter 1" +
                "\nif you want update user, please enter 2" +
                "\nif you want delete user, please enter 3" +
                "\nif you want findById user, please enter 4" +
                "\nif you want findAll user, please enter 5" +
                "\n-------------Message Interface--------------" +
                "\nif you want create message, please enter 6" +
                "\nif you want update message, please enter 7" +
                "\nif you want delete message, please enter 8" +
                "\nif you want findById message, please enter 9" +
                "\nif you want findAll message, please enter 10" +
                "\nIf you want to get a list of all User messages, please enter 11" +
                "\nif you want exit, please enter 0");
        System.out.println("");
        System.out.print("select your option ---> ");
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                createUser(reader);
                break;
            case "2":
                updateUser(reader);
                break;
            case "3":
                deleteUser(reader);
                break;
            case "4":
                findByIdUser(reader);
                break;
            case "5":
                findAllUser();
                break;
            case "6":
                createMessage(reader);
                break;
            case "7":
                updateMessage(reader);
                break;
            case "8":
                deleteMessage(reader);
                break;
            case "9":
                findByIdMessage(reader);
                break;
            case "10":
                findAllMessage();
                break;
            case "11":
                findAllByUserId(reader);
                break;
            case "0":
                loggerInfo.info("End Program");
                System.exit(0);
        }
        runNavigation();
    }
    private void createUser(BufferedReader reader) {
        System.out.println("UserController.create");
        try {
            System.out.print("Please, enter your Firstname ---> ");
            String name = reader.readLine();
            System.out.print("Please, enter your Surname ---> ");
            String lastName = reader.readLine();
            if (name.isBlank() || lastName.isBlank()){
                System.out.println("First name and Last name must not be empty");
            } else {
                User user = new User();
                user.setFirstName(name);
                user.setLastName(lastName);
                userServiceImpl.create(user);
            }
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
            loggerError.error("problem: = " + exception.getMessage());
        }
    }

    private void updateUser(BufferedReader reader) {
        System.out.println("UserController.update");
        try {
            System.out.print("Please, enter id ---> ");
            String id = reader.readLine();
            System.out.print("Please, enter your Firstname ---> ");
            String name = reader.readLine();
            System.out.print("Please, enter your Surname ---> ");
            String lastName = reader.readLine();
            User user = new User();
            user.setId(id);
            user.setFirstName(name);
            user.setLastName(lastName);
            userServiceImpl.update(user);
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
            loggerError.error("problem: = " + exception.getMessage());
        }
    }

    private void deleteUser(BufferedReader reader) {
        System.out.println("UserController.delete");
        try {
            System.out.print("Please, enter id ---> ");
            String id = reader.readLine();
            userServiceImpl.delete(id);
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
            loggerError.error("problem: = " + exception.getMessage());

        }
    }

    private void findByIdUser(BufferedReader reader) {
        System.out.println("UserController.findById");
        try {
            System.out.print("Please, enter id ---> ");
            String id = reader.readLine();
            User user = userServiceImpl.findById(id);
            System.out.println("user = " + user);
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
            loggerError.error("problem: = " + exception.getMessage());
        }
    }

    private void findAllUser() {
        System.out.println("UserController.findAll");
        DynamicArray<User> users = userServiceImpl.findAll();
        if (users != null && users.size() != 0) {
            users.out();
        } else {
            System.out.println("users empty");
        }
    }
    private void createMessage(BufferedReader reader) {
        System.out.println("MessageController.create");
        try {
            System.out.print("Please, enter your Message ---> ");
            String text = reader.readLine();
            System.out.print("Please, enter your id User ---> ");
            String userId = reader.readLine();
            if (text.isBlank() || userId.isBlank()) {
                System.out.println("Text and UserId must not be empty");
            } else {
                Message message = new Message();
                message.setUserId(userId);
                message.setText(text);
                messageService.create(message);
            }
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
            loggerError.error("problem: = " + exception.getMessage());
        }
    }

    private void updateMessage(BufferedReader reader) {
        System.out.println("MessageController.update");
        try {
            System.out.print("Please, enter id Message ---> ");
            String id = reader.readLine();
            System.out.print("Please, enter your Message ---> ");
            String text = reader.readLine();
            Message message = new Message();
            message.setText(text);
            message.setId(id);
            messageService.update(message);
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
            loggerError.error("problem: = " + exception.getMessage());
        }
    }

    private void deleteMessage(BufferedReader reader) {
        System.out.println("MessageController.delete");
        try {
            System.out.print("Please, enter id ---> ");
            String id = reader.readLine();
            messageService.delete(id);
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
            loggerError.error("problem: = " + exception.getMessage());
        }
    }

    private void findByIdMessage(BufferedReader reader) {
        System.out.println("MessageController.findById");
        try {
            System.out.print("Please, enter id Message ---> ");
            String id = reader.readLine();
            Message message = messageService.findById(id);
            System.out.println("message = " + message);
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
            loggerError.error("problem: = " + exception.getMessage());
        }
    }

    private void findAllMessage() {
        System.out.println("MessageController.findAll");
        DynamicArray<Message> messages = messageService.findAll();
        if (messages != null && messages.size() != 0) {
            messages.out();
        } else {
            System.out.println("messages empty");
        }
    }

    private void findAllByUserId(BufferedReader reader) {
        System.out.println("MessageController.findAllByUserId");
        try {
            System.out.print("Please, enter id User ---> ");
            String userId = reader.readLine();
            if (userId.isEmpty()) System.out.println("User id Empty");
            else{
                DynamicArray<Message> messagesByUserId = messageService.findAllByUserId(userId);
                if (messagesByUserId != null && messagesByUserId.size() > 0) {
                    messagesByUserId.out();
                } else System.out.println("List Messages is empty");
            }
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
            loggerError.error("problem: = " + exception.getMessage());
        }
    }
}
