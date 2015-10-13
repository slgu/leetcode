import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by slgu1 on 10/13/15.
 */
class MinStack {
    Stack <Integer> stack = new Stack<Integer>();
    Stack <Integer> minStack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        }
        else {
            int a = minStack.peek();
            if (x < a)
                minStack.push(x);
            else
                minStack.push(a);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
public class Solution155 {
    public static void main(String [] args) {
        MinStack st = new MinStack();
        st.push(1);
        st.push(-1);
        st.push(-2);
        st.push(-3);
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
        st.pop();
    }
}
