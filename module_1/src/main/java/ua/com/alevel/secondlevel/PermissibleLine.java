package ua.com.alevel.secondlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PermissibleLine {

    public void checkPermissibleLine() throws IOException {
        System.out.println("Is the input string valid\nEnter your String Line");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int check1 = 0;
        int check2 = 0;
        int check3 = 0;
        boolean test = true;

        for (int i = 0; i < line.length(); i++) {
            String symbol = line.substring(i, i + 1);
            if (symbol.equals("(")) {
                check1++;
            } else if (symbol.equals(")")) {
                check1--;
            } else if (symbol.equals("{")) {
                check2++;
            } else if (symbol.equals("}")) {
                check2--;
            } else if (symbol.equals("[")) {
                check3++;
            } else if (symbol.equals("]")) {
                check3--;
            }
            if (check1 < 0 || check2 < 0 || check3 < 0) {
                test = false;
                break;
            }
        }
        if (check1 == 0 && check2 == 0 && check3 == 0 && test) {
            System.out.println("Correct Line");
        } else System.out.println("Incorrect Line");
    }
}
