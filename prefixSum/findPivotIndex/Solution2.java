package prefixSum.findPivotIndex;

/**
 * total = leftSum + nums[i] + rightSum
 *
 * so, leftSum = total- rightSum- nums[i]
 * For our condition leftSum and RightSum should be equal
 *
 * thus, leftSum = total - leftSum - nums[i]
 * We can calculate the leftSum and keep checking the condition, since left and right will be equal the condition
 * will become true
 */
public class Solution2 {

    public int pivotIndex(int[] nums){
        int totalSum = 0, leftSum = 0;
        for(int n:nums){
            totalSum += n;
        }

        for(int i=0;i<nums.length;i++){
            if(leftSum == totalSum - leftSum - nums[i]){
                return i;
            }
        }
        return -1;

    }

}
