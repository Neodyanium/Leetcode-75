package slidingWindow.maxConsecutiveOnes3;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums,3));
        System.out.println(longestOnes2(nums,3));
        System.out.println(longestOnes3(nums,3));

    }

    public static int longestOnes(int[] nums, int k) {
        int l = 0 , r = 0, maxAllowed = k, count = 0,max = 0;
        while(r < nums.length){
            if(nums[r] == 1){
                r++;
                count++;
            }else if(maxAllowed > 0){
                r++;
                count++;
                maxAllowed--;
            }else{
                max = Math.max(count,max);
                if(nums[l] == 0){
                    maxAllowed++;
                }
                count--;
                l++;
            }
        }
        return Math.max(max,count);
    }

    /**
     * Easier and uses less variables
     */
    public static int longestOnes2(int[] nums, int k) {
        int zeroes = 0, left = 0, maxlen = 0;
        for(int right = 0;right < nums.length;right++){
            //Keeping a count of Zeroes
            if(nums[right] == 0)
                zeroes++;
            //If at any point the number of allowed Zeroes surpasses k, we shrink our window all the while tracking max
            while(zeroes > k){
                if(nums[left] == 0) zeroes--;
                left++;
            }

            maxlen = Math.max(right-left + 1,maxlen);
        }
        return maxlen;
    }

    /**
     * Litecode optimal solution, Its really optimal
     *
     * Here we have written esentially same code as above if we used if instead of the while loop our code would be
     * similar, here we have used a for loop and what we are doing is reducing k anytime we encounter a 0, thus we
     * can use the max allowed zeroes, once the limit is reached the if checks and shrinks the window also adding or
     * removing  into k depending whats on the left.
     *
     * Here the window won't shrink below the maximum size, it might increase but won't decrease
     *
     */
    public static int longestOnes3(int[] nums, int k) {
        int left = 0,right;
        for(right = 0; right < nums.length;right++){
            if(nums[right] == 0)
                k--;

            if(k < 0)
                k += 1 - nums[left++];
        }
        return right - left;
    }


}
