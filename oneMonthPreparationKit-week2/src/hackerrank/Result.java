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

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */
    public static int towerBreakers(int n, int m) {
        // Write your code here
        if (m == 1) {
            return 2;
        } else if (n % 2 == 1) {
            return 1;
        } else {
            return 2;
        }

    }


    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    public static String caesarCipher(String s, int k) {
        // Write your code here
        k = k % 26;

        List<String> originList = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
        originList.addAll(originList.subList(0, k));
        List<String> rotatedList = originList.subList(k, originList.size());
        System.out.println(rotatedList);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < rotatedList.size(); i++) {
            map.put(originList.get(i), rotatedList.get(i));
        }
        map.forEach((key, value) -> System.out.println("key: " + key + " value: " + value));

        String ans = "";
        String c;
        for (int i = 0; i < s.length(); i++) {
            c = String.valueOf(s.charAt(i));
            if (Character.isUpperCase(s.charAt(i))) {
                ans += map.getOrDefault(c.toLowerCase(), c).toUpperCase();
            } else {
                ans += map.getOrDefault(c, c);
            }
        }
        return ans;

//        List<String> list = Arrays.asList(s.split(""));
//        for (int i = 0; i < list.size(); i++) {
//            if (Character.isUpperCase(list.get(i).charAt(0))) {
//                list.set(i, map.getOrDefault(list.get(i).toLowerCase(), list.get(i)).toUpperCase());
//            } else {
//                list.set(i, map.getOrDefault(list.get(i), list.get(i)));
//            }
//        }
//        return String.join("", list);
    }

    /*
     * Complete the 'maxMin' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */
    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
        List<Integer> sortedArr = arr.stream().sorted().collect(Collectors.toList());

        int min = sortedArr.get(k - 1) - sortedArr.get(0);
        for (int i = 0; i < sortedArr.size() - k + 1; i++) {
            if (sortedArr.get(i + k - 1) - sortedArr.get(i) < min) {
                min = sortedArr.get(i + k - 1) - sortedArr.get(i);
            }
        }
        return min;
    }


}
