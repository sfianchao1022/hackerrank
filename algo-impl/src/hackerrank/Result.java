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


}
