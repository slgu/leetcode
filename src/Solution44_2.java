/**
 * Created by gsl on 7/7/15.
 */

import java.util.*;

public class Solution44_2 {
    private boolean cmp(char a, char b){
        if(b == '?' || a == b)
            return true;
        else
            return false;
    }
    public boolean isMatch(String s, String p) {
        //greedy method && backtracking
        //two-point go
        int i = 0;
        int j = 0;
        int last_j = -1;
        int last_i = -1;
        int n1_length = s.length();
        int n2_length = p.length();
        boolean back_status = false;
        while(i < n1_length){
            if(j < n2_length && cmp(s.charAt(i),p.charAt(j))){
                ++i;
                ++j;
            }
            else if(j < n2_length && p.charAt(j) == '*'){
                while(j < n2_length && p.charAt(j) == '*')
                    ++j;
                if(j == n2_length)
                    return true;
                last_j = j;
                last_i = i;
                back_status = true;
            }
            else if(back_status){
                //increase last_i
                i = ++last_i;
                j = last_j;
            }
            else
                return false;
        }
        while(j < n2_length && p.charAt(j) == '*')
            ++j;
        if(i == n1_length && j == n2_length)
            return true;
        return false;
    }
    public static void main(String[] args) {
        Solution44_2 a = new Solution44_2();
        System.out.println(a.isMatch("aab", "c*a*b"));
        System.out.println(a.isMatch("ab", "?*"));
        System.out.println(a.isMatch("aa", "a*"));
        System.out.println(a.isMatch("aa", "*"));
        System.out.println(a.isMatch("aaa","aa"));
    }
}
