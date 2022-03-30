package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

class Result {

    /**
     * TSMC: Authentication Tokens
     * @param expiryLimit
     * @param commands
     * @return
     */
    public static Integer numberOfTokens(int expiryLimit, List<List<Integer>> commands) {

        Map<Integer, Integer> commandZeroMap = new HashMap<>();
        Map<Integer, Integer> commandOneMap = new HashMap<>();

        int max = commands.get(0).get(2);
        for (List<Integer> temp : commands) {
            if (temp.get(2) > max) {
                max = temp.get(2);
            }

            if (temp.get(0) == 0) {
                commandZeroMap.put(temp.get(1), expiryLimit + temp.get(2));
            } else {
                commandOneMap.put(temp.get(1), temp.get(2));
            }
        }

        int ans = 0;
        for (Integer key : commandOneMap.keySet()) {
            if (commandZeroMap.containsKey(key)) {
                if (commandOneMap.get(key) <= commandZeroMap.get(key) && commandOneMap.get(key) + expiryLimit > max) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * TSMC: Odd One out
     * @param series
     * @return
     */
    public static String findOdd(List<String> series) {

        ArrayList<String> alphabets = new ArrayList<>(Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")));

        int rightOrder = 0;
        int leftOrder = 0;
        for (String string : series) {
            char last = string.charAt(string.length() - 1);
            char secondLast = string.charAt(string.length() - 2);

            if (alphabets.indexOf(String.valueOf(last)) == alphabets.indexOf(String.valueOf(secondLast)) + 1) {
                rightOrder++;
                if (leftOrder > 1 && rightOrder == 1) {
                    return string;
                }
            } else {
                leftOrder++;
                if (rightOrder > 1 && leftOrder == 1) {
                    return string;
                }
            }

        }

        return null;
    }

    /**
     * TSMC: Longest Work Slot
     * @param leaveTimes
     * @return
     */
    public static String findLongestSingleSlot(List<List<Integer>> leaveTimes) {

        List<String> alphabets = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(leaveTimes.get(0).get(0), leaveTimes.get(0).get(1));

        for (int i = 1; i < leaveTimes.size(); i++) {
            int previous = leaveTimes.get(i - 1).get(1);
            int present = leaveTimes.get(i).get(1);
            int presentId = leaveTimes.get(i).get(0);

            if (!map.containsKey(presentId)) {
                map.put(presentId, present - previous);
            } else {
                if (map.get(presentId) < present - previous) {
                    map.put(presentId, present - previous);
                }
            }
        }

//        Map.Entry<Integer, Integer> maxEntry = map.entrySet().stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).orElse(null);
//        Map.Entry<Integer, Integer> maxEntry = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).orElse(null);
//        if (maxEntry != null) {
//            return alphabets.get(maxEntry.getKey());
//        }
//        return null;

        Optional<Map.Entry<Integer, Integer>> maxEntry = map.entrySet().stream().max(Comparator.comparingInt(e -> e.getValue()));
        return maxEntry.map(e -> alphabets.get(e.getKey())).orElse(null);
    }

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

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static String balancedSums(List<Integer> arr) {
        // Write your code here

        String ans = "NO";
        int sum = arr.stream().mapToInt(value -> Integer.valueOf(value)).sum();
        int leftSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (leftSum == sum - arr.get(i)) {
                ans = "YES";
                break;
            }
            leftSum += arr.get(i);
            sum -= arr.get(i);
        }
        return ans;
    }

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */
    public static int superDigit(String n, int k){

        n = n.chars().mapToLong(Character::getNumericValue).sum() * k + "";

        return (n.length() > 1) ? superDigit(n, 1) : Character.getNumericValue(n.charAt(0));
    }
//    public static int superDigit(String n, int k) {
//        // Write your code here
//
//        String repeatedStr = n.repeat(k);
//        while (repeatedStr.length() > 1) {
//            int p = 0;
//            for (int i = 0; i < repeatedStr.length(); i++) {
////                Integer temp = Integer.parseInt(String.valueOf(repeatedStr.charAt(i)));
//                int temp = Character.getNumericValue(repeatedStr.charAt(i));
//                p += temp;
//            }
//            repeatedStr = String.valueOf(p);
//        }
//
//        return Integer.parseInt(repeatedStr);
//    }


}
