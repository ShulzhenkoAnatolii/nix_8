package ua.com.alevel.endLesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EndLesson {

    public void timeEndSelectLesson() throws IOException {
        int hourInMinute = 60;
        int startFirstLessonInHours = 9;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter number lessons : ");
        String line = null;
        while (true) {
            try {
                line = reader.readLine();
                int numberLesson = Integer.parseInt(line);
                if (numberLesson >= 1 & numberLesson <= 10) {
                    int durationLesson = numberLesson * 45;
                    int durationTurnOddLesson = (numberLesson / 2) * 5;
                    int durationTurnHonestLesson = ((numberLesson + 1) / 2 - 1) * 15;

                    int result = durationLesson + durationTurnOddLesson + durationTurnHonestLesson;
                    System.out.println("End of lesson " + numberLesson + ": " + (result / hourInMinute + startFirstLessonInHours) + " " + result % hourInMinute);
                    System.out.println("If you want to continue enter the program number from 1 to 3\nIf you want to finish enter 0\nTo view the menu again, select 4 ");
                    break;
                } else System.out.println("You entered incorrect data, enter a number from 1 to 10");
            } catch (NumberFormatException exception) {
                if (line.isEmpty())
                    System.out.println("You entered incorrect data, enter a number from 1 to 10");
                else
                    System.out.println("You entered incorrect data, enter a number from 1 to 10");
            }

        }

    }
}
