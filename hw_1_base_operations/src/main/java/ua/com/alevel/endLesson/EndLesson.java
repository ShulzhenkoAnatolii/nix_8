package ua.com.alevel.endLesson;

import java.util.Scanner;

public class EndLesson {

    public void timeEndSelectLesson(){
        int hourInMinute = 60;
        int startFirstLessonInHours = 9;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number lessons : ");

        int number = scanner.nextInt();
        int durationLesson = number * 45;
        int durationTurnOddLesson = (number / 2) * 5;
        int durationTurnHonestLesson = ((number + 1) / 2 - 1) * 15;

        int result = durationLesson + durationTurnOddLesson + durationTurnHonestLesson;
        System.out.println((result / hourInMinute + startFirstLessonInHours) + " " + result % hourInMinute);
    }
}
