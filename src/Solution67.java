import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/20/15.
 */

import java.util.*;

public class Solution67 {
    public String addBinary(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int i = 0;
        int j = 0;
        int in = 0;
        StringBuilder res = new StringBuilder();
        while(i < n1 || i < n2){
            int ai = 0;
            int bi = 0;
            if(i < n1)
                ai = a.charAt(n1 - 1 - i) - '0';
            if(i < n2)
                bi = b.charAt(n2 - 1 - i) - '0';
            int digit = ai + bi + in;
            if(digit >= 2){
                digit -= 2;
                in = 1;
            }
            else{
                in = 0;
            }
            res.append((char)(digit + '0'));
            ++i;
        }
        if(in == 1)
            res.append('1');
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        Solution67 a = new Solution67();
        System.out.println(a.addBinary("1", "11"));
        System.out.println(a.addBinary("0", "0"));
    }
}
