import java.util.Arrays;

public class Medium{
    /*
     * method to find the peak element
     * TC - O(logn)
     * SC - O(1)
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n - 2]) return n-1;
        int low = 1, high = n-2;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] < nums[mid+1]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /*
     * method to minimum integer k such that Koko can eat all the bananas within h hours.
     * TC - O(logn) * O(n)
     * SC - O(1)
     */
    private int calculateTotalHours(int[] piles, int hour){
        int totalHours = 0;
        for(int pile : piles){
            totalHours += Math.ceil((double)pile / (double)hour);
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 0, ans = 0;
        int high = Arrays.stream(piles).max().getAsInt();
        while(low <= high){
            int mid = (low + high) / 2;
            if(calculateTotalHours(piles, mid) <= h){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return ans;
    }


    /*
     * main method to get the output
     */
    public static void main(String[] args) {
        Medium medium = new Medium();
        int[] nums = {30,11,23,4,20};
        System.out.println(medium.minEatingSpeed(nums, 6));
    }
}