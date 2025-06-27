package array.ProductOfArrayExceptSelf;

/**
 * The question is clear what we want but have to achieve this without using the division operation.
 * I thought of prefix sum(product) here, but it won't work out that easily.
 *
 * When you look at the problem, what you want for an element is the product of all the elements except the current,
 * that is precisely the product of all the elements on it's left and the product of all the elements on it's right.
 *
 * So we maintain 2 arrays of same size as input arrays and propogate them properly with the prefix product from left
 * to right and right to left, the following function does make it clear how to achieve it, now that you have both
 * the product at left and at the right for an index you can get the value at that index
 *
 * SC: 3 *O(n)  TC = O(n)
 */
public class SolutionN {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProd = new int[n];
        int[] rightProd = new int[n];
        leftProd[0] = 1;
        rightProd[n-1] = 1;
        int prod = 1;
        for(int i=1;i<nums.length;i++){
            prod *= nums[i-1];
            leftProd[i] = prod;
        }
        prod=1;
        for(int i=n-2;i>=0;i--){
            prod *= nums[i+1];
            rightProd[i] = prod;
        }
        for(int i=0;i<n;i++){
            nums[i] = leftProd[i] * rightProd[i];
        }
        return nums;
    }
}
