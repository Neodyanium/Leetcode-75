package prefixSum.highestAltitudeGain;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {-5,1,5,0,-7}; // here array defines elevation gained.Initially it was -5, the 1 gained so its -4
        //[-5,-4,1,1,-6] thus the answer is 1.
        int[] nums2 = {-4,-3,-2,-1,4,3,2}; // here the answer is Zero
    }

    public int largestAltitude(int[] gain) {
        int pref = 0, max = 0;
        for(int n: gain){
            pref += n;
            max = Math.max(max,pref);
        }
        return max;
    }
}