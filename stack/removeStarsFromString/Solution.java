package stack.removeStarsFromString;

/**
 * I think the problems where you have to delete the previous character or similar operations depending on some
 * condition, we can use Stack
 */
public class Solution {

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars2(s));
    }

    /**
     * Not the direct use of stack data-structure, but the operation is similar to stack.
     */
    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '*'){
                sb.deleteCharAt(sb.length() - 1);
            }else
                sb.append(c);
        }
        return sb.toString();
    }

    /**
     * This is faster because sb.deleteCharAt(sb.length() - 1); is costly operation as under the hood array shifting
     * or something. The following code does simple operations no deletion or shifting of any sorts.
     *
     * But the ending string buffer operation has to be done till j. Anyway to converting the whole array leads to error
     */
    public static String removeStars2(String s) {
        int j = 0;
        char[] ch = new char[s.length()];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '*')
                j--;
            else
                ch[j++] = c;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<j;i++){
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}
