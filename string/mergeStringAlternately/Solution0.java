class Solution0 {

    /**
     *The function mergeAlternately takes two strings, word1 and word2, and merges them by alternating characters from each string. If one string is longer than the other, the remaining characters from the longer string are appended at the end.
     *
     * Steps:
     * Initialization:
     * i and j are initialized to 0 to track positions in word1 and word2, respectively.
     * A StringBuffer sb is created to store the merged string.
     *
     * Merging Alternately:
     * A while loop runs while both i < word1.length() and j < word2.length().
     * In each iteration:
     * Append the character from word1 at index i and increment i.
     * Append the character from word2 at index j and increment j.
     *
     * Appending Remaining Characters:
     * If word1 is longer than word2, another while loop appends the remaining characters from word1 to sb.
     * Similarly, if word2 is longer, its remaining characters are appended.
     *
     * Returning the Result:
     * The final merged string is obtained by calling sb.toString().
     *
     * Time Complexity:
     * The function iterates through both strings only once.
     * The total number of operations is proportional to O(n + m), where n = word1.length() and m = word2.length().
     * Time Complexity: O(n + m).
     *
     * Space Complexity:
     * The only extra space used is for the StringBuffer, which stores the merged string.
     * Since the output string has a length of O(n + m), the space complexity is O(n + m).
     * Other auxiliary variables (i, j) take constant space, O(1).
     */
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i));
            i++;
            sb.append(word2.charAt(j));
            j++;
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}