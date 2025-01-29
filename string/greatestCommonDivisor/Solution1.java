package string.greatestCommonDivisor;

/**
 * Since we want the greatest common divisor the we consider that there exists a substring that divides both the
 * Strings.
 * we will work with this example
 * s1 = "ABABAB" , s2 = "ABAB"
 *
 * we will be interating for the smaller length among both strings , it doesn;t matter much though because the gcd
 * string is to exist both of them, since we want it to be greatest we check it from last index.
 *
 * the for loop starts with the last index and it is then passed to the helper function which checks whether the
 * string is valid, if it is then that string till that particular index is returned by the gcd function, if not even
 * a single character matches then an empty string is returned. It will iterate and each time the i is reduced by 1
 * so as to provide decreasing substring that might be the answer, it is kept >= 1 because we want atleast a size of
 * string to compare is 1, if we include 0, out logic will give division / 0 exception
 *
 * isValid function is a boolean function,
 * a basic validation check will first happen, it is clear that the gcd string is the exist in both the strings and
 * it can be present any number of times, in our taken example we know the output should be AB and we can see that AB
 * does exist 3 times in string s1 and 2 times in string s2. This same principe is used is here, if any substring we
 * are looking at is not able to divide both string 1 and string 2 then it can't be the answer hence retur false
 *
 * Now if it does divide both the strings, then we have a contendor for the gcd to exist, so the last line creates a
 * base string which is substring till that index and we use a replace function on both the string s1 and s2 and
 * replace the substring with "", and naturally if it is the gcd the strings will become empty and if both did become
 * empty then that substring is gcd and we can return true, so whether such gcd exist depend on both string after
 * replace we have returned the same.
 *
 */
class Solution1 {

    public static void main(String[] args) {
        String s1 = "ABABAB" , s2 = "ABAB";
        String gcd = gcdOfStrings(s1,s2);
        System.out.println(gcd);
    }

    public static String gcdOfStrings(String str1, String str2) {
        for (int i = Math.min(str1.length(), str2.length()); i >= 1; i--) {
            if (isValid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }

    public static boolean isValid(String s1, String s2, int k) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 % k > 0 || l2 % k > 0) {
            return false;
        }
        String base = s1.substring(0, k);
        return s1.replace(base, "").isEmpty() && s2.replace(base, "").isEmpty();
    }
}