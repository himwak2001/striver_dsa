package src.arrays;

import java.util.*;

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

    /**
     * method to get maximum sub-array sum - Kadane's Algorithm
     */
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxi) maxi = sum;
            if (sum < 0) sum = 0;
        }
        if (maxi < 0) maxi = 0;
        return maxi;
    }

    /**
     * rearrange array elements by sign (pos == neg)
     */
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[negIndex] = nums[i];
                negIndex += 2;
            } else {
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    /**
     * rearrange array elements by sign (pos != neg)
     */
    public void posAndNeg(int[] arr) {
        // Write your code here
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i : arr) {
            if (i < 0) neg.add(i);
            else pos.add(i);
        }

        int i = 0;
        int p = 0;
        int n = 0;
        while (p < pos.size() && n < neg.size()) {
            arr[i++] = pos.get(p++);
            arr[i++] = neg.get(n++);
        }

        while (p < pos.size()) {
            arr[i++] = pos.get(p++);
        }

        while (n < neg.size()) {
            arr[i++] = neg.get(n++);
        }
    }

    /**
     * next permutation
     */
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        // step 1 -- find breakpoint
        // TC --> O(n)
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // step 2 --> swap with slight greater
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // step 3 --> reverse the array
        reverse(nums, index + 1, n - 1);
    }

    /**
     * leaders in an array
     */
    public ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= maxi) {
                ans.add(arr[i]);
                maxi = Math.max(arr[i], maxi);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    /**
     * Longest Consecutive Sequence
     */
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int x = i;
                int cnt = 1;
                while (set.contains(x + 1)) {
                    x += 1;
                    cnt += 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    /**
     * Set Matrix Zeroes
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;

        // track the zeroes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        // mark the zeroes
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // handling edge rows and columns
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * method to find majority if element - II
     * TC - O(2n)
     * SC - O(1)
     */
    public List<Integer> majorityElement(int[] nums) {
        // Counters for the two potential majority elements (> n/3)
        int cnt1 = 0, cnt2 = 0;

        // Store the two candidate values (initialized to MIN_VALUE)
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        // First pass: find potential candidates using Boyer–Moore voting logic
        for (int num : nums) {

            // If first slot is empty and current number is not equal to second candidate
            if (cnt1 == 0 && el2 != num) {
                cnt1 = 1;        // set count
                el1 = num;       // assign candidate
            }

            // Else if second slot is empty and current number is not equal to first candidate
            else if (cnt2 == 0 && el1 != num) {
                cnt2 = 1;        // set count
                el2 = num;       // assign candidate
            }

            // If current number matches first candidate
            else if (el1 == num) {
                cnt1++;          // increment first count
            }

            // If current number matches second candidate
            else if (el2 == num) {
                cnt2++;          // increment second count
            }

            // If number matches neither candidate
            else {
                cnt1--;          // reduce both counts
                cnt2--;
            }
        }

        // Second pass: count actual occurrences of the two candidates
        List<Integer> ans = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;

        for (int num : nums) {
            if (num == el1) cnt1++;   // count occurrences of candidate 1
            if (num == el2) cnt2++;   // count occurrences of candidate 2
        }

        // Minimum frequency to qualify as majority (> n/3)
        int mini = (nums.length / 3) + 1;

        // Add valid candidates to result
        if (cnt1 >= mini) ans.add(el1);
        if (cnt2 >= mini) ans.add(el2);

        // Return list of majority elements (size 0, 1, or 2)
        return ans;
    }

    /**
     * method to find 3 sum that equals to zero
     * TC - O(n^2)
     * SC - O(no. of triplets)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        // Step 1: Sort the array to use two-pointer technique and skip duplicates
        Arrays.sort(nums);

        // Result list to store all unique triplets
        List<List<Integer>> ans = new ArrayList<>();

        // Step 2: Iterate through the array, treating nums[i] as the first element of the triplet
        for (int i = 0; i < n; i++) {

            // Skip duplicate values for i (to avoid duplicate triplets)
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Two pointers for the remaining two elements
            int j = i + 1;      // left pointer
            int k = n - 1;      // right pointer

            // Step 3: Move j and k to find pairs where nums[i] + nums[j] + nums[k] = 0
            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k]; // current triplet sum

                if (sum < 0) {
                    // Sum is too small → increase j to get a larger sum
                    j++;
                }
                else if (sum > 0) {
                    // Sum is too large → decrease k to get a smaller sum
                    k--;
                }
                else {
                    // Found a valid triplet that sums to zero
                    List<Integer> temp = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                    ans.add(temp);

                    // Move both pointers after adding the triplet
                    j++;
                    k--;

                    // Skip duplicate values for j
                    while (j < k && nums[j] == nums[j - 1]) j++;

                    // Skip duplicate values for k
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        // Return all unique triplets
        return ans;
    }

}