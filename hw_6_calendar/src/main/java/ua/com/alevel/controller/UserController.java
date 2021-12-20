package ua.com.alevel.controller;

import ua.com.alevel.calendar.DataCalendar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserController {

    DataCalendar calendar = new DataCalendar();

    private final static String[] months = {"january", "february", "march", "april", "may", "june", "july",
            "august", "september", "october", "november", "december"};
    String[] formatData = {"dd/mm/yy", "m/d/yyyy", "mmm-d-yy", "dd-mmm-yyyy"};

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String position;
        int inputFormat = 1;
        int outFormat = 1;
        try {
            System.out.println("Start Program Calendar");
            menuProgram();
            while ((position = reader.readLine()) != null) {
                switch (position) {
                    case "1" -> {
                        formatPreview();
                        try {
                            int number = Integer.parseInt(reader.readLine());
                            if (number < 5 && number > 0) {
                                inputFormat = number;
                                formatInfo(inputFormat);
                            } else System.out.println("некорректный ввод");
                        } catch (NumberFormatException exception) {
                            System.out.println("некорректный ввод");
                        }
                    }
                    case "2" -> {
                        formatPreview();
                        try {
                            int number = Integer.parseInt(reader.readLine());
                            if (number < 5 && number > 0) {
                                outFormat = number;
                                formatInfo(outFormat);
                            } else System.out.println("некорректный ввод");
                        } catch (NumberFormatException exception) {
                            System.out.println("некорректный ввод");
                        }
                    }
                    case "3" -> {
                        System.out.print("Введите дату1 (" + formatData[inputFormat - 1] + "): ");
                        String firstInput = reader.readLine().trim();
                        if (isDate(firstInput, inputFormat)) {
                            System.out.print("Введите дату2 (" + formatData[inputFormat - 1] + "): ");
                            String secondInput = reader.readLine().trim();
                            if (isDate(secondInput, inputFormat)) {
                                try {
                                    DataCalendar minuend = new DataCalendar(firstInput, formatData[inputFormat - 1]);
                                    DataCalendar subtrahend = new DataCalendar(secondInput, formatData[inputFormat - 1]);
                                    calendar.difference(firstInput, secondInput, formatData[inputFormat - 1]);
                                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                    System.out.println("Недопустимый ввод");
                                }
                            }
                        }
                    }
                    case "4" -> {
                        System.out.print("Введите дату (" + formatData[inputFormat - 1] + "): ");
                        String dataLine = reader.readLine().trim();
                        if (isDate(dataLine, inputFormat)) {
                            try {
                                DataCalendar calendar = new DataCalendar(dataLine, formatData[inputFormat - 1]);
                                menuPodProgram();
                                while ((position = reader.readLine()) != null && !position.equals("0")) {
                                    switch (position) {
                                        case "1" -> {
                                            System.out.print("Введите количество милисекунд которое хотите прибавить ---> ");
                                            long sum = Integer.parseInt(reader.readLine());
                                            calendar.sumInMilliSecondData(dataLine, formatData[inputFormat - 1], formatData[outFormat - 1], sum);
                                        }
                                        case "2" -> {
                                            System.out.print("Введите количество секунд которое хотите прибавить ---> ");
                                            long sum = Integer.parseInt(reader.readLine());
                                            calendar.sumInSecondData(dataLine, formatData[inputFormat - 1], formatData[outFormat - 1], sum);
                                        }
                                        case "3" -> {
                                            System.out.print("Введите количество минут которое хотите прибавить ---> ");
                                            long sum = Integer.parseInt(reader.readLine());
                                            calendar.sumInMinuteData(dataLine, formatData[inputFormat - 1], formatData[outFormat - 1], sum);
                                        }
                                        case "4" -> {
                                            System.out.print("Введите количество часов которое хотите прибавить ---> ");
                                            long sum = Integer.parseInt(reader.readLine());
                                            calendar.sumInHourData(dataLine, formatData[inputFormat - 1], formatData[outFormat - 1], sum);
                                        }
                                        case "5" -> {
                                            System.out.print("Введите количество дней которое хотите прибавить ---> ");
                                            long sum = Integer.parseInt(reader.readLine());
                                            calendar.sumInDayData(dataLine, formatData[inputFormat - 1], formatData[outFormat - 1], sum);
                                        }
                                        case "6" -> {
                                            System.out.print("Введите количество лет которое хотите прибавить ---> ");
                                            long sum = Integer.parseInt(reader.readLine());
                                            calendar.sumInYearData(dataLine, formatData[inputFormat - 1], formatData[outFormat - 1], sum);
                                        }
                                    }
                                    menuPodProgram();
                                }
                            } catch (NumberFormatException | IndexOutOfBoundsException exception) {
                                System.out.println("некорректный ввод");
                            }
                        }
                    }
                    case "5" -> {
                        System.out.println("Введите даты (" + formatData[inputFormat - 1] + ") через 'Enter' (0 - завершить ввод): ");
                        List<String> dates = new ArrayList<>();
                        try {
                            while (true) {
                                System.out.print("---> ");
                                String src = reader.readLine().trim();
                                if (!src.equals("0")) {
                                    if (isDate(src, inputFormat)) {
                                        dates.add(src);
                                    } else System.out.println("Недопустимый ввод");
                                } else break;
                            }
                            System.out.println("Сортировка по возростанию");
                            calendar.sortAsc(dates, formatData[inputFormat - 1], formatData[outFormat - 1]);
                            System.out.println("Сортировка по убыванию");
                            calendar.sortDesc(dates, formatData[inputFormat - 1], formatData[outFormat - 1]);
                        } catch (NumberFormatException | IndexOutOfBoundsException e) {
                            System.out.println("Недопустимый ввод");
                        }
                    }
                    case "0" -> System.exit(0);
                }
                menuProgram();
            }
        } catch (Exception exception) {
            System.out.println("problem: = " + exception.getMessage());
        }
    }

    private static void formatPreview() {
        System.out.println("1 - dd/mm/yy | 2 - m/d/yyyy | 3 - mmm-d-yy | 4 - dd-mmm-yyyy");
        System.out.print("select your choice ---> ");
    }

    private void menuProgram() {
        System.out.println("1 - Выбрать формат ввода данных (по умолчанию dd/mm/yy) | 2 - Выбрать формат вывода данных (по умолчанию dd/mm/yy)\n" +
                "3 - Разница дат | 4 - Прибавить (Вычесть из даты) к дате | 5 - Сортировать даты | 0 - Exit");
        System.out.print("select your choice ---> ");
    }

    private void menuPodProgram() {
        System.out.println("1 - прибавить миллисекунды | 2 - прибавить секунды | 3 - прибавить минуты\n" +
                "4 - прибавить часы | 5 - прибавить дни | 6 - прибавить года | 0 - вернуться к предыдущему шагу");
        System.out.println("Что бы произвести вычетание добавьте знак \"-\" перед числом (секунд, минут, дней и тд)");
        System.out.print("select your choice ---> ");
    }

    private static void formatInfo(int method) {
        switch (method) {
            case 1 -> System.out.println("dd/mm/yy (example: 01/01/01)");
            case 2 -> System.out.println("m/d/yyyy (example: 1/1/2021)");
            case 3 -> System.out.println("mmm-d-yy (example: March-1-01)");
            case 4 -> System.out.println("dd-mmm-yyyy (example: 01-April-2021)");
        }
    }

    private static boolean isDate(String str, int method) {
        boolean validFormat = true;
        int days = 1;
        int month = 1;
        int years = 0;
        String[] date = str.split(" ");
        if (date.length != 2 && date.length != 1) {
            validFormat = DateError();
        } else {
            switch (method) {
                case 1 -> {
                    String[] dateValue = split(date[0], "/");
                    if (dateValue.length != 3
                            || (!dateValue[0].isEmpty() && dateValue[0].length() != 2)
                            || (!dateValue[1].isEmpty() && dateValue[1].length() != 2)
                            || (dateValue[2].length() == 1)) {
                        validFormat = DateError();
                    } else try {
                        if (!dateValue[0].isEmpty()) {
                            days = Integer.parseInt(dateValue[0]);
                        }
                        if (!dateValue[1].isEmpty()) {
                            month = Integer.parseInt(dateValue[1]);
                        }
                        if (!dateValue[2].isEmpty()) {
                            years = Integer.parseInt(dateValue[2]);
                            validFormat = LimitError(years);
                        }
                    } catch (NumberFormatException e) {
                        validFormat = DateError();
                    }
                }
                case 2 -> {
                    String[] dateValue = split(date[0], "/");
                    if (dateValue.length != 3 || (!dateValue[2].isEmpty() && dateValue[2].length() < 4)) {
                        validFormat = DateError();
                    } else try {
                        if (!dateValue[1].isEmpty()) {
                            days = Integer.parseInt(dateValue[1]);
                        }
                        if (!dateValue[0].isEmpty()) {
                            month = Integer.parseInt(dateValue[0]);
                        }
                        if (!dateValue[2].isEmpty()) {
                            years = Integer.parseInt(dateValue[2]);
                            validFormat = LimitError(years);
                        }
                    } catch (NumberFormatException e) {
                        validFormat = DateError();
                    }
                }
                case 3 -> {
                    String[] dateValue = split(date[0], "-");
                    if (dateValue.length != 3 || (dateValue[2].length() == 1)) {
                        validFormat = DateError();
                    } else try {
                        if (!dateValue[1].isEmpty()) {
                            days = Integer.parseInt(dateValue[1]);
                        }
                        if (!dateValue[0].isEmpty()) {
                            month = Arrays.asList(months).indexOf(dateValue[0].toLowerCase());
                        }
                        if (!dateValue[2].isEmpty()) {
                            years = Integer.parseInt(dateValue[2]);
                            validFormat = LimitError(years);
                        }
                    } catch (NumberFormatException e) {
                        validFormat = DateError();
                    }
                }
                case 4 -> {
                    String[] dateValue = split(date[0], "-");
                    if (dateValue.length != 3
                            || (!dateValue[0].isEmpty() && dateValue[0].length() != 2)
                            || (!dateValue[2].isEmpty() && dateValue[2].length() < 4)) {
                        validFormat = DateError();
                    } else try {
                        if (!dateValue[0].isEmpty()) {
                            days = Integer.parseInt(dateValue[0]);
                        }
                        if (!dateValue[1].isEmpty()) {
                            month = Arrays.asList(months).indexOf(dateValue[1].toLowerCase());
                        }
                        if (!dateValue[2].isEmpty()) {
                            years = Integer.parseInt(dateValue[2]);
                            validFormat = LimitError(years);
                        }
                    } catch (NumberFormatException e) {
                        validFormat = DateError();
                    }
                }
            }
            if (validFormat) {
                if (days < 1 || month < 1 || month > 12 || years < 0) {
                    validFormat = DateError();
                }
                boolean leapYear = (years % 4 == 0 && years % 100 != 0) || years % 400 == 0;
                if ((month == 1 && days > 31) || (month == 2 && days > 29 && leapYear)
                        || (month == 2 && days > 28 && !leapYear)
                        || (month == 3 && days > 31)
                        || (month == 4 && days > 30)
                        || (month == 5 && days > 31)
                        || (month == 6 && days > 30)
                        || (month == 7 && days > 31)
                        || (month == 8 && days > 31)
                        || (month == 9 && days > 30)
                        || (month == 10 && days > 31)
                        || (month == 11 && days > 30)
                        || (month == 12 && days > 31)) {
                    validFormat = DateError();
                }
            }
            if (date.length == 2) {
                String[] timeValue = split(date[1], ":");
                try {
                    if (!timeValue[0].isEmpty()) {
                        int hour = Integer.parseInt(timeValue[0]);
                        if (hour < 0 || hour > 23) {
                            validFormat = DateError();
                        } else {
                            if (!timeValue[1].isEmpty()) {
                                int min = Integer.parseInt(timeValue[1]);
                                if (min < 0 || min > 59) {
                                    validFormat = DateError();
                                } else {
                                    if (timeValue.length > 2) {
                                        if (!timeValue[2].isEmpty()) {
                                            int sec = Integer.parseInt(timeValue[2]);
                                            if (sec < 0 || sec > 59) {
                                                validFormat = DateError();
                                            } else if (timeValue.length > 3) {
                                                if (!timeValue[3].isEmpty()) {
                                                    int ms = Integer.parseInt(timeValue[3]);
                                                    if (ms < 0 || ms > 999) {
                                                        validFormat = DateError();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    validFormat = DateError();
                }
            }
        }
        return validFormat;
    }

    private static boolean LimitError(long year) {
        if ((year + 1) * 365.25 > 106751991167L) {
            System.out.println("Дата выходит за пределы календаря");
            return false;
        }
        return true;
    }

    private static String[] split(String str, String separator) {
        String[] splitStr = (str + " ").split(separator);
        if (splitStr[splitStr.length - 1] != null && splitStr[splitStr.length - 1].length() > 0) {
            splitStr[splitStr.length - 1] = splitStr[splitStr.length - 1].substring(0, splitStr[splitStr.length - 1].length() - 1);
        }
        return splitStr;
    }

    private static boolean DateError() {
        System.out.println("Недопустимый ввод");
        return false;
    }
}

