package ua.com.alevel.firstlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareTriangle {
    public void calculateAreaTriangle() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("This program calculates the area of a triangle according to the given coordinates of 3 points\n" +
                "Enter the coordinates of the points in the format A(x1,y1) B(x2,y2) C(x3,y3)");
        while (true) {
            try {
                System.out.print("x1 = ");
                int x1 = Integer.parseInt(reader.readLine());
                System.out.print("y1 = ");
                int y1 = Integer.parseInt(reader.readLine());
                System.out.print("x2 = ");
                int x2 = Integer.parseInt(reader.readLine());
                System.out.print("y2 = ");
                int y2 = Integer.parseInt(reader.readLine());
                System.out.print("x3 = ");
                int x3 = Integer.parseInt(reader.readLine());
                System.out.print("y3 = ");
                int y3 = Integer.parseInt(reader.readLine());
                int matrix = Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1));
                double area = matrix / 2.0;
                if (area != 0) {
                    System.out.println("The area of a given triangle = " + area);
                } else {
                    System.out.println("Area of a triangle = " + area + ", check the input data, it is possible that all points lie on the same straight line");
                }
                break;
            }  catch (NumberFormatException exception) {
                System.out.println("You entered incorrect data, enter the coordinates of the points in the format A(x1,y1) B(x2,y2) C(x3,y3)");
            }
        }
    }
}
