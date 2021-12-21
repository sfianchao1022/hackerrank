package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        // write your code here

        // TSMC: rover control
//        System.out.println(Result.roverMove(2, Arrays.asList("UP", "RIGHT", "DOWN", "DOWN")));
//        System.out.println(Result.roverMove(4, Arrays.asList("RIGHT", "UP", "DOWN", "LEFT", "DOWN", "DOWN")));

        // TSMC: chairs requirement
        System.out.println(Result.minChairs(Arrays.asList("CCCRRR", "CC", "CCRURC")));

        // TSMC: circular array
//        System.out.println(Result.circularArray(4, Arrays.asList(1, 5, 10, 5)));

        // 1. Grading Students
//        System.out.println(Result.gradingStudents(Arrays.asList(73, 67, 38, 33)));

        // 2. The Hurdle Race
//        List<Integer> arr = Arrays.asList(1, 2, 3, 3, 2);
//        System.out.println(Result.hurdleRace(1, arr));

        // 3. Between Two Sets
//        System.out.println(Result.getTotalX(Arrays.asList(2, 3, 6), Arrays.asList(42, 84)));


    }
}
