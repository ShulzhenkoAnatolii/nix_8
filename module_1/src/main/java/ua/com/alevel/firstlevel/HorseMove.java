package ua.com.alevel.firstlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class HorseMove {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private String start;
    private String next;

    public void horseMoveChessBoard() throws IOException {
        drawBoard();
        System.out.println("The program checks if the knight can move on the chessboard" +
                "\nEnter start position and next position (Example ---> Start:A1 or a1, Next:C2 or c2)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Start position ---> ");
            start = reader.readLine().toLowerCase();
            System.out.print("Next position ---> ");
            next = reader.readLine().toLowerCase();
            x1 = start.charAt(0) - (int) 'a' + 1;
            y1 = Character.digit(start.charAt(1), 10);
            x2 = next.charAt(0) - (int) 'a' + 1;
            y2 = Character.digit(next.charAt(1), 10);
            if (checkingCorrectDataEntry(x1, x2) && checkingCorrectDataEntry(x2, y2)) {
                int dx = x1 - x2;
                int dy = y1 - y2;
                boolean horizontalStep = ((Math.abs(dx) == 2) && (Math.abs(dy) == 1));
                boolean verticalStep = ((Math.abs(dy) == 2) && (Math.abs(dx) == 1));
                if (horizontalStep || verticalStep) {
                    System.out.println("Such a knight's move is possible");
                    break;
                } else System.out.println("Such a knight's move is impossible");
                break;
            } else System.out.println("You entered incorrect data");
        }
    }

    public boolean checkingCorrectDataEntry(int x, int y) {
        if (start.length() == 2 && next.length() == 2 && x1 > 0 && y1 < 9 && x2 > 0 && y2 < 9) {
            return true;
        } else {
            return false;
        }
    }

    public void drawBoard() {
        System.out.println("    A  B  C  D  E  F  G  H");
        System.out.println("    ______________________");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) System.out.print((8 - i) + "|");
                if ((j + i) % 2 == 0) System.out.print("  0");
                else System.out.print("  #");
                if (j == 7) System.out.print("  |" + (8 - i));
            }
            System.out.println("\t");
        }
        System.out.println("    ______________________");
        System.out.println("    A  B  C  D  E  F  G  H");
    }
}
