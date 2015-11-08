/**
 * Created by slgu1 on 10/26/15.
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack.equals("")) {
            if (needle.equals(""))
                return 0;
            else
                return -1;
        }
        if (needle.equals(""))
            return 0;
        int [] t = KmpPre(needle);
        int nowMatch = 0;
        int n = haystack.length();
        for (int i = 0; i < n; ++i) {
            if (nowMatch == 0) {
                if (haystack.charAt(i) == needle.charAt(0))
                    nowMatch = 1;
            }
            else {
                while (nowMatch != 0) {
                    if (needle.charAt(nowMatch) == haystack.charAt(i)) {
                        ++nowMatch;
                        break;
                    }
                    nowMatch = t[nowMatch - 1];
                }
                if (nowMatch == 0) {
                    if (needle.charAt(0) == haystack.charAt(i))
                        ++nowMatch;
                }
            }
            if (nowMatch == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }
    public static void main(String [] args) {
        Solution28 a = new Solution28();
        System.out.println(a.strStr("caaababababa", "aba"));
    }
    private int[] KmpPre(String pattern) {
        int n = pattern.length();
        int t [] = new int[n];
        t[0] = 0;
        for (int i = 1; i < n; ++i) {
            int start = i - 1;
            while (t[start] != 0) {
                if (pattern.charAt(t[start]) == pattern.charAt(i)) {
                    t[i] = t[start] + 1;
                    break;
                }
                start = t[start] - 1;
            }
            if (t[i] == 0) {
                if (pattern.charAt(0) == pattern.charAt(i)) {
                    t[i] = 1;
                }
            }
        }
        return t;
    }
}
