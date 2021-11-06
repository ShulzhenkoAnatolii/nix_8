package ua.com.alevel.levelthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOfLife {
    private static int n;
    private static int m;
    private static int array[][];

    public void run() throws IOException {
        System.out.println("The program simulates the game \"Game of Life\"\n" +
                "Enter field sizes. Example n = 4, m = 5\n" +
                "For the program to work correctly, the field size is limited to 70 by 70");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("n = ");
                n = Integer.parseInt(reader.readLine());
                System.out.print("m = ");
                m = Integer.parseInt(reader.readLine());
                if (n > 1 && n <= 70 && m > 1 && m <= 70) {
                    array = new int[n][m];
                    initializeRandomArray();
                    System.out.println();
                    visual();
                    game();
                    System.out.println();
                    visual();
                    break;
                }
                System.out.println("n and m must be greater than 1 and less than 71");
            } catch (NumberFormatException exception) {
                System.out.println("You entered incorrect data");
            }
        }
    }

    public void initializeRandomArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    public void visual() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void game() {
        int[][] nextArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 1) {
                    if (allSum(i, j) < 2) nextArray[i][j] = 0;
                    if (allSum(i, j) == 2 || allSum(i, j) == 3) nextArray[i][j] = 1;
                    if (allSum(i, j) > 3) nextArray[i][j] = 0;
                } else if (allSum(i, j) == 3) nextArray[i][j] = 1;
            }
        }
        for (int i = 0; i < nextArray.length; i++) {
            System.arraycopy(nextArray[i], 0, array[i], 0, nextArray[i].length);
        }
    }

    public int allSum(int i, int j) {
        int sum = 0;
        if ((i - 1 >= 0) && (j - 1 >= 0) && (i < n - 1) && (j < m - 1)) {
            sum += array[i - 1][j - 1] + array[i - 1][j] + array[i - 1][j + 1] + array[i][j - 1] + array[i + 1][j - 1] + array[i + 1][j] + array[i + 1][j + 1] + array[i][j + 1];
        } else if (i == 0 && j == 0) {
            sum += array[i][j + 1] + array[i + 1][j] + array[i + 1][j + 1];
        } else if (i == 0 && j == m - 1) {
            sum += array[i][j - 1] + array[i + 1][j - 1] + array[i + 1][j];
        } else if (i == n - 1 && j == 0) {
            sum += array[i - 1][j] + array[i - 1][j + 1] + array[i][j + 1];
        } else if (i == n - 1 && j == m - 1) {
            sum += array[i][j - 1] + array[i - 1][j - 1] + array[i - 1][j];
        } else if (i == 0 && j > 0 && j < m - 1) {
            sum += array[i][j - 1] + array[i + 1][j - 1] + array[i + 1][j] + array[i + 1][j + 1] + array[i][j + 1];
        } else if (i > 0 && i < n - 1 && j == 0) {
            sum += array[i - 1][j] + array[i - 1][j + 1] + array[i + 1][j] + array[i + 1][j + 1] + array[i][j + 1];
        } else if (j > 0 && j < m - 1 && i == n - 1) {
            sum += array[i - 1][j - 1] + array[i - 1][j] + array[i - 1][j + 1] + array[i][j - 1] + array[i][j + 1];
        } else if (j == m - 1 && i > 0 && i < n - 1) {
            sum += array[i - 1][j - 1] + array[i - 1][j] + array[i][j - 1] + array[i + 1][j - 1] + array[i + 1][j];
        }
        return sum;
    }

}




