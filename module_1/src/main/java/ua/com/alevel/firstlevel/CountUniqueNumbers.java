package ua.com.alevel.firstlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountUniqueNumbers {

    public void countAllUniqueNumbers() throws IOException {
        System.out.println("The program returns the number of unique numbers\nEnter an array of numbers (Example ---> 1 3 12 5 45) ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> mySet = new HashSet<>();
        while (true) {
            try {
                System.out.print("Enter your Line ------> ");
                String line = reader.readLine();
                String[] array = line.split("\\s");
                for (int i = 0; i < array.length; i++) {
                    mySet.add(Integer.parseInt(array[i]));
                }
                System.out.println("number of unique numbers = " + mySet.size());
                break;
            } catch (NumberFormatException exception) {
                System.out.println("You entered incorrect data, Enter an array of numbers (Example ---> 1 3 12 5 45)");
            }
        }
    }
}
