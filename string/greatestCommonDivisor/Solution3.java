package string.greatestCommonDivisor;

/**
 * This function finds the greatest common divisor (GCD) of two strings. It does this using a mathematical approach based on the properties of string repetition and the Euclidean algorithm for computing the GCD of two numbers.
 *
 * 1. Checking if a Common Divisor String Exists
 * if (!(str1 + str2).equals(str2 + str1)) {
 *     return "";
 * }
 * If two strings can be concatenated in different orders (str1 + str2 and str2 + str1), and they are not equal, no common divisor string exists.
 * This works because, for a valid GCD string X, both str1 and str2 must be made up of repeated occurrences of X.
 *
 *
 * 2. Computing the GCD of String Lengths
 * int gcdLength = gcd(str1.length(), str2.length());
 * Instead of checking substrings manually, the function finds the GCD of the lengths of str1 and str2 using the Euclidean algorithm.
 * This gives the length of the largest possible repeating unit (GCD string).
 *
 * 3. Extracting the GCD String
 * return str1.substring(0, gcdLength);
 * The substring from 0 to gcdLength in str1 is returned as the GCD string.
 * Since str1 + str2 == str2 + str1, we are guaranteed that this substring can fully construct both str1 and str2 through repetition.
 *
 * Time Complexity
 * GCD Function (gcd(x, y)):
 * The Euclidean algorithm runs in O(log(min(x, y))) time.
 * String Concatenation (str1 + str2 and str2 + str1):
 * This takes O(N + M) time, where N = len(str1) and M = len(str2).
 * Substring Extraction (substring(0, gcdLength)):
 * This takes O(N + M) time in the worst case.
 * Thus, the overall time complexity is O(N + M + log(min(N, M))), dominated by the string operations.
 * or simply O(N+M)
 *
 * Space Complexity
 * The function only uses a few integer variables (gcdLength, x, y), which take O(1) space.
 * The recursion in gcd(x, y) takes O(log(min(N, M))) space in the worst case.
 * But the concatenation for comparison takes O(n+m)
 * The substring() operation does not create extra space beyond its return value.
 */
public class Solution3 {

        public String gcdOfStrings(String str1, String str2) {

            if( !(str1+str2).equals(str2+str1) )
                return "";

            int gcdLength = gcd(str1.length(),str2.length());
            return str1.substring(0,gcdLength);
        }

        public int gcd(int x, int y){
            if(y == 0)
                return x;
            return gcd(y, x % y);
        }

}
