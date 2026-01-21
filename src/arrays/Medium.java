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
     * method to find the longest subarray sum containing both positive and negative elements
     * TC - O(n)
     * SC - O(n)
     */
    public int longestSubarray(int[] arr, int k) {
        // code here
        int sum = 0, cnt = 0;
        int n = arr.length;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int x = sum - k;

            // check whether x present in map
            if (prefixSum.containsKey(x)) {
                int len = i - prefixSum.get(x);
                cnt = Math.max(cnt, len);
            }

            // store sum in a map if not present
            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }
        return cnt;
    }


    /**
     * method to find the longest subarray sum containing only positive elements
     * TC - O(n)
     * SC - O(1)
     */
    public int longestSubarrayWithSumK(int[] arr, long k) {
        int sum = 0, i = 0, maxLen = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            while (i <= j && sum > k) {
                sum -= arr[i];
                i++;
            }

            if (sum == k) {
                maxLen = Math.max(j - i + 1, maxLen);
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Medium medium = new Medium();
        int[] arr = { -3, -2, -1, 0, 1, 2, 2 };
        // medium.nextPermutation(nums);
        // for (int num : nums) {
        // System.out.print(num + " ");
        // }
        List<List<Integer>> output = medium.threeSum(arr);
        for (List<Integer> triplet : output) {
            System.out.println(triplet);
        }
    }
}