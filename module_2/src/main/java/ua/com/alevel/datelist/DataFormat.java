package ua.com.alevel.datelist;

import ua.com.alevel.util.ReadInputFile;
import ua.com.alevel.util.WriteOutFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DataFormat {

    private static final String DATE_INPUT = "input1.txt";
    private static final String DATE_OUT = "output1.txt";
    private static int maxDay = 31;
    private List<String> listInput = new ArrayList<>();
    private String patternFormat = "^((\\d{1,2}-\\d{1,2}-\\d{4})$)|^((\\d{4}\\/\\d{1,2}\\/\\d{1,2})$)|^(\\d{1,2}\\/\\d{1,2}\\/\\d{4})$";

    public void formattedDate() {
        String day;
        String month;
        String year;
        String[] splitDate;
        String[] splitLine;
        String result = "";
        String inputLine;

        inputLine = ReadInputFile.readInputFile(DATE_INPUT);
        splitLine = inputLine.split("\\s");
        listInput = Arrays.asList(splitLine);
        Pattern pattern = Pattern.compile(patternFormat);
        listInput = listInput.stream().filter(pattern.asPredicate()).collect(Collectors.toList());
        for (String s : listInput) {
            if (s.contains("-")) {
                splitDate = s.split("-");
                day = splitDate[1];
                month = splitDate[0];
                year = splitDate[2];
            } else {
                splitDate = s.split("/");
                if (Integer.parseInt(splitDate[0]) > maxDay) {
                    day = splitDate[2];
                    month = splitDate[1];
                    year = splitDate[0];
                } else {
                    day = splitDate[0];
                    month = splitDate[1];
                    year = splitDate[2];
                }
            }
            result += year + month + day + "\n";
        }
        WriteOutFile.write(DATE_OUT, result);
    }
}
