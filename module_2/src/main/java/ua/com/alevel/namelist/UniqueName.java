package ua.com.alevel.namelist;

import ua.com.alevel.util.ReadInputFile;
import ua.com.alevel.util.WriteOutFile;

import java.util.*;

public class UniqueName {

    private static final String DATE_INPUT = "input2.txt";
    private static final String DATE_OUT = "output2.txt";

    public void returnFirstUniqueName() {
        String result;
        String inputLine;
        String[] arrayNames;
        List<String> listInput = new ArrayList<>();
        inputLine = ReadInputFile.readInputFile(DATE_INPUT);
        arrayNames = inputLine.split("\\P{L}+");
        listInput = Arrays.asList(arrayNames);
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("", 2);
        listInput.forEach(names -> {
            map.merge(names, 1, Integer::sum);
        });
        result = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
        WriteOutFile.write(DATE_OUT, result);
    }
}

