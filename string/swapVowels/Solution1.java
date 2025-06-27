package string.swapVowels;
import java.util.Arrays;
import java.util.HashSet;

/**
 * In Java Strings are immutable object, so we need to handle this differently, we will create a charArray from that
 * string and perform our swap operations over it,
 *
 * We created a Hashset and stored all the lower and uppercase vowels in them, so we can check at anytime which
 * element is a vowel so we could swap them,
 * We also made 2 pointers, i will keep track of the pointers from the front and the j will start from the back and
 * keep track of the vowel from the back.
 *
 * We i < j is the iterating condition as we would like to swap values from the start to end, if at any point they
 * become equal or cross there are no more values to swap, so we have kept checking the same condition multiple times
 *
 * i has to track the leftmost vowel, so if it is not a vowel move forward, keep going till you find it,
 * j has to track the rightmost vowel, so if it is not a vowel move backward, keep going till you find it,
 *
 * now we have both the vowels just swap them and (imp) increment the pointers or infinite loop is created
 *
 * TimeComplexity: O(n) , multiple while loops are used but they go over the array just once
 *
 * SpaceComplexity: O(set), we have used the extra Hashset with takes memory
 *
 */
public class Solution1 {

    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] carr = s.toCharArray();
        int i=0, j=carr.length-1;
        while(i < j){

            while(i < j && !set.contains(carr[i])){
                i++;
            }

            while(i < j && !set.contains(carr[j]) ){
                j--;
            }

            if(i < j){
                char temp = carr[i];
                carr[i] = carr[j];
                carr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(carr);
    }
}
