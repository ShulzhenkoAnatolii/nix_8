package ua.com.alevel.countAllSymbol;

import java.util.Arrays;
import java.util.Scanner;

public class CountAllSymbol {

    public void countAllSymbolInStringLine() {

        int count = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Line");
        String line = scanner.nextLine();

        char[] array = line.toLowerCase()
                .replaceAll("[^a-zA-Zа-яёА-ЯЁ ]", "")
                .toCharArray();
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            int count2 = 1;
            for (int j = i + 1; j < array.length; j++)
                if (array[i] == array[j]) count2++;
            System.out.println(count + ". " + array[i] + " - " + count2);
            count++;
            i += count2 - 1;
        }
    }
}
