package ua.com.alevel.sumAllNumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumAllNumber {

    public void sumAllNumberInStringLine(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your line");

        String str = scanner.nextLine();

        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(str);
        int sum = 0;
        while(matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        System.out.println("Sum of digits in your string = " + sum);
    }
}
