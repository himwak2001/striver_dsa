import src.arrays.Solution;
import src.patterns.Patterns;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0};
//        int[] arr2 = {1, 2, 3, 6, 7};
//        ArrayList<Integer> result = solution.findIntersection(arr1, arr2);
        solution.sortArray(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
}