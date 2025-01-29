package string.mergeStringAlternately;

/**
 * The function mergeAlternately merges two strings (word1 and word2) by alternating their characters. It uses a single while loop to alternate characters from both strings and handles any remaining characters after one string is exhausted.
 *
 * Initialization:
 * i and j track positions in word1 and word2.
 * A StringBuffer sb stores the merged result.
 *
 * Merging Alternately:
 * The while loop runs until both strings are fully processed.
 * If characters are left in word1, append it to sb and increment i.
 * If characters are left in word2, append it to sb and increment j.
 *
 * Return Result:
 * The final merged string is returned by sb.toString().
 *
 * Time Complexity:
 * The function iterates through both strings once, leading to a total of O(n + m) operations, where n and m are the lengths of word1 and word2.
 *
 *  Space Complexity:
 * The space used is for the StringBuffer, which stores the merged string, resulting in O(n + m) space complexity. The space for variables i and j is constant, O(1).
 * The algorithm efficiently merges the two strings in linear time and space.
 */
class Solution3 {

    public String mergeAlternately(String word1, String word2) {
        int i=0,j=0;
        StringBuffer sb = new StringBuffer();
        while(i < word1.length() || j < word2.length()){

            if(i < word1.length()){
                sb.append(word1.charAt(i));
                i++;
            }

            if(j < word2.length()){
                sb.append(word2.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }
}