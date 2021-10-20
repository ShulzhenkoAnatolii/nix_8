package ua.com.alevel;

import ua.com.alevel.reverse.ReverseStringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramRun {

    public static void run() {

        menuProgram();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String task;

        try {
            while ((task = reader.readLine()) != null) {
                switch (task) {
                    case "1": {
                        System.out.print("Reverse line by word\nEnter the string ---> ");
                        String src = reader.readLine();
                        if (src.isEmpty()) {
                            System.out.println("You entered an empty line");
                        } else {
                            System.out.println("result: " + ReverseStringUtil.reverse(src));
                        }
                        System.out.println("Select program number 1-3, menu 4, exit 0");
                    }
                    break;
                    case "2": {
                        System.out.print("Reverse line by word\nEnter the string ---> ");
                        String src = reader.readLine();
                        System.out.print("Enter a substring  ---> ");
                        String dest = reader.readLine();
                        if (dest.isEmpty() || src.isEmpty()) {
                            System.out.println("The string or substring is empty");
                        } else {
                            System.out.println("result: " + ReverseStringUtil.reverse(src,dest));
                        }
                        System.out.println("Select program number 1-3, menu 4, exit 0");
                    }
                    break;
                    case "3": {
                        try {
                            System.out.print("Reverse a line by starting and ending index\nEnter the string ---> ");
                            String src = reader.readLine();
                            System.out.print("Enter a firstIndex  ---> ");
                            int firstIndex = Integer.parseInt(reader.readLine());
                            System.out.print("Enter a lastIndex  ---> ");
                            int lastIndex = Integer.parseInt(reader.readLine());
                            System.out.println("result: " + ReverseStringUtil.reverse(src,firstIndex,lastIndex));
                        } catch (NumberFormatException exception) {
                            System.out.println("Input Error, enter not a number");
                        } catch (StringIndexOutOfBoundsException exception) {
                            System.out.println("Input Error, index out");
                        }
                        System.out.println("Select program number 1-3, menu 4, exit 0");
                    }
                    break;
                    case "4": {
                        menuProgram();
                    }
                    break;
                    case "0": {
                        System.exit(0);
                    }
                    break;
                    default: {
                        run();
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void menuProgram() {
        System.out.println("First program (Reverse line by word), select 1");
        System.out.println("Second program (Reverse a string on an incoming substring), select 2");
        System.out.println("Third program (Reverse a line by starting and ending index) select 3");
        System.out.println("Exit, please select 0");
    }
}
