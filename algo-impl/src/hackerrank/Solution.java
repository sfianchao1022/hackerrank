package hackerrank;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
	// write your code here

        // mock test: rover control
        System.out.println(Result.roverMove(2, Arrays.asList("UP", "RIGHT", "DOWN", "DOWN")));
        System.out.println(Result.roverMove(4, Arrays.asList("RIGHT", "UP", "DOWN", "LEFT", "DOWN", "DOWN")));

        // mock test: circular array
        System.out.println(Result.circularArray(4, Arrays.asList(1, 5, 10, 5)));

        // 1. Grading Students
//        System.out.println(Result.gradingStudents(Arrays.asList(73, 67, 38, 33)));

        // 2. 


    }
}
