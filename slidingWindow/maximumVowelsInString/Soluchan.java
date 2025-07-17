package slidingWindow.maximumVowelsInString;

import java.util.*;

public class Soluchan {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int left = 0, right = 0, count = 0, maxCount = 0;
        while (right < k) {
            if (set.contains(s.charAt(right))) {
                maxCount++;
            }
            right++;
        }
        count = maxCount;
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                count++;
            }
            right++;
            if (set.contains(s.charAt(left))) {
                count--;
            }
            left++;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    /**
     * The better solution of way of writing is similar to the MAS problem, we used a single for loop for constant k
     * sized window sliding. No sum, so no issue with inflation or defalations
     */
    public int maxVowels2(String s, int k) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i)))
                count++;
            if (i >= k && set.contains(s.charAt(i - k)))
                count--;
            max = Math.max(max, count);
        }
        return max;
    }
}
