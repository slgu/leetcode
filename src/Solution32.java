import java.util.Stack;

/**
 * Created by gsl on 7/6/15.
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1)
            return 0;
        int max_length = 0;
        Stack <Object> stack = new Stack<Object>();
        int n = s.length();
        stack.push(s.charAt(0));
        for(int i = 1; i < n; ++i){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            int accumulate = 0;
            if(stack.peek() instanceof Integer){
                accumulate = (Integer)stack.pop();
            }
            if(stack.isEmpty()){
                if(accumulate != 0) {
                    stack.push(accumulate);
                }
                stack.push(s.charAt(i));
                continue;
            }
            Character left = (Character)stack.peek();
            if(left == '(' && s.charAt(i) == ')'){
                accumulate += 1;
                stack.pop();
                if(!stack.isEmpty() && stack.peek() instanceof  Integer){
                    int another_accumulate = (Integer)stack.pop();
                    accumulate += another_accumulate;
                }
                stack.push(accumulate);
            }
            else{
                if(accumulate != 0) {
                    stack.push(accumulate);
                }
                stack.push(s.charAt(i));
            }
            if(accumulate > max_length)
                max_length = accumulate;
        }
        return max_length * 2;
    }
    public static void main(String [] args){
        Solution32 a = new Solution32();
        System.out.println(a.longestValidParentheses("()()"));
    }
}
