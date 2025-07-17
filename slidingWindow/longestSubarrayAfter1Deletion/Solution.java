package slidingWindow.longestSubarrayAfter1Deletion;

public class Solution {

    /**
     * The last question, maxConsecutiveOnes3 can be applied here, it was simple we only need the maxConsecutive ones
     * if we delete an element doesn't matter if it is 0 or 1, this can be related with longest subaaray with 1 flip
     * allowed, so we implemented the same logic. We just subtract 1 from the answer as the deletion performed
     */
    public int longestSubarray(int[] nums) {
        return longestOnes3(nums,1);
    }

    public static int longestOnes3(int[] nums, int k) {
        int left = 0,right;
        for(right = 0; right < nums.length;right++){
            if(nums[right] == 0)
                k--;

            if(k < 0)
                k += 1 - nums[left++];
        }
        return right - left -1;
    }
}
