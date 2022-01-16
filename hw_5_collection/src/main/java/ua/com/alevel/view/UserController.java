package ua.com.alevel.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserController {

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String position;
        try {
            programMenu();
            while ((position = reader.readLine()) != null) {
                switch (position) {
                    case "1" -> new IntegerController().run();
                    case "2" -> new DoubleController().run();
                    case "0" -> System.exit(0);
                }
                programMenu();
            }
        } catch (Exception exception) {
            System.out.println("problem: = " + exception.getMessage());
        }
    }

    public void programMenu() {
        System.out.println("if you want used Integer MathSet, please enter to 1\n" +
                           "if you want used Double MathSet, please enter to 2\n" +
                           "if you want exit, please enter to 0");
        System.out.print("select your choice ---> ");
    }
}
