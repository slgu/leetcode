import java.util.Stack;

/**
 * Created by slgu1 on 11/11/15.
 */
public class Solution224 {
    public int calculate(String s) {
        Stack <Character> st_c = new Stack<Character>();
        Stack <Integer> st_i = new Stack<Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == ' ')
                continue;
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(')
                st_c.add(s.charAt(i));
            else if (s.charAt(i) == ')') {
                st_c.pop();
                while (!st_c.empty()) {
                    char c = st_c.peek();
                    if (c != '(') {
                        int a = st_i.pop();
                        int b = st_i.pop();
                        int res = 0;
                        if (c == '-')
                            res = b - a;
                        else
                            res = b + a;
                        st_i.add(res);
                        st_c.pop();
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                // get integer
                int a = 0;
                while (i < n) {
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        a = 10 * a + (s.charAt(i) - '0');
                        ++i;
                    }
                    else
                        break;
                }
                --i;
                st_i.add(a);
                if (!st_c.empty()) {
                    char c = st_c.peek();
                    if (c != '(') {
                        a = st_i.pop();
                        int b = st_i.pop();
                        int res = 0;
                        if (c == '-')
                            res = b - a;
                        else
                            res = b + a;
                        st_i.add(res);
                        st_c.pop();
                    }
                }
            }
        }
        return st_i.pop();
    }
    public static void main(String [] args) {
        Solution224 a = new Solution224();
        System.out.println(a.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
