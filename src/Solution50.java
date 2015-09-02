import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/13/15.
 */

import java.util.*;

public class Solution50 {
    public double myPow(double x, int n) {
        long nn = n;
        if(nn == 0)
            return 1;
        double result = 1;
        int sign = 0;
        if(nn < 0){
            sign = 1;
            nn = -nn;
        }
        while(nn != 0){
            if((nn & 1) != 0){
                result *= x;
            }
            x = x * x;
            nn >>= 1;
        }
        if(sign == 1)
            result = 1 / result;
        return result;
    }
    public static void main(String[] args) {
        Solution50 a = new Solution50();
        System.out.println(a.myPow(1.00000, -2147483648));
    }
}
