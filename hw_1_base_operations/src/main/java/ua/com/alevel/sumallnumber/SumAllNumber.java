package ua.com.alevel.sumallnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumAllNumber {

    public void sumAllNumberInStringLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your line");

        String str = reader.readLine();

        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(str);
        int sum = 0;
        boolean isActive = false;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
            isActive = true;
        }
        if (isActive == true) {
            System.out.println("Sum of digits in your string = " + sum);
            System.out.println("If you want to continue enter the program number from 1 to 3\nIf you want to finish enter 0\nTo view the menu again, select 4 ");
        } else {
            System.out.println("There are no numbers in the string");
            System.out.println("If you want to continue enter the program number from 1 to 3\nIf you want to finish enter 0\nTo view the menu again, select 4 ");
        }
    }
}
