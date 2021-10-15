package ua.com.alevel.countAllSymbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CountAllSymbol {

    public void countAllSymbolInStringLine() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your Line");
        String line = reader.readLine();

        char[] array = line.toLowerCase()
                .replaceAll("[^a-zA-Zа-яёА-ЯЁ ]", "")
                .toCharArray();
        Arrays.sort(array);

        int count = 1;
        for (int i = 0; i < array.length; i++) {
            int count2 = 1;
            for (int j = i + 1; j < array.length; j++)
                if (array[i] == array[j]) count2++;
                System.out.println(count + ". " + array[i] + " - " + count2);
                count++;
                i += count2 - 1;
            }
            System.out.println("If you want to continue enter the program number from 1 to 3\nIf you want to finish enter 0\nTo view the menu again, select 4 ");
    }
}
