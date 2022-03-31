package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        for (Integer grade : grades) {
            int multiple = grade / 5 + 1;
            int score = 5 * multiple;
            if (score >= 40 && score - grade < 3) {
                list.add(score);
            } else {
                list.add(grade);
            }
        }
        return list;
    }


    /**
     * rover control
     *
     * @param matrixSize
     * @param cmds
     * @return
     */
    public static int roverMove(int matrixSize, List<String> cmds) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < cmds.size(); i++) {
            if (cmds.get(i).equals("DOWN")) {
                if (x < matrixSize - 1) {
                    x++;
                }
            } else if (cmds.get(i).equals("UP")) {
                if (x > 0) {
                    x--;
                }
            } else if (cmds.get(i).equals("RIGHT")) {
                if (y < matrixSize - 1) {
                    y++;
                }
            } else if (cmds.get(i).equals("LEFT")) {
                if (y > 0) {
                    y--;
                }
            }
            System.out.println("x" + x + "y" + y);
        }
        return x * matrixSize + y;
    }

    /**
     * chairs requirement
     * @param simulations
     * @return
     */
    public static List<Integer> minChairs(List<String> simulations){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < simulations.size(); i++) {
            int total = 0;
            int available = 0;
            String string = simulations.get(i);
            for (int j = 0; j < string.length(); j++) {
                char c = string.charAt(j);
                if (c == 'C') {
                    if (available > 0) {
                        available--;
                    } else {
                        total++;
                    }
                } else if (c == 'R') {
                    available++;
                } else if (c == 'U') {
                    if (available > 0) {
                        available--;
                    } else {
                        total++;
                    }
                } else if (c == 'L') {
                    available++;
                }
            }
            list.add(total);
        }
        return list;
    }

    /**
     * circular array
     *
     * @param n
     * @param endNode
     * @return
     */
    public static int circularArray(int n, List<Integer> endNode) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < endNode.size() - 1; i++) {
            map.put(endNode.get(i), map.getOrDefault(endNode.get(i), 0) + 1);
            map.put(endNode.get(i + 1), map.getOrDefault(endNode.get(i + 1), 0) + 1);
        }
        map.forEach((k, v) -> System.out.println("k: " + k + " v:" + v));

        int value = map.get(endNode.get(0));
        int ans = endNode.get(0);
        for (Integer key : map.keySet()) {
            if (map.get(key) > value) {
                value = map.get(key);
                ans = key;
            }
        }
        return ans;

//        Optional<Map.Entry<Integer, Integer>> max = map.entrySet().stream().max(Map.Entry.comparingByValue());
//        return max.get().getKey();
    }


    /*
     * Complete the 'hurdleRace' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY height
     */
    public static int hurdleRace(int k, List<Integer> height) {
        // Write your code here
        List<Integer> list = height.stream().sorted().collect(Collectors.toList());
        if (list.get(list.size() - 1) < k) {
            return 0;
        } else {
            return list.get(list.size() - 1) - k;
        }
    }


    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int aMax = a.get(a.size() - 1);
        int bMin = b.get(0);
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        for (int i = aMax; i <= bMin; i++) {
            for (int j = 0; j < a.size(); j++) {
                if (i % a.get(j) == 0) {
                    aSet.add(i);
                }
            }
            for (int k = 0; k < b.size(); k++) {
                if (b.get(k) % i == 0) {
                    bSet.add(i);
                }
            }
        }

        for (Integer integer : a) {
            aSet.removeIf(element -> element % integer != 0);
        }
        for (Integer integer : b) {
            bSet.removeIf(element -> integer % element != 0);
        }
        System.out.println(aSet);
        System.out.println(bSet);

        List<Integer> ans = new ArrayList<>();
        aSet.forEach(e -> {
            if (bSet.contains(e)) {
                ans.add(e);
            }
        });
        return ans.size();
    }


    /**
     * CyberLink: star rating
     * @param str
     * @return
     */
    public static String starRating(String str){

        float num = Float.parseFloat(str);
        int full = 0;
        int half = 0;
        int empty = 0;

        while (num >= 1) {
            num -= 1;
            full++;
        }

        if (num > 0) {
            half++;
        }

        empty = 5 - full - half;

        String ans = "full ".repeat(full) + "half ".repeat(half) + "empty ".repeat(empty);

        return ans;
    }


    /**
     * CyberLink: FizzBuzz
     * @param num
     * @return
     */
    public static String fizzBuzz(int num){
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.append("FizzBuzz");
            } else if (i % 5 == 0) {
                ans.append("Buzz");
            } else if (i % 3 == 0) {
                ans.append("Fizz");
            } else {
                ans.append(String.valueOf(i));
            }
            ans.append(" ");
        }

        return ans.toString();
    }

}
