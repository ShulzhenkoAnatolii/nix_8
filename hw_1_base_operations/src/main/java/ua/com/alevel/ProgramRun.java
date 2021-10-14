package ua.com.alevel;

import ua.com.alevel.countAllSymbol.CountAllSymbol;
import ua.com.alevel.endLesson.EndLesson;
import ua.com.alevel.sumAllNumber.SumAllNumber;

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
                        new SumAllNumber().sumAllNumberInStringLine();
                    }
                    break;
                    case "2": {
                        new CountAllSymbol().countAllSymbolInStringLine();
                    }
                    break;
                    case "3": {
                        new EndLesson().timeEndSelectLesson();
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
        System.out.println("If you want to use the first program (Counting numbers in a line), select 1");
        System.out.println("If you want to use the second program (Counting characters in a string), select 2");
        System.out.println("If you want to use the third program (End Time) select 3");
        System.out.println("If you want to exit, please select 0");
    }
}
