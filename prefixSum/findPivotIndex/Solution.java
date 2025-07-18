package prefixSum.findPivotIndex;

/**
 * Here we need to see the index where the left and right prefix sum are equal
 * for array: {1,7,3,6,5,6}
 *
 *  1  8 11 17 22 28
 * 28 27 20 17 11 6
 *
 * We had done the same, we use a for loop and calculate both prefix sum from front and back.
 * Just need to keep in check the boundary conditions initial and last index.
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int pre = 0, suf = 0;
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            left[i] = pre;

            suf += nums[n - i - 1];
            right[n - i - 1] = suf;
        }

        for (int i = 0; i < nums.length; i++) {
            int le = 0;
            if (i - 1 >= 0)
                le = left[i - 1];
            int re = 0;
            if (i + 1 < nums.length) {
                re = right[i + 1];
            }
            if (le == re)
                return i;

        }

        return -1;

    }
}
