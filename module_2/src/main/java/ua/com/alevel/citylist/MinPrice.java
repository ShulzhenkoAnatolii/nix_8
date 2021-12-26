package ua.com.alevel.citylist;

import ua.com.alevel.util.InvalidInputException;
import ua.com.alevel.util.ReadInputFile;
import ua.com.alevel.util.WriteOutFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPrice {

    public static final String INPUT_FILE = "input3.txt";
    public static final String OUTPUT_FILE = "output3.txt";
    public static final int INFINITY = Integer.MAX_VALUE;

    private static int numOfCities;

    public void run() {
        List<String> inputList = new ArrayList<>();
        inputList = Arrays.asList(ReadInputFile.readInputFile(INPUT_FILE).split("\\n"));
        List<Integer> result = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        int readingLine = 1;
        try {
            numOfCities = Integer.parseInt(inputList.get(0));
            if (numOfCities > 1000)
                throw new InvalidInputException();
            int[][] graph = new int[numOfCities][numOfCities];
            List<String> cities = new ArrayList<>();
            for (int i = 0; i < numOfCities; i++) {
                cities.add(inputList.get(readingLine++));
                int numOfNeighbours = Integer.parseInt(inputList.get(readingLine++));
                for (int j = 0; j < numOfNeighbours; j++) {
                    String[] neighbours = inputList.get(readingLine++).split(" ");
                    int cost = Integer.parseInt(neighbours[1]);
                    if (cost > 200000) {
                        throw new InvalidInputException();
                    } else {
                        graph[i][Integer.parseInt(neighbours[0]) - 1] = cost;
                    }
                }
            }
            if (cities.size() != numOfCities)
                throw new InvalidInputException();
            for (int i = 0; i < numOfCities; i++) {
                for (int j = 0; j < numOfCities; j++) {
                    if (graph[i][j] == 0) graph[i][j] = INFINITY;
                }
            }
            for (int i = 0; i < numOfCities; i++) {
                for (int j = 0; j < numOfCities; j++) {
                    if (graph[i][j] != graph[j][i])
                        throw new InvalidInputException();
                }
            }
            int waysToFind = Integer.parseInt(inputList.get(readingLine++));
            if (waysToFind > 100)
                throw new InvalidInputException();
            for (int i = 0; i < waysToFind; i++) {
                String[] paths = inputList.get(readingLine++).split(" ");
                int startPoint, endPoint;
                startPoint = cities.indexOf(paths[0]);
                endPoint = cities.indexOf(paths[1]);
                boolean[] visited = new boolean[numOfCities];
                result.add(findCheapestCost(startPoint, endPoint, visited, graph));
                if (result.get(result.size() - 1) == INFINITY) {
                    output.append("End and start points are disconnected\n");
                } else {
                    output.append(result.get(result.size() - 1)).append("\n");
                }
            }
            if (result.size() != waysToFind)
                throw new InvalidInputException();
        } catch (NumberFormatException | InvalidInputException | IndexOutOfBoundsException e) {
            output = new StringBuilder("Invalid input data");
        } finally {
            WriteOutFile.write(OUTPUT_FILE, output.toString());
        }
    }

    private static int findCheapestCost(int startPoint, int endPoint, boolean[] visited, int[][] graph) {
        if (startPoint == endPoint)
            return 0;
        visited[startPoint] = true;
        int cost = INFINITY;
        for (int i = 0; i < numOfCities; i++) {
            if (graph[startPoint][i] != INFINITY && !visited[i]) {
                int current = findCheapestCost(i, endPoint, visited, graph);
                if (current < INFINITY) {
                    cost = Math.min(cost, graph[startPoint][i] + current);
                }
            }
        }
        visited[startPoint] = false;
        return cost;
    }

}
