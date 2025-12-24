package array.ProductOfArrayExceptSelf;

/**
 * Computes an array where each element at index i is the product of all elements
 * in the input array except nums[i], without using division.
 *
 * Optimized Approach (O(1) extra space, excluding output array):
 * - First pass (left to right): For each index i, store the product of all elements to the left of i in output[i].
 *   - output[0] = 1 (no elements to the left)
 *   - For each i > 0: output[i] = nums[0] * nums[1] * ... * nums[i-1]
 *
 * - Second pass (right to left): For each index i, multiply output[i] by the product of all elements to the right of i.
 *   - Maintain a running product `prod` from the right
 *   - For each i: output[i] *= nums[i+1] * nums[i+2] * ... * nums[n-1]
 *
 * This two-pass approach ensures that for each i, we correctly compute the product of all elements in the array except nums[i]
 * and store the result in output[i].
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) extra (uses only the output array)
 *
 * we are storing prefix product from front and back onto the same array to reduce space complexity
 *
 * eg:
 *  [1 2 3 4]
 *  output array initially store for each index the prefix product of all left elements:
 *  [1,1,2,6]
 *  now similarly we will start from back for last element to its right is nothing so consider it 1 and last index
 *  stays the same, now we multiply what on the right of current index and again multiply it with the current output
 *  value to get the final answer
 */

class SolutionN3 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int[] output = new int[n];
        output[0] = 1;
        for(int i=1;i<n;i++){
            prod *= nums[i-1];
            output[i] = prod;
        }
        prod = 1;
        for(int i = n-2; i >= 0; i--){
            prod *= nums[i+1];
            output[i] *= prod;
        }

        return output;
    }
}