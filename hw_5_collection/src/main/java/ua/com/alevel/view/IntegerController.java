package ua.com.alevel.view;

import ua.com.alevel.mathsetnumber.MathSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IntegerController {

    private static final MathSet<Integer> mathSet = new MathSet<>();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String position;
        try {
            System.out.println("Start Program Integer MathSet");
            menuProgram();
            while ((position = reader.readLine()) != null && !position.equals("0")) {
                methodsMathSet(position, reader);
            }
        } catch (Exception exception) {
            System.out.println("problem: = " + exception.getMessage());
        }
    }

    private void menuProgram() {
        System.out.println("1 - Add new MathSet | 2 - Print MathSet | 3 - Join MathSet | 4 - Intersection MathSet | 5 - Sort Descending \n" +
                "6 - sortDesc(First index, Last index) | 7 - sortDescByValue(Value) | 8 - Sort Ascending | 9 - sortAsc(First index, Last index)\n" +
                "10 - sortAscByValue(Value) | 11 - get(index) | 12 - getMax | 13 - getMin | 14 - Average | 15 - Median | 16 - Cut\n" +
                "17 - Clear  | 18 - Clear(Number[] numbers) | 0 - exit");
        System.out.print("select your choice ---> ");
    }

    private void methodsMathSet(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> add(reader);
            case "2" -> {
                out(mathSet);
                System.out.println();
            }
            case "3" -> join(reader);
            case "4" -> intersection(reader);
            case "5" -> sortDesk();
            case "6" -> sortDesk(reader);
            case "7" -> sortDeskByValue(reader);
            case "8" -> sortAsc();
            case "9" -> sortAsc(reader);
            case "10" -> sortAscByValue(reader);
            case "11" -> get(reader);
            case "12" -> getMax();
            case "13" -> getMin();
            case "14" -> getAverage();
            case "15" -> getMedian();
            case "16" -> cut(reader);
            case "17" -> clear();
            case "18" -> clear(reader);
        }
        menuProgram();
    }

    private void add(BufferedReader reader) {
        System.out.print("Enter integer numbers through a space, example ---> 2 4 -6 8 10\n" +
                "---> ");
        try {
            String line = reader.readLine();
            String[] array = line.split("\\s");
            Integer[] numbers = new Integer[array.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.valueOf(array[i]);
            }
            mathSet.add(numbers);
            System.out.print("Result ---> ");
            out(mathSet);
            System.out.println();
        } catch (Exception exception) {
            System.out.println("Invalid input");
        }
    }

    public void join(BufferedReader reader) {
        System.out.print("Enter the numbers you want to join the existing MathSet\n" +
                "Example ---> 2 4 -6 8 10\n" +
                "---> ");
        if (mathSet.size() != 0) {
            try {
                String line = reader.readLine();
                String[] array = line.split("\\s");
                Integer[] numbers = new Integer[array.length];
                for (int i = 0; i < array.length; i++) {
                    numbers[i] = Integer.valueOf(array[i]);
                }
                MathSet<Integer> inputMathSet = new MathSet<>(numbers);
                System.out.print("Start MathSet ---> ");
                out(mathSet);
                System.out.print("Input MathSet ---> ");
                out(inputMathSet);
                mathSet.join(inputMathSet);
                System.out.print("Result MathSet ---> ");
                out(mathSet);
                System.out.println();
            } catch (Exception exception) {
                System.out.println("Invalid input");
            }
        } else {
            System.out.println("MathSet is empty");
        }
    }

    public void intersection(BufferedReader reader) {
        System.out.print("Enter the numbers you want to get intersection of arrays\n" +
                "Example ---> 2 4 -6 8 10\n" +
                "---> ");
        if (mathSet.size() != 0) {
            try {
                String line = reader.readLine();
                String[] array = line.split("\\s");
                Integer[] numbers = new Integer[array.length];
                for (int i = 0; i < array.length; i++) {
                    numbers[i] = Integer.valueOf(array[i]);
                }
                MathSet<Integer> inputMathSet = new MathSet<>(numbers);
                System.out.print("Start MathSet ---> ");
                out(mathSet);
                System.out.print("Input MathSet ---> ");
                out(inputMathSet);
                mathSet.intersection(inputMathSet);
                System.out.print("Result MathSet ---> ");
                out(mathSet);
                System.out.println();
            } catch (Exception exception) {
                System.out.println("Invalid input");
            }
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void sortDesk() {
        if (mathSet.size() != 0) {
            System.out.print("Start MathSet ---> ");
            out(mathSet);
            System.out.print("Sort descending ---> ");
            mathSet.sortDesc();
            out(mathSet);
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void sortDesk(BufferedReader reader) {
        if (mathSet.size() != 0) {
            try {
                System.out.print("Enter your first index ---> ");
                int firstIndex = Integer.parseInt(reader.readLine());
                System.out.print("Enter your last index ---> ");
                int lastIndex = Integer.parseInt(reader.readLine());
                System.out.print("Start MathSet ---> ");
                out(mathSet);
                System.out.print("Sort descending ---> ");
                mathSet.sortDesc(firstIndex, lastIndex);
                out(mathSet);
            } catch (Exception exception) {
                System.out.println("problem: = " + exception.getMessage());
            }
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void sortDeskByValue(BufferedReader reader) {
        if (mathSet.size() != 0) {
            try {
                System.out.print("Enter your value ---> ");
                int value = Integer.parseInt(reader.readLine());
                System.out.print("Start MathSet ---> ");
                out(mathSet);
                System.out.print("Sort descending ---> ");
                mathSet.sortDesc(value);
                out(mathSet);
            } catch (Exception exception) {
                System.out.println("problem: = " + exception.getMessage());
            }
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void sortAsc() {
        if (mathSet.size() != 0) {
            System.out.print("Start MathSet ---> ");
            out(mathSet);
            System.out.print("Sort descending ---> ");
            mathSet.sortAsc();
            out(mathSet);
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void sortAsc(BufferedReader reader) {
        if (mathSet.size() != 0) {
            try {
                System.out.print("Enter your first index ---> ");
                int firstIndex = Integer.parseInt(reader.readLine());
                System.out.print("Enter your last index ---> ");
                int lastIndex = Integer.parseInt(reader.readLine());
                System.out.print("Start MathSet ---> ");
                out(mathSet);
                System.out.print("Sort descending ---> ");
                mathSet.sortAsc(firstIndex, lastIndex);
                out(mathSet);
            } catch (Exception exception) {
                System.out.println("problem: = " + exception.getMessage());
            }
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void sortAscByValue(BufferedReader reader) {
        if (mathSet.size() != 0) {
            try {
                System.out.print("Enter your value ---> ");
                int value = Integer.parseInt(reader.readLine());
                System.out.print("Start MathSet ---> ");
                out(mathSet);
                System.out.print("Sort descending ---> ");
                mathSet.sortAsc(value);
                out(mathSet);
            } catch (Exception exception) {
                System.out.println("problem: = " + exception.getMessage());
            }
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void get(BufferedReader reader) {
        if (mathSet.size() != 0) {
            try {
                System.out.print("Enter your index ---> ");
                int index = Integer.parseInt(reader.readLine());
                System.out.print("Start MathSet ---> ");
                out(mathSet);
                System.out.println("result ---> " + mathSet.get(index));
            } catch (Exception exception) {
                System.out.println("problem: = " + exception.getMessage());
            }
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void getMax() {
        if (mathSet.size() != 0) {
            System.out.println("Max Element ---> " + mathSet.getMax());
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void getMin() {
        if (mathSet.size() != 0) {
            System.out.println("result Element ---> " + mathSet.getMin());
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void getAverage() {
        if (mathSet.size() != 0) {
            System.out.println("result Average ---> " + mathSet.getAverage());
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void getMedian() {
        if (mathSet.size() != 0) {
            System.out.println("result Median ---> " + mathSet.getMedian());
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void cut(BufferedReader reader) {
        if (mathSet.size() != 0) {
            try {
                System.out.print("Enter your first index ---> ");
                int firstIndex = Integer.parseInt(reader.readLine());
                System.out.print("Enter your last index ---> ");
                int lastIndex = Integer.parseInt(reader.readLine());
                System.out.print("Start MathSet ---> ");
                out(mathSet);
                System.out.print("cut MathSet ---> ");
                out(mathSet.cut(firstIndex, lastIndex));
            } catch (Exception exception) {
                System.out.println("problem: = " + exception.getMessage());
            }
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void clear() {
        if (mathSet.size() != 0) {
            mathSet.clear();
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void clear(BufferedReader reader) {
        System.out.print("Enter the numbers you want to clear\n" +
                "Example ---> 2 4 -6 8 10\n" +
                "---> ");
        if (mathSet.size() != 0) {
            try {
                String line = reader.readLine();
                String[] array = line.split("\\s+");
                Integer[] numbers = new Integer[array.length];
                for (int i = 0; i < array.length; i++) {
                    numbers[i] = Integer.valueOf(array[i]);
                }
                System.out.print("Start MathSet ---> ");
                out(mathSet);
                mathSet.clear(numbers);
                if (mathSet.size() != 0) {
                    System.out.print("Result MathSet ---> ");
                    out(mathSet);
                    System.out.println();
                } else {
                    System.out.println("MathSet is empty");
                }
            } catch (Exception exception) {
                System.out.println("Invalid input");
            }
        } else {
            System.out.println("MathSet is empty");
        }
    }

    private void out(MathSet<Integer> mathSet) {
        if (mathSet.size() != 0) {
            System.out.print("mathSet = [");
            for (int i = 0; i < mathSet.size(); i++) {
                if (i == mathSet.size() - 1) {
                    System.out.println(mathSet.get(i) + "]");
                } else {
                    System.out.print(mathSet.get(i) + ", ");
                }
            }
        } else {
            System.out.println("MathSet is empty");
        }
    }
}
