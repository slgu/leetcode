/**
 * Created by gsl on 7/7/15.
 */

import java.math.BigInteger;
import java.util.*;
public class Solution43 {
    //clear duplicate zero
    public String clear_zero(String num){
        int i = 0;
        int n = num.length();
        while(i < n && num.charAt(i) == '0'){
            ++i;
        }
        if(i == n)
            return "0";
        return num.substring(i, n);
    }
    //add String number
    public String add(String num1, String num2){
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder result_builder = new StringBuilder();
        int i = 1;
        int enter = 0;
        while(i <= n1 || i <= n2){
            char a1,a2;
            if(n1 - i >= 0) {
                a1 = num1.charAt(n1 - i);
            }
            else{
                a1 = '0';
            }
            if(n2 - i >= 0) {
                a2 = num2.charAt(n2 - i);
            }
            else{
                a2 = '0';
            }
            int sum = (a1 - '0') + (a2 - '0') + enter;
            if(sum >= 10){
                enter = 1;
                sum -= 10;
            }
            else{
                //reset zero
                enter = 0;
            }
            result_builder.append((char)(sum + '0'));
            ++i;
        }
        if(enter == 1)
            result_builder.append('1');
        return result_builder.reverse().toString();
    }

    public String multiply(String num1, String num2) {
        //sign for number
        int sign = 1;
        if(num1.charAt(0) == '-'){
            num1 = num1.substring(1, num1.length());
            sign *= -1;
        }
        if(num2.charAt(0) == '-'){
            num2 = num1.substring(1, num1.length());
            sign *= -1;
        }
        int n1 = num1.length();
        int n2 = num2.length();
        String result = new String("0");
        for(int i = 0; i < n1; ++i) {
            StringBuilder to_be_add = new StringBuilder("");
            int enter = 0;
            int mul1 = num1.charAt(n1 - 1 - i) - '0';
            for (int j = 0; j < n2; ++j){
                int mul2 = num2.charAt(n2 - 1 - j) - '0';
                int mul_res = mul1 * mul2 + enter;
                to_be_add.append((char)(mul_res % 10 + '0'));
                enter = mul_res / 10;
            }
            if(enter != 0)
                to_be_add.append((char)(enter + '0'));
            to_be_add = to_be_add.reverse();
            for(int k = 0; k < i; ++k)
                to_be_add.append('0');
            String to_be_add_str = to_be_add.toString();
            to_be_add_str = clear_zero(to_be_add_str);
            result = add(result, to_be_add_str);
        }
        result = clear_zero(result);
        //resolve sign for number
        if(sign == -1){
            StringBuilder tmp = new StringBuilder();
            tmp.append('-');
            for(int i = 0; i < result.length(); ++i){
                tmp.append(result.charAt(i));
            }
            result = tmp.toString();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("123","456"));
    }
}
