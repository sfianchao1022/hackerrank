package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
    public static String twoStrings(String s1, String s2) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        Set<String> set1 = new HashSet<>(Arrays.asList(s1.split("")));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2.split("")));
//        Set<String> set1 = new HashSet<>();
//        Set<String> set2 = new HashSet<>();
//        List<String> list1 = Arrays.asList(s1.split(""));
//        List<String> list2 = Arrays.asList(s2.split(""));
//        list1.forEach(s -> set1.add(s));
//        list2.forEach(s -> set2.add(s));

        for (String str : set1) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : set2) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String s : map.keySet()) {
            if (map.get(s) > 1) {
                return "YES";
            }
        }
        return "NO";
    }

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */
    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        Map<String, Integer> magazineMap = new HashMap<>();
        Map<String, Integer> noteMap = new HashMap<>();
        for (String s : magazine) {
            magazineMap.put(s, magazineMap.getOrDefault(s, 0) + 1);
        }
        for (String s : note) {
            noteMap.put(s, noteMap.getOrDefault(s, 0) + 1);
        }
        String ans = "Yes";
        for (String str : noteMap.keySet()) {
            if (!magazineMap.keySet().contains(str) || magazineMap.get(str) < noteMap.get(str)) {
                ans = "No";
            }
        }
        System.out.println(ans);
    }

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : ar) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        map.forEach((k, v) -> System.out.println("k:" + k + " v:" + v));
        int ans = 0;
        for (Integer i : map.keySet()) {
            ans += map.get(i) / 2;
        }
        return ans;
    }

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */
    public static int pageCount(int n, int p) {
        // Write your code here
        int start = 0;
        int end = 0;

        int startPage = 1;
        while (startPage < p) {
            startPage += 2;
            start++;
        }

        startPage = p;
        if (startPage % 2 == 0) {
            startPage++;
        }
        while (startPage < n) {
            startPage += 2;
            end++;
        }
        return Math.min(start, end);
    }





}
