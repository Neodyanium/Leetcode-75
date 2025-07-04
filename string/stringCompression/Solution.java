package string.stringCompression;

import java.util.Arrays;



public class Solution {
    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int ans = compress(chars);
        System.out.println("Compressed Length:"+ans+" Compressed String:"+ Arrays.toString(chars));
    }

    /**
     *  We need to modify the same input array to the point of supressed length and return the length
     *  We have used stringbuilder , count variable
     *  ALgo:
     *  Append whatever the first character to the StringBuilder,
     *  Start iterating from index 1, and keep checking the previous if they are same increase the count
     *  if they are not if count is greater than 1 then append count and then add the current character
     *  when for loop ends, you have the last character in the sb but the count needs to be explicitly added if > 1
     *  return the length of stringbuilder that is the compression length, you can iterate over the sb and copy the
     *  elements to the original chars array
     */
    public static int compress(char[] chars) {
        char ch = chars[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(ch);
        for(int i=1;i<chars.length;i++){
            if(chars[i] == chars[i-1]){
                count++;
            }else {
                if (count > 1)
                    sb.append(count);
                sb.append(chars[i]);
                count = 1;
            }
        }
        if(count > 1){
            sb.append(count);
        }
        for(int i=0;i<sb.length();i++){
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }

    /**
     * Space Optimized approach
     *
     * we have 2 variables i to iterate over the array and res to keep the indices of compressed array
     * We iterate from i to n,
     * initialise groupLength = 1,
     * now we will increase the groupLength keeping the conditions in check i.e. i+grouplength is within the bounds
     * and the character at i (which will be 0 index or the characters first appearance) is same as the
     * i + grouplength.
     * As we exit this loop we have the grouplength and index i as the character
     * we add the character at i to index res and increment res (res handles the compress array address)
     * Now res is at next index, if count is more than 1 add them into chars[res++]
     * At the end, increment i with groupLength (new character index)
     */
    public static int compress2(char[] chars) {
        int i = 0, res = 0;
        while(i < chars.length){
            int groupLength = 1;
            while(i + groupLength < chars.length && chars[i+groupLength] == chars[i]){
                groupLength++;
            }
            chars[res++] = chars[i];
            if(groupLength > 1){
                for(char c:Integer.toString(groupLength).toCharArray()){
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }


}
