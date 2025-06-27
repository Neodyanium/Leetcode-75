package array.IncreasingTripletSequence;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {6,7,1,2};
        boolean ans = increasingTriplet(arr);

    }
    public static boolean increasingTriplet(int[] nums) {
        int ss = Integer.MAX_VALUE, s = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < s){
                s = nums[i];
            }else if(nums[i] < ss){
                ss = nums[i];
            }
            else
                return true;
        }
        return false;
    }
}
