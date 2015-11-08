import java.util.LinkedList;

/**
 * Created by slgu1 on 10/27/15.
 */
public class Solution44_3 {
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        int [][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; ++i)
            for (int j = 0; j <= n2; ++j)
                dp[i][j] = -1;
        dp[n1][n2] = 1;
        for (int i = n1; i >= 0; --i)
            for (int j = n2; j >= 0; --j) {
                if (dp[i][j] != -1)
                    continue;
                dp[i][j] = 0;
                if (j == n2) {
                    continue;
                }
                if (i == n1) {
                    if (p.charAt(j) == '*')
                        dp[i][j] = dp[i][j + 1];
                }
                else {
                    if (p.charAt(j) == '*') {
                        for (int k = n1; k >= i; --k) {
                            if (dp[k][j + 1] == 1) {
                                dp[i][j] = 1;
                                break;
                            }
                        }
                    }
                    else if (p.charAt(j) == '?') {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                    else {
                        if (s.charAt(i) == p.charAt(j))
                            dp[i][j] = dp[i + 1][j + 1];
                    }
                }
            }
        return dp[0][0] == 1;
    }
    public static void main(String [] args) {
        Solution44_3 a = new Solution44_3();
        System.out.println(a.isMatch("aa", "a*"));
        System.out.println(a.isMatch("aba", "a*ca"));
        System.out.println(a.isMatch("aaa", "aa"));
        System.out.println(a.isMatch("aa", "*"));
        System.out.println(a.isMatch("aa", "a*"));
        System.out.println(a.isMatch("aab", "c*a*b"));
    }
}
