package hashmap.determineIfTwoStringAreClose;

import java.util.*;



public class Solution {

    public static void main(String[] args) {
        String word1 = "cabbba", word2 = "abbccc";
        boolean isClose = closeStrings(word1,word2);
        boolean isClose2 = closeStrings2(word1,word2);
    }

    /**
     * 1) Check if the words are different lengths
     * 2) Check if all the character in word1 exists in word2, doesn't matters the time they are repeated
     * 3) Now,check if the frequencies of all words in word1 and word2 are the same
     *
     * (Tricky to think with operations mentioned in the problem)
     */
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(char c:word1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        for(char c:word2.toCharArray()){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }

        for(char c:map1.keySet()){
            if(!map2.keySet().contains(c))
                return false;
        }

        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());

        Collections.sort(list1);
        Collections.sort(list2);

        for(int i=0;i<list1.size();i++){
            if(!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }

    /**
     *  The approach is similar we just use hashing instead of maps, so more efficient
     */
    public static boolean closeStrings2(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char c:word1.toCharArray()){
            freq1[c-'a']++;
        }

        for(char c:word2.toCharArray()){
            freq2[c-'a']++;
        }
        /**
         * The tricky part here is comparing for the characters of both, if it has entirely different characters, for
         * example "abx" "baf" here x and f can't be swapped or exchanged. So for them the value at index i, is
         * non-zero and other is zero. we have checked the following part here.
         */
        for(int i=0;i<26;i++){
            if(freq1[i] == 0 && freq2[i] != 0 ||
                    freq2[i] == 0 && freq1[i] != 0 ){
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);


        for(int i=0;i<26;i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }

        return true;

    }
}
