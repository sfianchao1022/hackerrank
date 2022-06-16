package com.example;

import java.util.ArrayList;
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


    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int marsExploration(String s) {
        // Write your code here
        int i = 0;
        int diff = 0;
        String original = "SOS";
        while (i <= s.length() - 2) {
            String sub = s.substring(i, i + 3);
            for (int j = 0; j < sub.length(); j++) {
                if (!(sub.charAt(j) == original.charAt(j))) {
                    diff++;
                }
            }
            i += 3;
        }

        return diff;
    }

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (Integer grade : grades) {
            Integer upper = 5 * ((grade / 5) + 1);
            if (grade < 38) {
                result.add(grade);
            } else if (upper - grade < 3) {
                result.add(upper);
            } else {
                result.add(grade);
            }
        }
        return result;
    }

}
