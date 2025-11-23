package src.arrays;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Collections.max;
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

    /**
     * method to find missing element in an array
     */
    public int missingElement(int[] arr, int N) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < N - 1; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ arr[i];
        }
        xor1 = xor1 ^ N;
        return xor1 ^ xor2;
    }

    /**
     * method to find maximum consecutive ones in an array
     */
    public int maximumConsecutive(int[] arr) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    /**
     * method to find the number that appears once and other twice
     */
    public int numberAppears(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }

    /**
     * method to find longest sub-array with sum k (positive + negative)
     */
    public int longestSubArrayPosNeg(int[] arr, int k) {
        HashMap<Long, Integer> prefixSum = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(i + 1, maxLen);
            }
            long more = sum - k;
            if (prefixSum.containsKey(more)) {
                int len = i - prefixSum.get(more);
                maxLen = Math.max(maxLen, len);
            }

            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }
        return maxLen;
    }

    /**
     * method to find longest sub-array with sum k (positive only)
     */
    public int longestSubArray(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int n = arr.length;
        long sum = arr[0];
        int maxLen = 0;
        while (right < n) {
            if (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
            if (right < n) sum += arr[right];
        }
        return maxLen;
    }

    /**
     * method to find two sum
     */
    public boolean twoSum(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum > k) right--;
            else if (sum < k) left++;
            else return true;
        }
        return false;
    }

    /**
     * method to sort an array of 0's, 1's and 2's
     */
    public void sortArray(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                mid++;
                low++;
            } else if (arr[mid] == 1) mid++;
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
}