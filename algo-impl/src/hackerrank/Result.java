package hackerrank;

import java.util.*;

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
     * circular array
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
    }

}