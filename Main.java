import src.arrays.Solution;
import src.patterns.Patterns;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {-1, 0, 1, 2, -1, -4};
//        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//        solution.setZeroes(matrix);
//        List<Integer> result = solution.majorityElement(arr1);
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < result.size(); i++) {
//            System.out.print(result.get(i) + " ");
//        }
        List<List<Integer>> result = solution.threeSum(arr1);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}