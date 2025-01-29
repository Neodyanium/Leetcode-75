public class Solution1{
    public String mergeAlternately(String word1, String word2) {
        int m = Math.max(word1.length(), word2.length());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<m;i++){
            if(i < word1.length()){
                sb.append(word1.charAt(i));
            }

            if(i < word2.length()){
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}