package twoPointer.maxKpairs;

import java.util.Arrays;
import java.util.HashMap;

public class MaxNumOfKPairs {

    public static void main(String[] args) {
        int[] nums = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        maxOperations(nums,3);

    }

    public static int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        for(int i=0;i<nums.length;i++){
            int current = nums[i];
            int complement = k - nums[i];

            if(map.get(current) > 0 && map.get(complement) > 0){
                if(map.get(current) == map.get(complement) && map.get(current) < 2)
                    continue;
                map.put(current,map.get(current) - 1);
                map.put(complement,map.get(complement) - 1);
            }
        }

        return count;

    }

    public static int maxOperations2(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int left=0 , right=nums.length-1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == k){
                count++;
                left++;
                right--;
            }
            else if(sum < k){
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}
