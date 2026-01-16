import java.util.Arrays;

public class Medium {
    /*
     * method to find first and last position of Element in Sorted Array
     * TC - O(logn)
     * SC - O(1)
     */
    private int firstOccurence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    private int lastOccurence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurence(nums, target);
        if (first == -1)
            return new int[] { -1, -1 };
        int last = lastOccurence(nums, target);
        return new int[] { first, last };
    }

    /*
     * method to find the peak element
     * TC - O(logn)
     * SC - O(1)
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    /**
     * method to search target in rotated sorted array contain unique elements
     * TC - O(logn)
     * SC - O(1)
     */
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] < nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * method to check whether target is present in rotated sorted array containing
     * duplicate elements
     * TC - O(logn)
     * SC - O(1)
     */
    public boolean searchDuplicates(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // 1. Check target first (Fastest exit)
            if (nums[mid] == target)
                return true;

            // 2. Handle Ambiguity (The Duplicate Trap)
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    /*
     * method to minimum integer k such that Koko can eat all the bananas within h
     * hours.
     * TC - O(logn) * O(n)
     * SC - O(1)
     */
    private int calculateTotalHours(int[] piles, int hour) {
        int totalHours = 0;
        for (int pile : piles) {
            // Use ceiling division to find hours needed for this pile at 'hour' speed
            totalHours += Math.ceil((double) pile / (double) hour);
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 0, ans = 0;

        // High is the max pile size because eating faster than the largest pile doesn't
        // save more time
        int high = Arrays.stream(piles).max().getAsInt();
        while (low <= high) {
            int mid = (low + high) / 2;

            // If total hours at 'mid' speed fits within 'h', try a slower speed to find the
            // minimum
            if (calculateTotalHours(piles, mid) <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    /*
     * method to find minimum days to make M bouqets
     * TC - O[log(max-min+1)*n]
     * SC - O(1)
     */
    private boolean isPossible(int[] arr, int days, int m, int k) {
        int cnt = 0, noOfB = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // If flower blooms within 'days', it can be part of a contiguous bouquet
            if (arr[i] <= days) {
                cnt += 1;
            } else {
                // Sequence broken: calculate bouquets from previous contiguous blooms and reset
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k); // Handle the last segment of flowers
        if (noOfB >= m) {
            return true;
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        // Search range: from the earliest bloom day to the latest bloom day
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If m bouquets are possible by 'mid' day, try to find an earlier day
            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    /*
     * method to find smallest divisor given a threshold
     * TC - O[log(max)*n]
     * SC - O(1)
     */
    private int sumOfDivisor(int[] arr, int d) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double) arr[i] / (double) d); // Ceiling division: Any remainder increments the result by
                                                            // 1 for that element
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1; // Smallest possible divisor is 1
        int high = Arrays.stream(nums).max().getAsInt(); // Largest useful divisor is the max element; any larger
                                                         // divisor results in the same sum (1 per element)
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If the current sum is within the threshold, try a smaller divisor to minimize
            // the answer
            if (sumOfDivisor(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    /*
     * method to find smallest divisor given a threshold
     * TC - O[log(sum - max + 1)*n]
     * SC - O(1)
     */
    private int findDays(int[] weights, int capacity) {
        int days = 1, load = 0; // Start at Day 1 with an empty ship
        for (int i = 0; i < weights.length; i++) {

            // If adding this package exceeds capacity, move to the next day
            if (load + weights[i] > capacity) {
                days += 1;
                load = weights[i]; // Current package becomes the first load of the new day
            } else {
                load += weights[i]; // Add package to the current day's load
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        // Low: Must be at least the heaviest package to avoid getting stuck
        int low = Arrays.stream(weights).max().getAsInt();

        // High: Total weight of all packages (shipping everything in exactly 1 day)
        int high = Arrays.stream(weights).sum();
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If 'mid' capacity allows shipping within target days, try a smaller capacity
            if (findDays(weights, mid) <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    /*
     * method to find Kth Missing Positive Number in a Sorted Array
     * TC - O(logn)
     * SC - O(1)
     */
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // Number of missing integers before index 'mid' is: (actual value) - (expected
            // value if none were missing)
            int missing = arr[mid] - (mid + 1);

            // If the number of missing values is less than k, the kth missing must be
            // further to the right
            if (missing < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low + k;
    }

    /*
     * method to find aggressive cows
     * TC - O[nlogn + (log(max) * n)]
     * SC - O(1)
     */
    public boolean canWePlaceCows(int[] stalls, int minDist, int cows) {
        int cntCow = 1, last = stalls[0]; // Place the first cow in the first available stall
        for (int i = 1; i < stalls.length; i++) {

            // Only place the next cow if the distance from the last placed cow is at least
            // 'minDist'
            if (stalls[i] - last >= minDist) {
                cntCow += 1;
                last = stalls[i];
            }
        }

        // Return true if we managed to place all required cows
        if (cntCow >= cows)
            return true;
        return false;
    }

    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Sorting is mandatory to calculate distances between adjacent stalls correctly
        int n = stalls.length;

        // Range: Minimum possible distance is 1, Maximum is the distance between first
        // and last stall
        int low = 1, high = stalls[n - 1] - stalls[0];
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If it's possible to place cows with 'mid' distance, try to increase the
            // distance for a better result
            if (canWePlaceCows(stalls, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    /*
     * main method to get the output
     */
    public static void main(String[] args) {
        Medium medium = new Medium();
        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        // System.out.println(medium.search(nums, 3));
        // int[] output = medium.searchRange(nums, 6);
        // for (int num : output) {
        // System.out.println(num);
        // }
        System.out.println(medium.searchDuplicates(nums, 3));
    }
}