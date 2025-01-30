package string.greatestCommonDivisor;

/**
 * Made some assumptions for this problem,
 * 1. string 1 is always bigger than string 2 which is handled by the recursive call of same function
 * if(str1.length() < str2.length()){
 *    return gcdOfStrings(str2,str1);
 * }
 *
 * 2. if string1 is same as the string 2 then we can simply return any of the string as the gcd so that is added as well
 * if(str1.equals(str2)){
 *    return str1;
 * }
 *
 * 3. If the gcd exist then it will be present in both the Strings,we will use this logic and check if the smaller
 * string is the prefix of bigger, if yes just remove that and pass the reduced new string as string 1 argument, at
 * some point if string 1 becomes small it is handled and there would be a point both of them will be of same size
 * and that will be the gcd
 *
 * eg: "ABABAB" , "ABAB"
 * -> 1st function call -> ABABAB , ABAB, fits into 3. condition
 * -> 2nd function call -> AB, ABAB , fits into 1. condition
 * -> 3rd function call -> ABAB, AB , fits into 3. condition
 * -> 4th function call -> AB, AB , fits into 2. condition and is returned.
 *
 *  Time Complexity
 * Each recursive call reduces the length of str1 by at least str2.length(), similar to how the Euclidean algorithm reduces a number in O(log n) time.
 *
 * Let N = len(str1), M = len(str2).
 * The worst case is when the function recursively removes chunks of size M, leading to O(N / M) calls.
 * Each call involves substring(), which takes O(N) time in the worst case.
 * Thus, the overall time complexity is O(N).
 *
 * Space Complexity
 * The recursion depth is O(N / M) in the worst case.
 * Since each call only uses a few variables, the space complexity is O(N / M) due to recursion stack usage.
 *
 */
public class Solution2 {

    public static void main(String[] args) {
        String s1 = "ABABAB" , s2= "ABAB";
        String result = gcdOfStrings(s1,s2);
        System.out.println(result);
    }
    public static String gcdOfStrings(String str1, String str2) {

        if(str1.length() < str2.length()){
            return gcdOfStrings(str2,str1);
        }

        if(str1.equals(str2)){
            return str1;
        }

        if(str1.startsWith(str2)){
            return gcdOfStrings(str1.substring(str2.length()),str2);
        }

        return "";
    }
}
