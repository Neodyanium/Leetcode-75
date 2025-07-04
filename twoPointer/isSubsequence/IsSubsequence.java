package twoPointer.isSubsequence;

public class IsSubsequence {

    public static void main(String[] args) {
        boolean flag = isSubsequence("abc","acbhdcv");
        System.out.println(flag);
    }


    /**
     * We use two pointers and simply check the following
     *
     * if both the characters match both pointers move forward
     * if both doesn't match simply increment the larger or here the target string pointer.
     *
     *
     * @param s Source String
     * @param t Target String
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
