import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/7/15.
 */


import java.util.*;

public class Solution44 {
    private static boolean ex_cmp(char s1, char s2){
        if(s1 == '?' || s2 == '?' || s1 == s2)
            return true;
        else
            return false;
    }
    public int ex_kmp(String s1, String s2, int st){
        int n2_length = s2.length();
        int t[] = new int[n2_length];
        t[0] = 0;
        for(int i = 1; i < n2_length; ++i){
            int x = i - 1;
            while(!ex_cmp(s2.charAt(t[x]),s2.charAt(i))){
                if(x == 0) break;
                x = t[x] - 1;
                if(x <= 0) break;
            }
            if(x <= 0){
                if(ex_cmp(s2.charAt(0),s2.charAt(i)))
                    t[i] = 1;
                else
                    t[i] = 0;
            }
            else{
                t[i] = t[x] + 1;
            }
        }
        int n1_length = s1.length();
        int match_length = 0;
        for(int i = st; i < n1_length; ++i){
            while(match_length != 0) {
                if(ex_cmp(s1.charAt(i),s2.charAt(match_length))) {
                    match_length = match_length + 1;
                    break;
                }
                else{
                    match_length = t[match_length - 1];
                }
            }
            if(match_length == 0){
                if(ex_cmp(s1.charAt(i),s2.charAt(0)))
                    match_length = 1;
            }
            if(match_length == n2_length) {
                return i - n2_length + 1;
            }
        }
        return -1;
    }
    private static String preprocess(String p){
        Character last = null;
        int n = p.length();
        StringBuilder builder_res = new StringBuilder();
        for(int i = 0; i < n; ++i){
            if(last == null){
                builder_res.append(p.charAt(i));
            }
            else{
                if(last == p.charAt(i) && last == '*')
                    ;
                else{
                    builder_res.append(p.charAt(i));
                }
            }
            last = p.charAt(i);
        }
        return builder_res.toString();
    }
    public boolean isMatch(String s, String p) {
        p = preprocess(p);
        int n1_length = s.length();
        int n2_length = p.length();
        int left_star = -1;
        int right_star = -1;
        for(int i = 0; i < n2_length; ++i){
            if(p.charAt(i) == '*'){
                left_star = i;
                break;
            }
        }
        if(left_star == -1) right_star = -1;
        else{
            for(int i = n2_length - 1; i >= 0; --i)
                if(p.charAt(i) == '*'){
                    right_star = i;
                    break;
                }
        }
        if(left_star != -1){
            if(n1_length < left_star + n2_length - 1 - right_star)
                return false;
            for(int i = 0; i < left_star; ++i)
                if(!ex_cmp(s.charAt(i),p.charAt(i)))
                    return false;
            for(int i = 0; i < n2_length - 1 - right_star; ++i)
                if(!ex_cmp(s.charAt(n1_length - 1 - i), p.charAt(n2_length - 1 - i)))
                    return false;
        }
        else{
            if(n1_length != n2_length) return false;
            for(int i = 0; i < n1_length; ++i)
                if(!ex_cmp(s.charAt(i), p.charAt(i)))
                    return false;
            return true;
        }
        s = s.substring(left_star, n1_length - (n2_length - 1 - right_star));
        n1_length = s.length();
        int st = left_star + 1;
        int match_st = 0;
        for(int i = left_star + 1; i <= right_star; ++i){
            if(p.charAt(i) == '*'){
                int res = ex_kmp(s, p.substring(st, i), match_st);
                if(res == -1) return false;
                //update match st
                match_st = res + i - st;
                st = i + 1;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution44 a = new Solution44();
        /*
        System.out.println(a.isMatch("aab", "c*a*b"));
        System.out.println(a.isMatch("aa", "a*"));
        System.out.println(a.isMatch("ab", "?*"));
        System.out.println(a.isMatch("aaa", "aa"));
        */
        //System.out.println(a.isMatch("mississippi", "m*iss*iss*"));
        System.out.println(a.isMatch("b", "*?*?"));
    }
}
