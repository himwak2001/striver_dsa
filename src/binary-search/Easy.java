public class Easy {
    /*
     * method to find square root of an integer
     * TC - O(logn)
     * SC - O(1)
     */
    private int floorSqrt(int n) {
        int low = 1, high = n, ans = 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if((mid * mid) <= n){
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }

    /*
     * main method to get the output
     */
    public static void main(String[] args) {
        Easy easy = new Easy();
        System.out.println(easy.floorSqrt(11));
    }
}