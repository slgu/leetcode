/**
 * Created by gsl on 7/3/15.
 */
//二进制思想
public class Solution29 {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if(dividend == 0) return 0;
        if(dividend < 0) sign *= -1;
        if(divisor < 0) sign *= -1;
        long dividend_l = dividend;
        dividend_l = (dividend_l < 0)?-dividend_l:dividend_l;
        long divisor_l = divisor;
        divisor_l = (divisor_l < 0)?-divisor_l:divisor_l;
        int rate = 0;
        long pos = 1;
        long multi_divisor = divisor_l;
        while(dividend_l >= multi_divisor){
            multi_divisor <<= 1;
            pos <<= 1;
        }
        pos >>= 1;
        multi_divisor >>= 1;
        while(pos != 0){
            if(dividend_l == 0) break;
            if(dividend_l >= multi_divisor){
                rate += (int)pos;
                dividend_l -= multi_divisor;
            }
            multi_divisor >>= 1;
            pos >>= 1;
        }
        rate *= sign;
        if(rate == -2147483648 && sign == 1)
            return 2147483647;
        return rate;
    }
    public static void main(String [] args){
        /*
        Solution29 a = new Solution29();
        System.out.println(a.divide(1,1));
        */
    }
}
