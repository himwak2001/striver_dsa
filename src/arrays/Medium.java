package src.arrays;

import java.util.*;

public class Medium {
    /**
     * method to find next permutation
     * TC - O(n)
     * SC - O(1)
     */
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        reverse(nums, pivot + 1, n - 1);
    }

    /**
     * method to find the sum of the triplets should be 0 i.e., Three Sum
     * TC - O(n^2)
     * SC - O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i + 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                long sum = nums[i] + nums[j] + nums[k];
                List<Integer> temp = new ArrayList<>();
                if (sum == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (j < k && nums[k] == nums[k - 1])
                        k--;
                } else if (sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return ans;
    }

    /**
     * method to sort arrays of 0s, 1s and 2s (Dutch National Flag algorithm)
     * TC - O(n)
     * SC - O(1)
     */
    public void sort012(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }

    /**
     * find maximum subarray sum
     * TC - O()
     * SC - O()
     */
    public int maxSubArray(int[] nums) {
        int sum = 0, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxi) {
                maxi = sum;
            }

            if (sum < 0)
                sum = 0;
        }
        return maxi;
    }

    /**
     * method to re-arrange array elements by sign
     * TC - O(n)
     * SC - O(n)
     */
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return ans;
    }

    /**
     * method to find longest consecutive sequence
     * TC - O(n)
     * SC - O(n)
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> temp = new HashSet<>();
        for (int num : nums) {
            temp.add(num);
        }

        int maxLen = 0;

        for (int num : temp) {
            int currentNum = num;
            if (temp.contains(currentNum - 1)) {
                continue;
            }

            int len = 1;
            while (temp.contains(currentNum + 1)) {
                len += 1;
                currentNum = currentNum + 1;
            }

            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }

    /**
     * method to find sub-array sum equals k
     * TC - O(n)
     * SC - O(n)
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int cnt = 0, sum = 0;
        prefixSum.put(0, 1);
        for (int num : nums) {
            sum += num;
            int x = sum - k;

            if (prefixSum.containsKey(x)) {
                cnt += prefixSum.get(x);
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }

    /**
     * Finds all elements in the array that appear more than n/3 times.
     * Uses the Boyer-Moore majority voting algorithm to identify potential
     * candidates
     * and then validate their frequencies in a second pass.
     *
     * @param nums the input integer array
     * @return a list of elements that appear more than âŒŠ n/3 âŒ‹ times
     */
    public List<Integer> majorityElement(int[] nums) {
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE, cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (cnt1 == 0 && el2 != num) {
                el1 = num;
                cnt1 += 1;
            } else if (cnt2 == 0 && el1 != num) {
                el2 = num;
                cnt2 += 1;
            } else if (num == el1) {
                cnt1 += 1;
            } else if (num == el2) {
                cnt2 += 1;
            } else {
                cnt1 -= 1;
                cnt2 -= 1;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == el1)
                cnt1 += 1;
            else if (num == el2)
                cnt2 += 1;
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        if (cnt1 > threshold)
            result.add(el1);
        if (cnt2 > threshold)
            result.add(el2);

        return result;
    }

    /**
     * Finds the count of subarrays with XOR equal to k.
     * 
     * This method uses a prefix XOR approach with a HashMap to efficiently count
     * all subarrays whose XOR result equals the target value k.
     * 
     * Algorithm:
     * - Maintains a running XOR (xr) of elements from the start to current index
     * - For each position, checks if (xr ^ k) exists in the map
     * - If it exists, it means there are subarrays ending at current index with XOR
     * = k
     * - Stores frequency of each XOR value encountered so far
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the HashMap in worst case
     * 
     * @param arr the input array of integers
     * @param k   the target XOR value to find
     * @return the count of subarrays with XOR equal to k
     */
    public long subarrayXor(int arr[], int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int cnt = 0;
        int n = arr.length, xr = 0;
        for (int i = 0; i < n; i++) {
            xr = xr ^ arr[i];
            int remain = xr ^ k;
            if (mpp.containsKey(remain)) {
                int count = mpp.get(remain);
                cnt += count;
            }

            mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
        }
        return cnt;
    }

    /**
     * Merges overlapping intervals from the given array of intervals.
     * 
     * @param arr a 2D array where each row represents an interval [start, end]
     * @return an ArrayList of merged intervals, where overlapping intervals are combined
     *         into a single interval with the minimum start and maximum end values
     * 
     * @example
     *    Input: {{1,3},{2,6},{8,10},{15,18}}
     *    Output: {{1,6},{8,10},{15,18}}
     * 
     * @note The method sorts the input array by start values before merging,
     *       so the output intervals are in sorted order by their start position.
     *       Time Complexity: O(n log n) due to sorting
     *       Space Complexity: O(n) for the result list
     */
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int n = arr.length;
        for (int[] num : arr) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < num[0]) {
                ans.add(new int[] { num[0], num[1] });
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(num[1], ans.get(ans.size() - 1)[1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Medium medium = new Medium();
        // int[] nums = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int[][] arr = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };
        // System.out.println(medium.maxSubArray(nums));
        // medium.nextPermutation(nums);
        // medium.sort012(nums);
        // for (int num : medium.rearrangeArray(nums)) {
        // System.out.print(num + " ");
        // }
        // System.out.println(medium.longestConsecutive(nums));
        // System.out.println(medium.subarraySum(nums, 3));
        // List<List<Integer>> output = medium.threeSum(arr);
        // for (List<Integer> triplet : output) {
        // System.out.println(triplet);
        // }
        ArrayList<int[]> list = medium.mergeOverlap(arr);

        for (int[] num : list) {
            System.out.println(Arrays.toString(num));
        }
    }
}