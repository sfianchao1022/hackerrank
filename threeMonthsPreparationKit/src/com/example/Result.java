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

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int pairs = 0;
        for (int i = 0; i < ar.size(); i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

}
