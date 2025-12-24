package array.ProductOfArrayExceptSelf;

//very similar to N1 approach
/**
 * Computes an array where each element at index i is the product of all elements
 * in the input array except nums[i], without using division.
 *
 * Approach:
 * - Compute prefix products from the left and store in `left[]`:
 *   left[i] = nums[0] * nums[1] * ... * nums[i]
 * - Compute suffix products from the right and store in `right[]`:
 *   right[i] = nums[i] * nums[i+1] * ... * nums[n-1]
 * - For each index i, the product of all elements except nums[i] is:
 *   output[i] = left[i-1] * right[i+1]
 *   (with boundaries handled by assuming left[-1] and right[n] as 1)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for left and right arrays
 */
class SolutionN2 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int prod = 1;
        for(int i=0;i<n;i++){
            prod *= nums[i];
            left[i] = prod;
        }
        prod = 1;
        for(int i = n-1; i >= 0; i--){
            prod *= nums[i];
            right[i] = prod;
        }
        int[] output = new int[n];
        for(int i=0;i<nums.length;i++){
            int lv = i == 0 ? 1 : left[i-1];
            int rv = i == nums.length-1? 1 : right[i+1];
            output[i] = lv * rv;
        }

        return output;
    }
}
