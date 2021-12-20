package ua.com.alevel.calendar;

import java.util.*;

public class DataCalendar {
    private static long mlSec;
    private static int second;
    private static int minute;
    private static int hour;
    private static int day;
    private static int month;
    private static int year;
    private static long countDayInMillisecond;
    long timeInMillisecond;
    private static int[] daysOfMonth = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    private static int[] daysOfMonthHigh = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};
    private static final int MILLI_SECOND_IN_MINUTE = 1000 * 60;
    private static final int MILLION = 1_000_000;
    private static final long MILLI_SECOND_IN_HOUR = 3_600_000L;
    String[] months = {"january", "february", "march", "april", "may", "june", "july",
            "august", "september", "october", "november", "december"};

    public DataCalendar() {
    }

    public DataCalendar(String inputData, String inputFormat) {
        timeInMillisecond = convertsToMilliseconds(inputData, inputFormat);
    }

    public long convertsToMilliseconds(String value, String format) {

        String[] inputData = value.split("\s");
        switch (format) {
            case "dd/mm/yy" -> {
                String[] dataConvert = inputData[0].split("/");
                if (dataConvert[0].isEmpty()) day = 1;
                else day = Integer.parseInt(dataConvert[0]);
                if (dataConvert[1].isEmpty()) month = 1;
                else month = Integer.parseInt(dataConvert[1]);
                if (dataConvert[2].isEmpty()) year = 0;
                else year = Integer.parseInt(dataConvert[2]);
            }
            case "m/d/yyyy" -> {
                String[] dataConvert = inputData[0].split("/");
                if (dataConvert[0].isEmpty()) month = 1;
                else month = Integer.parseInt(dataConvert[0]);
                if (dataConvert[1].isEmpty()) day = 1;
                else day = Integer.parseInt(dataConvert[1]);
                if (dataConvert[2].isEmpty()) year = 0;
                else year = Integer.parseInt(dataConvert[2]);
            }
            case "mmm-d-yy" -> {
                String[] dataConvert = inputData[0].split("-");
                if (dataConvert[0].isEmpty()) month = 1;
                else month = Arrays.asList(months).indexOf(dataConvert[0].toLowerCase()) + 1;
                if (dataConvert[1].isEmpty()) day = 1;
                else day = Integer.parseInt(dataConvert[1]);
                if (dataConvert[2].isEmpty()) year = 0;
                else year = Integer.parseInt(dataConvert[2]);
            }
            case "dd-mmm-yyyy" -> {
                String[] dataConvert = inputData[0].split("-");
                if (dataConvert[0].isEmpty()) day = 1;
                else day = Integer.parseInt(dataConvert[0]);
                if (dataConvert[1].isEmpty()) month = 1;
                else month = Arrays.asList(months).indexOf(dataConvert[1].toLowerCase()) + 1;
                if (dataConvert[2].isEmpty()) year = 0;
                else year = Integer.parseInt(dataConvert[2]);
            }
        }
        if (inputData.length > 1) {
            String[] timeConvert = inputData[1].split(":");
            if (timeConvert[0].isEmpty()) hour = 0;
            else hour = Integer.parseInt(timeConvert[0]);
            if (timeConvert[1].isEmpty()) minute = 0;
            else minute = Integer.parseInt(timeConvert[1]);
            if (timeConvert.length > 2) {
                if (timeConvert[2].isEmpty()) second = 0;
                else second = Integer.parseInt(timeConvert[2]);
            }
            if (timeConvert.length > 3) {
                if (timeConvert[3].isEmpty()) mlSec = 0;
                else mlSec = Integer.parseInt(timeConvert[3]);
            }
        }
        countDayInMillisecond = ((year + 3) / 4 + (year + 399) / 400 - (year + 99) / 100) * 86400000L;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return (year * (MILLI_SECOND_IN_HOUR * 24 * 365) + (MILLI_SECOND_IN_HOUR * 24 * daysOfMonthHigh[month - 1] - 86400000L)
                    + day * (MILLI_SECOND_IN_HOUR * 24) + hour * MILLI_SECOND_IN_HOUR + minute * 60000L + second * 1000L + mlSec + countDayInMillisecond);
        } else {
            return year * (MILLI_SECOND_IN_HOUR * 24 * 365) + (MILLI_SECOND_IN_HOUR * 24 * daysOfMonth[month - 1] - 86400000L)
                    + day * (MILLI_SECOND_IN_HOUR * 24) + hour * MILLI_SECOND_IN_HOUR + minute * 60000L + second * 1000L + mlSec + countDayInMillisecond;
        }
    }

    public void convertsToCurrentData(long mlSec, String format) {
        long resultMilliSec;
        long resultSec;
        long resultMin;
        long resultHour;
        long resultDay;
        int resultMonth = 1;
        String stringResultDay;
        String stringResultMonth;
        String stringResultYear;
        String stringResultHour;
        String stringResultMinute;
        String stringResultSecond;
        long resultYearNotOffset = mlSec / (31536L * MILLION);
        long offset = (((resultYearNotOffset + 3) / 4 + (resultYearNotOffset + 399) / 400 - (resultYearNotOffset + 99) / 100) * 86400000L);
        long resultYear = (mlSec - offset) / (31536L * MILLION);
        resultDay = ((mlSec - offset) - (resultYear * 31536L * MILLION)) / ((31536L * MILLION) / 365);
        if (resultYear > 1403 && (resultYear % 4 == 0 && resultYear % 100 != 0) || (resultYear % 400 == 0)) {
            resultDay++;
        }
        if ((resultYear % 4 == 0 && resultYear % 100 != 0) || (resultYear % 400 == 0)) {
            for (int i = 1; i < daysOfMonthHigh.length; i++) {
                if (resultDay >= daysOfMonthHigh[i - 1] && resultDay < daysOfMonthHigh[i]) {
                    resultMonth = i;
                    break;
                }
            }
            resultDay = resultDay - daysOfMonthHigh[(resultMonth - 1)] + 1;
        } else {
            for (int i = 1; i < daysOfMonth.length; i++) {
                if (resultDay >= daysOfMonth[i - 1] && resultDay < daysOfMonth[i]) {
                    resultMonth = i;
                    break;
                }
            }
            resultDay = resultDay - daysOfMonth[(resultMonth - 1)] + 1;
        }
        resultMilliSec = (mlSec % 1000);
        resultSec = ((mlSec / 1000) % 60);
        resultMin = (mlSec / (60000) % 60);
        resultHour = ((mlSec / (1000 * 60 * 60)) % 24);

        if (resultDay < 10) stringResultDay = "0" + resultDay;
        else stringResultDay = String.valueOf(resultDay);
        if (resultMonth < 10) stringResultMonth = "0" + resultMonth;
        else stringResultMonth = String.valueOf(resultMonth);
        if (resultYear < 10) stringResultYear = "0" + resultYear;
        else stringResultYear = String.valueOf(resultYear);
        if (resultHour < 10) stringResultHour = "0" + resultHour;
        else stringResultHour = String.valueOf(resultHour);
        if (resultMin < 10) stringResultMinute = "0" + resultMin;
        else stringResultMinute = String.valueOf(resultMin);
        if (resultSec < 10) stringResultSecond = "0" + resultSec;
        else stringResultSecond = String.valueOf(resultSec);

        switch (format) {
            case "dd/mm/yy" -> System.out.println(stringResultDay + "/" + stringResultMonth + "/" + stringResultYear + " " + stringResultHour + ":" + stringResultMinute + ":" + stringResultSecond + ":" + resultMilliSec);
            case "m/d/yyyy" -> System.out.println(resultMonth + "/" + resultDay + "/" + resultYear + " " + resultHour + ":" + resultMin + ":" + resultSec + ":" + resultMilliSec);
            case "mmm-d-yy" -> System.out.println(months[resultMonth - 1] + "-" + resultDay + "-" + stringResultYear + " " + resultHour + ":" + resultMin + ":" + resultSec + ":" + resultMilliSec);
            case "dd-mmm-yyyy" -> System.out.println(stringResultDay + "-" + months[resultMonth - 1] + "-" + stringResultYear + " " + resultHour + ":" + resultMin + ":" + resultSec + ":" + resultMilliSec);
        }
    }

    public void sumInMilliSecondData(String inputData, String inputFormat, String outFormat, long sum) {
        long inputInMillisecond = convertsToMilliseconds(inputData, inputFormat);
        convertsToCurrentData(inputInMillisecond + sum, outFormat);
    }

    public void sumInSecondData(String inputData, String inputFormat, String outFormat, long sum) {
        long inputInSecond = convertsToMilliseconds(inputData, inputFormat);
        convertsToCurrentData(inputInSecond + sum * 1000, outFormat);
    }

    public void sumInMinuteData(String inputData, String inputFormat, String outFormat, long sum) {
        long inputInMinute = convertsToMilliseconds(inputData, inputFormat);
        convertsToCurrentData(inputInMinute + sum * MILLI_SECOND_IN_MINUTE, outFormat);
    }

    public void sumInHourData(String inputData, String inputFormat, String outFormat, long sum) {
        long inputInHour = convertsToMilliseconds(inputData, inputFormat);
        convertsToCurrentData(inputInHour + sum * MILLI_SECOND_IN_HOUR, outFormat);
    }

    public void sumInDayData(String inputData, String inputFormat, String outFormat, long sum) {
        long inputInDay = convertsToMilliseconds(inputData, inputFormat);
        convertsToCurrentData(inputInDay + sum * MILLI_SECOND_IN_HOUR * 24, outFormat);
    }

    public void sumInYearData(String inputData, String inputFormat, String outFormat, long sum) {
        long inputInYear = convertsToMilliseconds(inputData, inputFormat);
        convertsToCurrentData(inputInYear + (sum * (31536L * MILLION)), outFormat);
    }

    public void difference(String firstData, String secondData, String inputFormat) {
        long one = convertsToMilliseconds(firstData, inputFormat);
        long two = convertsToMilliseconds(secondData, inputFormat);
        long difference = Math.abs(one - two);
        System.out.println("Разница\n"
                + "в мсек: " + difference + "\n"
                + "в сек: " + difference / 1000 + "\n"
                + "в мин: " + difference / 60000 + "\n"
                + "в часах: " + difference / 3600000 + "\n"
                + "в днях: " + difference / 86400000 + "\n"
                + "в годах: " + difference / (31536L * MILLION));
    }

    public void sortAsc(List<String> inputList, String inputFormat, String outFormat) {
        ArrayList<Long> currentDate = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            currentDate.add(convertsToMilliseconds(inputList.get(i), inputFormat));
        }
        Collections.sort(currentDate);
        for (int i = 0; i < currentDate.size(); i++) {
            convertsToCurrentData(currentDate.get(i), outFormat);
        }
    }

    public void sortDesc(List<String> inputList, String inputFormat, String outFormat) {
        ArrayList<Long> currentDate = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            currentDate.add(convertsToMilliseconds(inputList.get(i), inputFormat));
        }
        Collections.sort(currentDate);
        Collections.reverse(currentDate);
        for (int i = 0; i < currentDate.size(); i++) {
            convertsToCurrentData(currentDate.get(i), outFormat);
        }
    }
}
