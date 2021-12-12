package hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static List<Integer> reverseArray(List<Integer> a) {
        // Write your code here
        Collections.reverse(a);
        return a;
    }

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.size() - 1; i++) {
            for (int j = 1; j < arr.get(i).size() - 1; j++) {
                int up = arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j) + arr.get(i - 1).get(j + 1);
                int mid = arr.get(i).get(j);
                int down = arr.get(i + 1).get(j - 1) + arr.get(i + 1).get(j) + arr.get(i + 1).get(j + 1);
                list.add(up + mid + down);
            }
        }
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        return sortedList.get(sortedList.size() - 1);
    }

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */
    public static long repeatedString(String s, long n) {
        // Write your code here
        List<String> list = List.of(s.split(""));

        int num = 0;
        for (String str : list) {
            if (str.equals("a")){
                num = num + 1;
            }
        }
        System.out.println(num);

        List<String> leftList = new ArrayList<>();
        long leftLength = n % (long) list.size();
        if (leftLength != 0) {
            leftList = list.subList(0, (int) leftLength);
        }

        int leftNum = 0;
        for (String str : leftList) {
            if (str.equals("a")){
                leftNum = leftNum + 1;
            }
        }
        System.out.println(leftNum);

        Long ans = num * (n / (long) list.size()) + leftNum;

        return ans;
    }

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */
    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here

        List<Integer> list = new ArrayList<>();
        int start = 0;
        int skip = 0;
        int ans = 0;
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i) == 1) {
                list.add(c.subList(start, i - 1).size());
                skip = skip + 1;
                start = i + 1;
            }
        }

        list.add(c.subList(start, c.size() - 1).size());

        for (Integer i : list) {
            if (i % 2 == 0) {
                ans = ans + (i / 2);
            } else {
                ans = ans + (i / 2) + 1;
            }
        }

        return ans + skip;
    }

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        // Write your code here
        int seaLevel = 0;

        int num = 0;
        for (int i = 0; i < path.length(); i++) {
            String s = String.valueOf(path.charAt(i));
            if (s.equals("U")) {
                seaLevel++;
            } else {
                seaLevel--;
            }

            // if we just came UP to sea level
            if (seaLevel == 0 && s.equals("U")) {
                num++;
            }
        }
        return num;
    }

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        map.put("p", 0);
        map.put("z", 0);
        map.put("n", 0);
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i) > 0){
                map.put("p", map.get("p") + 1);
            } else if (arr.get(i) == 0){
                map.put("z", map.get("z") + 1);
            } else {
                map.put("n", map.get("n") + 1);
            }
        }

        float p = (float) (Math.round((map.get("p") / (float)arr.size()) * 1000000))/1000000;
        float z = (float) (Math.round((map.get("z") / (float)arr.size()) * 1000000))/1000000;
        float n = (float) (Math.round((map.get("n") / (float)arr.size()) * 1000000))/1000000;

        System.out.println(p);
        System.out.println(n);
        System.out.println(z);

        // another solution
//        int pos = 0;
//        int zero = 0;
//        int neg = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            int x = arr.get(i);
//            if (x > 0) {
//                pos++;
//            } else if (x == 0) {
//                zero++;
//            } else {
//                neg++;
//            }
//        }
//        System.out.printf("%.6f\n", pos / (float) arr.size());
//        System.out.printf("%.6f\n", neg / (float) arr.size());
//        System.out.printf("%.6f\n", zero / (float) arr.size());

    }

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        List<Long> list = arr.stream().mapToLong(Integer::longValue).sorted().boxed().collect(Collectors.toList());
        long min = list.get(0) + list.get(1) + list.get(2) + list.get(3);
        long max = list.get(1) + list.get(2) + list.get(3) + list.get(4);

//        // selection sort
//        for (int i = 0; i < arr.size() - 1; i++){
//            for (int j = i + 1; j < arr.size(); j++){
//                if (arr.get(i) > arr.get(j)){
//                    int temp = arr.get(j);
//                    arr.set(j, arr.get(i));
//                    arr.set(i, temp);
//                }
//            }
//        }
//        int min = arr.get(0) + arr.get(1) + arr.get(2) + arr.get(3);
//        int max = arr.get(1) + arr.get(2) + arr.get(3) + arr.get(4);

        System.out.println(min + " " + max);
    }

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) {
        // Write your code here
        int hour = Integer.parseInt(s.substring(0, 2));
        String ampm = s.substring(s.length() - 2, s.length());

        if (hour >= 12 && ampm.equals("AM")) {
            hour = hour - 12;
        }

        if (hour < 12 && ampm.equals("PM")) {
            hour = hour + 12;
        }

        String h = "";
        if (hour < 10) {
            h = "0" + String.valueOf(hour);
        } else {
            h = String.valueOf(hour);
        }
        s = h + s.substring(2, s.length() - 2);
        System.out.println(s);
        return s;
    }

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (String string : strings) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        for (String query : queries) {
            list.add(map.getOrDefault(query, 0));
        }

        return list;
    }

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static int lonelyInteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return 0;
    }

    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */
    public static long flippingBits(long n) {
        // Write your code here
        return (long) (Math.pow(2, 32) - 1) - n;
    }

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum1 += arr.get(i).get(i);
            sum2 += arr.get(i).get(arr.size() - 1 - i);
        }

        if (sum1 >= sum2) {
            return sum1 - sum2;
        } else {
            return sum2 - sum1;
        }
    }

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            result.add(0);
        }
        for (Integer i : arr) {
            int count = result.get(i) + 1;
            result.set(i, count);
        }
        return result;
    }

    









}
