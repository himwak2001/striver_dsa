package src.arrays;

import java.util.ArrayList;

import static java.util.Collections.swap;

public class Solution {
    /**
     * method to find largest element in an array
     */
    public int largest(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * method to find the second largest element in an array
     */
    public int secondLargest(int[] arr, int n) {
        int largest = arr[0];
        int sLargest = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] > sLargest && arr[i] < largest) {
                sLargest = arr[i];
            }
        }
        return sLargest;
    }

    /**
     * method to check if an array is sorted or not
     */
    public boolean checkSorted(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * method to remove duplicates in-place from sorted array
     */
    public int removeDuplicates(int[] arr, int n) {
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }

    /**
     * method to left rotate the array by one place
     */
    public void rotateArrayByOnePlace(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }

    /**
     * method to left rotate the array by d places
     */
    private void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateArray(int[] arr, int d) {
        d = d % arr.length;
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    /**
     * method to move all zeros to the end of an array
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void pushZerosToEnd(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) return;
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }

    /**
     * method to get union for two sorted array
     */
    public ArrayList<Integer> findUnion(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (result.isEmpty() || result.getLast() != a[i]) {
                    result.add(a[i]);
                }
                i++;
            } else {
                if (result.isEmpty() || result.getLast() != b[j]) {
                    result.add(b[j]);
                }
                j++;
            }
        }
        while (i < n1) {
            if (result.isEmpty() || result.getLast() != a[i]) {
                result.add(a[i]);
            }
            i++;
        }

        while (j < n2) {
            if (result.isEmpty() || result.getLast() != b[j]) {
                result.add(b[j]);
            }
            j++;
        }

        return result;
    }

    /**
     * method to get intersection of two sorted array - with duplicates elements
     */
    public ArrayList<Integer> findIntersection(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                result.add(a[i]);
                i++;
                j++;
            }
        }
        return result;
    }
}
