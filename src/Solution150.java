
import java.util.Stack;

/**
 * Created by slgu1 on 10/6/15.
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack <Integer> stack_int = new Stack<Integer>();
        int n = tokens.length;
        if (n == 0)
            return 0;
        for (int i = 0; i < n; ++i) {
            if (tokens[i].equals("+")) {
                int item1 = stack_int.pop();
                int item2 = stack_int.pop();
                stack_int.push(item1 + item2);
            }
            else if (tokens[i].equals("*")) {
                int item1 = stack_int.pop();
                int item2 = stack_int.pop();
                stack_int.push(item1 * item2);

            }
            else if (tokens[i].equals("-")) {
                int item1 = stack_int.pop();
                int item2 = stack_int.pop();
                stack_int.push(item2 - item1);
            }
            else if (tokens[i].equals("/")) {
                int item1 = stack_int.pop();
                int item2 = stack_int.pop();
                stack_int.push(item2 / item1);
            }
            else {
                int digit = Integer.parseInt(tokens[i]);
                stack_int.push(digit);
            }
        }
        return stack_int.pop();
    }
    public static void main(String [] args) {
        Solution150 a = new Solution150();
        System.out.println(a.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
