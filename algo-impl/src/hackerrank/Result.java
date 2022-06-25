package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

class Result {

    /**
     * TSMC: Longest Even Length Word
     * @param sentence
     * @return
     */
    public static String longestEvenWord(String sentence) {
        String ans = "";
        int i = 0;
        while (i < sentence.length()) {
            String sub;
            if (!sentence.contains(" ")) {
                sub = sentence;
                sentence = "";
            } else {
                sub = sentence.substring(i ,sentence.indexOf(" "));
                sentence = sentence.substring(sentence.indexOf(" ") + 1);
            }

            if (sub.length() % 2 == 0 && sub.length() > ans.length()) {
                ans = sub;
            }
        }

        return ans;
    }

    /**
     * TSMC: Process Tree
     * @param processNumber
     * @return
     */
    public static int findParent(int processNumber) {
        int parent = 0, sum = 1;
        int i = 1;
        while (sum <= processNumber) {
            sum += i;
            parent++;
            i++;
        }
        return parent;
    }


    /**
     * TSMC: Stars and Bars
     * @param s
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static List<Integer> starsAndBars(String s, List<Integer> startIndex, List<Integer> endIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < startIndex.size(); i++) {
            int from = startIndex.get(i);
            int to = endIndex.get(i);
            String subStr = s.substring(from - 1, to);
            int bar = 0;
            for (int j = 0; j < subStr.length(); j++) {
                if (subStr.charAt(j) == '|') {
                    bar++;
                }
            }
            int start = subStr.indexOf('|');
            int end = subStr.lastIndexOf('|');
            if (start == 0 && end == 0) {
                ans.add(0);
            } else {
                int star = end - start - 1 - (bar - 2);
                ans.add(star);
            }
        }
        return ans;
    }


    /**
     * TSMC: Divided Matrix
     * @param arr
     * @return
     */
    public static List<Integer> divided(List<List<Integer>> arr) {
        int n = arr.size();
        Map<Integer, Integer> l1 = new HashMap<>();
        Map<Integer, Integer> l2 = new HashMap<>();
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    l1.put(i, j);
                } else if (i == arr.get(i).size() - 1 - j) {
                    l2.put(i ,j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n / 2 && j < l1.get(i) && j < l2.get(i)) {
                    p1 += arr.get(i).get(j);
                } else if (i < n / 2 && j > l1.get(i) && j < l2.get(i)) {
                    p2 += arr.get(i).get(j);
                } else if (j > n / 2 && j > l1.get(i) && j > l2.get(i)) {
                    p3 += arr.get(i).get(j);
                } else if (i > n / 2 && j < l1.get(i) && j > l2.get(i)) {
                    p4 += arr.get(i).get(j);
                }
            }
        }

        return List.of(p1, p2, p3, p4);
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


    /**
     * TSMC: Line Game
     * @param lines
     * @return
     */
    public static List<Integer> lineGame(List<List<Integer>> lines) {
        int border = Integer.MIN_VALUE;

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).size(); j++) {
                if (lines.get(i).get(j) > border) {
                    border = lines.get(i).get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>(2);
        for (int i = 0; i <= border; i++) {
            for (int j = 0; j <= border; j++) {
                int sum = 0;
                for (List<Integer> line : lines) {
                    int delta = 0;
                    int d1, d2;
                    if (line.get(0) == line.get(2)) {
                        // vertical line
                        if (j >= line.get(1) && j <= line.get(3)) {
                            delta = Math.abs(i - line.get(0));
                        } else {
                            d1 = Math.abs(i - line.get(0)) + Math.abs(j - line.get(1));
                            d2 = Math.abs(i - line.get(2)) + Math.abs(i - line.get(3));
                            delta = Math.min(d1, d2);
                        }
                    } else if (line.get(1) == line.get(3)) {
                        // horizontal line
                        if (i >= line.get(0) && i <= line.get(2)) {
                            delta = Math.abs(j - line.get(1));
                        } else {
                            d1 = Math.abs(i - line.get(0)) + Math.abs(j - line.get(1));
                            d2 = Math.abs(i - line.get(2)) + Math.abs(i - line.get(3));
                            delta = Math.min(d1, d2);
                        }
                    }
                    sum += delta;
                }

                if (sum < min) {
                    min = sum;
                    ans = List.of(i, j);
                } else if (sum == min && (i < ans.get(0) || j < ans.get(1))) {
                    ans = List.of(i, j);
                }
            }
        }

        return ans;
    }


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


    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer candle : candles) {
            map.put(candle, map.getOrDefault(candle, 0) + 1);
        }

        Optional<Integer> max = map.keySet().stream().max(Comparator.comparing(Integer::intValue));
        if (max.isPresent()) {
            return map.get(max.get());
        } else {
            return 0 ;
        }
    }


    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        int apple = 0;
        int orange = 0;
        for (Integer i : apples) {
            int location = a + i;
            if (location >= s && location <= t) {
                apple++;
            }
        }

        for (Integer i : oranges) {
            int location = b + i;
            if (location >= s && location <= t) {
                orange++;
            }
        }
        System.out.println(apple);
        System.out.println(orange);
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
                ans.append(i);
            }
            ans.append(" ");
        }

        return ans.toString();
    }

}
