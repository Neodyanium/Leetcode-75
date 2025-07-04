package string.swapVowels;

/**
 * This approach is similar except for the fact it uses simple if condition to make sure that i and j are tracking it
 * checks the whole 10 values and with continue function it keeps it tracked to the vowel.
 *
 * It effectively reduces the extra space required in the last approach and it more effecient
 */
public class Solution2 {
    public String reverseVowels(String s) {
        char[] carr =s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j){
            if(!(carr[i]=='a'|| carr[i]=='e' || carr[i]=='i'|| carr[i]=='o'||carr[i]=='u'|| carr[i]=='A'|| carr[i]=='E' || carr[i]=='I'|| carr[i]=='O'||carr[i]=='U')){
                i++;
                continue;
            }
            if(!(carr[j]=='a'|| carr[j]=='e' || carr[j]=='i'|| carr[j]=='o'||carr[j]=='u'|| carr[j]=='A'|| carr[j]=='E' || carr[j]=='I'|| carr[j]=='O' ||carr[j]=='U')){
                j--;
                continue;
            }
            char temp  = carr[i];
            carr[i] = carr[j];
            carr[j] = temp;
            i++;
            j--;
        }
        return new String(carr);
    }
}
