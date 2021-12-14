package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

class Result {

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
        System.out.println(map);
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




}
