package ua.com.alevel;

import ua.com.alevel.firstlevel.CountUniqueNumbers;
import ua.com.alevel.firstlevel.HorseMove;
import ua.com.alevel.firstlevel.SquareTriangle;
import ua.com.alevel.levelthree.GameOfLife;
import ua.com.alevel.secondlevel.PermissibleLine;
import ua.com.alevel.secondlevel.treedepth.TreeDepth;

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
                        new CountUniqueNumbers().countAllUniqueNumbers();
                        menuProgram();
                    }
                    break;
                    case "2": {
                        new SquareTriangle().calculateAreaTriangle();
                        menuProgram();
                    }
                    break;
                    case "3": {
                        new HorseMove().horseMoveChessBoard();
                        menuProgram();
                    }
                    break;
                    case "4": {
                        new PermissibleLine().checkPermissibleLine();
                        menuProgram();
                    }
                    break;
                    case "5": {
                        new TreeDepth().run();
                        menuProgram();
                    }
                    break;
                    case "6": {
                        new GameOfLife().run();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void menuProgram() {
        System.out.println();
        System.out.println("Level 1 task 1 ---> select 1");
        System.out.println("Level 1 task 2 ---> select 2");
        System.out.println("Level 1 task 3 ---> select 3");
        System.out.println("Level 2 task 1 ---> select 4");
        System.out.println("Level 2 task 2 ---> select 5");
        System.out.println("Level 3 task 1 ---> select 6");
        System.out.println("If you want to exit, please select 0");
        System.out.print("Your choice ---> ");

    }
}
