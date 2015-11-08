/**
 * Created by slgu1 on 10/27/15.
 */
public class Solution44_4 {
    private boolean cmp(char a, char b) {
        if (b == '?')
            return true;
        return a == b;
    }
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        boolean back_status = false;
        int n1 = s.length();
        int n2 = p.length();
        int last_i = 0;
        int last_j = 0;
        while (i < n1) {
            if (j < n2 && cmp(s.charAt(i), p.charAt(j))) {
                ++i;
                ++j;
            }
            else if (j < n2 && p.charAt(j) == '*') {
                while(j < n2 && p.charAt(j) == '*') ++j;
                if (j == n2)
                    return true;
                last_j = j;
                last_i = i;
                back_status = true;
            }
            else if (back_status) {
                i = ++last_i;
                j = last_j;
            }
            else
                return false;
        }
        while (j < n2 && p.charAt(j) == '*')
            ++j;
        if (j == n2)
            return true;
        else
            return false;
    }
    public static void main(String [] args) {
        Solution44_4 a = new Solution44_4();
        System.out.println(a.isMatch("ab", "?*"));
        System.out.println(a.isMatch("aa", "a"));
        System.out.println(a.isMatch("ab", "ab"));
        System.out.println(a.isMatch("aa", "*"));
        System.out.println(a.isMatch("aa", "?*"));
        System.out.println(a.isMatch("", "?*"));
    }
}