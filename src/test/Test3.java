package test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by slgu1 on 9/23/15.
 */
public class Test3 {

    public void test() {
        n = 10;
        exp = 5;
        dfs(0, 0);
    }
    public void dfs(int x, int nowexp) {
        if (x >= n) {
            System.out.println(exponent);
            return;
        }
        if (nowexp == exp) {
            System.out.println(exponent);
            return;
        }
        for (int i = 0; i <= exp - nowexp; ++i) {
            idx.add(x);
            exponent.add(i);
            dfs(x + 1, nowexp + i);
            idx.pop();
            exponent.pop();
        }
    }
    public static void main(String [] args) {
        Test3 t = new Test3();
        t.test();
    }
    private int n;
    private Stack <Integer> idx = new Stack<Integer>();
    private Stack <Integer> exponent = new Stack<Integer>();
    private int exp;
}
