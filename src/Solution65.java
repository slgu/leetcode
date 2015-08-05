/**
 * Created by gsl on 7/19/15.
 */

import java.util.*;

public class Solution65 {
    private static boolean judge_int(String s){
        int n = s.length();
        if(n == 0)
            return false;
        //except - && +
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
            n = s.length();
            if (n == 0)
                return false;
        }
        return judge_pure_int(s);
    }
    private static boolean judge_pure_int(String s){
        int n = s.length();
        if(n == 0)
            return false;
        for(int i = 0; i < n; ++i){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){

            }
            else{
                return false;
            }
        }
        return true;
    }
    private static String freespace(String s){
        int i = 0;
        int n = s.length();
        int j = n - 1;
        while(i < n && s.charAt(i) == ' ')++i;
        while(j >= 0 && s.charAt(j) == ' ')--j;
        if(i == n)
            return "";
        return s.substring(i, j + 1);
    }
    public static boolean judge_float_or_int(String s){
        //except - && +
        int n = s.length();
        if(n == 0)
            return false;
        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            s = s.substring(1);
            n = s.length();
        }
        if(n == 0)
            return false;
        if(s.equals("."))
            return false;
        for(int i = 0; i < n; ++i){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){

            }
            else if(s.charAt(i) == '.'){
                return i == n - 1 || judge_pure_int(s.substring(i + 1));
            }
            else
                return false;
        }
        return true;
    }
    public boolean isNumber(String s) {
        s = freespace(s);
        int n = s.length();
        for(int i = 0; i < n; ++i)
            if(s.charAt(i) == 'e'){
                return i != n - 1 && i != 0 && judge_float_or_int(s.substring(0,i)) && judge_int(s.substring(i + 1, n));
            }
        return judge_float_or_int(s);
    }
    public static void main(String[] args) {
        Solution65 a = new Solution65();
        System.out.println(a.isNumber("0"));
        System.out.println(a.isNumber(" 0.1"));
        System.out.println(a.isNumber("abc"));
        System.out.println(a.isNumber("e"));
        System.out.println(a.isNumber("2e10"));
        System.out.println(a.isNumber("."));
        System.out.println(a.isNumber(" 005047e+6"));
    }
}