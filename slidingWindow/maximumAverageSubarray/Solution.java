package slidingWindow.maximumAverageSubarray;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        int l = 0, r = 0;
        while(r < k){
            maxSum += nums[r++];
        }
        int sum = maxSum;
        while(r < nums.length){
            sum += nums[r++];
            sum -= nums[l++];
            maxSum = Math.max(sum,maxSum);
        }
        return (double)maxSum/k;
    }

    /**
     * Something new I learn today when you are sliding a window just by a single character there is no necessary need
     * to maintain the window using the 2 pointers, you can do it in a single for loop. As shown in the below
     * function, the above was good when it come to readability but the below version isn't rocker science. Since we
     * are shifting by one we add it to result so we can remove the very first element from the window that is i-k
     */

    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0 , max = Integer.MIN_VALUE;
        //Need to do this we can't use a single for loop here because we have negative numbers and we can
        // accidentally inflate our results
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        max = sum;
        for(int i=k;i<nums.length;i++){
            sum += nums[i];
            if(i >= k){
                sum -= nums[i-k];
            }
            max = Math.max(sum,max);
        }
        return (double)max/k;
    }


    /**
     * Realised the condition if(i >=k) will always be true
     */

    public double findMaxAverage3(int[] nums, int k) {
        int sum = 0 , max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        max = sum;
        for(int i=k;i<nums.length;i++){
            sum += nums[i];
            sum -= nums[i-k];
            max = Math.max(sum,max);
        }
        return (double)max/k;
    }
}
