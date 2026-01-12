public class Easy {
    /**
     * method to find lower bound / search insert position
     * TC - O(logn)
     * SC - O(1)
     */
    public int lowerBound(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    /**
     * method to find upper bound
     * TC - O(logn)
     * SC - O(1)
     */
    public int upperBound(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    /**
     * method to find floor in a sorted array
     * TC - O(logn)
     * SC - O(1)
     */
    public int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return high;
    }

    /*
     * method to find square root of an integer
     * TC - O(logn)
     * SC - O(1)
     */
    public int floorSqrt(int n) {
        int low = 1, high = n, ans = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid * mid) <= n) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    /*
     * main method to get the output
     */
    public static void main(String[] args) {
        Easy easy = new Easy();
        int[] arr = { 1, 2, 8, 10, 10, 12, 19 };
        // System.out.println(easy.lowerBound(arr, 100));
        System.out.println(easy.findFloor(arr, 11));
    }
}