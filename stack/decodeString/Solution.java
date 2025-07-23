package stack.decodeString;
import java.util.Stack;

/**
 * Simple advise! We adding each char to stack till we get ], in this case, we can start decoding by taking last values
 * from stack, process them (crate string, and multiply to integer) and push back into stack, hope it will help you to
 * find right direction.
 */
public class Solution {

    public static void main(String[] args) {

        String[] examples = {"3[a]2[bc]","3[a2[c]]","2[abc]3[cd]ef","20[Sangharsh]"};
        for(String s:examples){
            decodeString(s);
        }

    }

    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        //simple condition to check if it is not ] keep adding to stack
        for(char c:s.toCharArray()){
            StringBuilder temp = new StringBuilder();
            //Once we encounter ] back track and get the all the characters till we encounter [
            if(c == ']'){
                while(true){
                    String str = stack.pop();
                    if(str.equals("["))
                        break;
                    temp.append(str);
                }
                //The following helps to fetch the number(using this as number can be multi-digit)
                //in case of Character we have built in methods, for string to detect a digit we used regex
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() &&stack.peek().matches("\\d") ){
                    sb.append(stack.pop());
                }
                int loop = Integer.parseInt(sb.reverse().toString());
                //we append the string of characters to result, they will be reverse ordered for now
                for(int i=0;i<loop;i++){
                    res.append(temp);
                }
                stack.push(res.toString());
                //since we are using it to push freshly multiplied string we clear it for fresh usage after pushing
                res.setLength(0);
            }else{
                stack.push(String.valueOf(c));
            }

        }
        //we pop all the items and reverse it and return
        res.setLength(0);
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        System.out.println(res.reverse());
        return res.reverse().toString();
    }
}
