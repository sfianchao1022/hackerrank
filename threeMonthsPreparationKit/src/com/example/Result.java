package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class Result {

    /**
     * Trend Micro: Pairs Sums
     * @param A
     * @return
     */
    public static int pairsSums(int[] A) {

        int i = 1;
        int count = 0;

        while (i < A.length) {

            if (i == A.length - 1) {
                if ((A[i] + A[0]) % 2 == 0) {
                    count++;
                    break;
                }
            }

            if ((A[i] + A[i - 1]) % 2 == 0) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count;
    }

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

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int type = 0;

        for (Integer item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        for (Integer key : map.keySet()) {

            if (map.get(key) > max) {
                max = map.get(key);
                type = key;
            } else if (map.get(key) == max && key < type) {
                type = key;
            }
        }
        return type;
    }

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int i = 0;
        int count = 0;
        while (i <= s.size() - m) {
            int sum = 0 ;
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }
            if (sum == d) {
                count++;
            }
            i++;
        }
        return count;
    }

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int[] arr = new int[100];
        int max = 0;

        for (int i = 0; i < a.size(); i++) {
            arr[a.get(i)]++;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            max = Math.max(max, arr[i] + arr[i + 1]);
        }

        return max;

    }

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        for (int i = 0; i < d; i++) {
            arr.add(arr.get(0));
            arr.remove(0);
        }
        arr.forEach(System.out::println);

        return arr;
    }

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        int deltaX = Math.abs(x1 - x2);
        int deltaV = Math.abs(v1 - v2);

        if ((x1 >= x2 && v1 >= v2) || (x2 >= x1 && v2 >= v1)) {
            return "NO";
        } else if (deltaX % deltaV == 0) {
            return "YES";
        }
        return "NO";
    }

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */
    public static void separateNumbers(String s) {
        // Write your code here
        String substring = "";
        boolean isValid = false;
        for (int i = 1; i <= s.length() / 2; i++) {
            substring = s.substring(0, i);
            Long num = Long.parseLong(substring);
            String valid = substring;
            while (valid.length() < s.length()) {
                valid += String.valueOf(++num);
            }
            if (s.equals(valid)) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            System.out.println("YES " + substring);
        } else {
            System.out.println("NO");
        }
    }

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        List<Integer> list = new ArrayList<>();
        Long min = 0l;
        for (int i = 0; i < arr.size() - 1; i++) {
            Long delta = Math.abs(Long.valueOf(arr.get(i)) - Long.valueOf(arr.get(i + 1)));
            if (min == 0 || delta == min) {
                min = delta;
                list.addAll(Arrays.asList(arr.get(i), arr.get(i + 1)));
            } else if (delta < min) {
                list.clear();
                min = delta;
                list.addAll(Arrays.asList(arr.get(i), arr.get(i + 1)));
            }
        }
        List<Integer> result = list.stream().sorted().collect(Collectors.toList());
        return result;
    }

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            Long delta = Math.abs(Long.valueOf(arr.get(i)) - Long.valueOf(arr.get(i + 1)));
            if (delta < min) {
                min = delta.intValue();
            }
        }
        return min;
    }


    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        List<String> num = Arrays.asList("0123456789".split(""));
        List<String> lower = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));
        List<String> upper = Arrays.asList("ABCDEFGHIJKLMNOP[QRSTUVWXYZ".split(""));
        List<String> special = Arrays.asList("!@#$%^&*()-+".split(""));

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = String.valueOf(password.charAt(i));
            if (num.contains(str)) {
                map.put("num", map.getOrDefault("num", 0) + 1);
            } else if (lower.contains(str)) {
                map.put("lower", map.getOrDefault("lower", 0) + 1);
            } else if (upper.contains(str)) {
                map.put("upper", map.getOrDefault("upper", 0) + 1);
            } else if (special.contains(str)) {
                map.put("special", map.getOrDefault("special", 0) + 1);
            }
        }

        if ((6 - n) <= 4 - map.size()) {
            return 4 - map.size();
        } else {
            return 6 - n;
        }
    }


    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (Integer a : arr) {
            mapA.put(a, mapA.getOrDefault(a, 0) + 1);
        }
        for (Integer b : brr) {
            mapB.put(b, mapB.getOrDefault(b, 0) + 1);
        }

        for (Integer key : mapB.keySet()) {
            if (!mapA.containsKey(key)) {
                result.add(key);
            } else if (mapA.containsKey(key) && !mapA.get(key).equals(mapB.get(key))) {
                result.add(key);
            }
        }
        return result;
    }

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        // Write your code here
        ArrayList<String>[] list = new ArrayList[100];

        for (int i = 0; i < arr.size(); i++) {
            int index = Integer.parseInt(arr.get(i).get(0));
            if (i < arr.size() / 2) {
                if (list[index] != null) {
                    list[index].add("-");
                } else {
                    list[index] = new ArrayList<>();
                    list[index].add("-");
                }
            } else {
                if (list[index] != null) {
                    list[index].add(arr.get(i).get(1));
                } else {
                    list[index] = new ArrayList<>();
                    list[index].add(arr.get(i).get(1));
                }
            }
        }
        String ans = "";
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                List<String> sub = list[i];
                for (String str : sub) {
                    ans += str + " ";
                }
            }
        }
        System.out.println(ans);
    }



}
