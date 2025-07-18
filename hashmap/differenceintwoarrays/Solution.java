package hashmap.differenceintwoarrays;
import java.util.*;

/**
 * Kind of like brute-forced,easy to understand what they want but solution goes a round about way doing this and that
 */
public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(int n:nums1){
            set1.add(n);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for(int n:nums2){
            set2.add(n);
        }


        for(int n:nums2){
            set1.remove(n);
        }

        for(int n:nums1){
            set2.remove(n);
        }

        List<List<Integer>> loi = new ArrayList<>();
        loi.add(new ArrayList<>(set1));
        loi.add(new ArrayList<>(set2));
        return loi;

    }
}
