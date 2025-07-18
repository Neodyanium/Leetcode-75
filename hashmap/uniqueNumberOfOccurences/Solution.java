package hashmap.uniqueNumberOfOccurences;

import java.util.*;


class Solution {

    /**
     * Here we have to check if all the element frequencies are unique or different.
     *
     * Approach is simple we use hashtable to maintain frequencies and extract those frequency values, then sort it.
     * If there are any repeated values then we know its not unique frequencies and return false, else return true
     */
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:arr){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        for(int i=1;i<values.size();i++){
            if(values.get(i).equals(values.get(i-1))){
                return false;
            }
        }
        return true;
    }

    /**
     * This approach uses an extra set this one is intuitive, we have all the frequencies of the numbers and if any
     * of them have same frequency then it can't be added to set more than once, if we compare the size of both set
     * and map we will come to know if set and map are equal size they have unique frequencies else set will be
     * smaller and we can return false
     */
    public static boolean uniqueOccurrences2(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:arr){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
}