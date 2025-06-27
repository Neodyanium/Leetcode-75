package string.mergeStringAlternately;

/**
 * The function mergeAlternately merges two strings (word1 and word2) by alternating characters, with a focus on using a single loop and determining the maximum length of the two strings beforehand.
 *
 * Approach:
 * Determine Maximum Length:
 * First, calculate m = Math.max(word1.length(), word2.length()). This gives the maximum length between the two strings, ensuring the loop runs for the longest string's length, even if one string is shorter.

 * Merging Alternately:
 * A for loop runs from 0 to m-1. Inside the loop:
 * If i is less than word1.length(), append the character from word1 at index i.
 * If i is less than word2.length(), append the character from word2 at index i.
 *
 *  Return Result:
 * After the loop, the merged string is returned by calling sb.toString().
 *
 * Time Complexity:
 * The loop iterates m times, where m is the maximum length of the two strings. For each iteration, two append operations (in the worst case) are performed.
 * Thus, the time complexity is O(m), where m = max(n, m) and n and m are the lengths of word1 and word2.
 *
 * Space Complexity:
 * The space used is for the StringBuffer, which stores the merged string. Since the length of the final string is O(n + m), the space complexity is O(n + m).
 * The space for variables m, i, and sb is constant, O(1).
 * This approach optimizes by calculating the maximum length once and using a single loop to handle both strings, making it efficient in both time and space.
 */
public class Solution1{
    public String mergeAlternately(String word1, String word2) {
        int m = Math.max(word1.length(), word2.length());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<m;i++){
            if(i < word1.length()){
                sb.append(word1.charAt(i));
            }

            if(i < word2.length()){
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}