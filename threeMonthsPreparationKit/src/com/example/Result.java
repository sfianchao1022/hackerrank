package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        HashMap<String, Integer> minMax = new HashMap<>();
        minMax.put("min", scores.get(0));
        minMax.put("Max", scores.get(0));
        int min = 0;
        int max = 0;

        for (Integer score : scores) {
            if (score < minMax.get("min")) {
                minMax.put("min", score);
                min++;
            } else if (score > minMax.get("Max")) {
                minMax.put("Max", score);
                max++;
            }
        }

        minMax.entrySet().forEach(System.out::println);

        return Arrays.asList(max, min);
    }


}
