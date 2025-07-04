package string.reverseWordsInAString;

public class Solution2 {

    public static void main(String[] args) {
        String s = "  hello world  ";
        String result = reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        int left = 0, right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') left++;

        while (left <= right && s.charAt(right) == ' ') right++;


        return "";

    }
}
