/**
 * Created by slgu1 on 10/23/15.
 */
public class Solution161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t))
            return false;
        int n1 = s.length();
        int n2 = t.length();
        if (n1 - n2 >= 2 || n2 - n1 >= 2)
            return false;
        if (n1 == 0 || n2 == 0)
            return true;
        boolean [][] dp;
        dp = new boolean[n1 + 1][4];
        for (int i = 0; i <= n1; ++i)
            for (int j = 0; j < 4; ++j)
                dp[i][j] = false;
        dp[0][0] = dp[0][1] = dp[0][2] = true;
        dp[0][3] = true;
        dp[1][0] = true;

        for (int i = 1; i <= n1; ++i) {
            if (i <= n2) {
                if (s.charAt(i - 1) == t.charAt(i - 1)) {
                    dp[i][3] = dp[i - 1][3];
                    dp[i][1] = dp[i - 1][1];
                }
                else {
                    if (dp[i - 1][3])
                        dp[i][1] = true;
                }
            }
            if (i + 1 <= n2) {
                if (s.charAt(i - 1) == t.charAt(i)) {
                    dp[i][2] = dp[i - 1][2];
                }
                else {
                    if (dp[i][3])
                        dp[i][2] = dp[i][3];
                }
            }
            if (i - 2 >= 0) {
                if (s.charAt(i - 1) == t.charAt(i - 2)) {
                    dp[i][0] = dp[i - 1][0];
                }
                else {
                    if (dp[i - 1][3])
                        dp[i][0] = dp[i - 1][3];
                }
            }
        }
        if (n1 == n2)
            return dp[n1][1];
        else if (n1 > n2)
            return dp[n1][0];
        else
            return dp[n1][2];
    }
    public static void main(String [] args) {
        Solution161 a = new Solution161();
        System.out.println(a.isOneEditDistance("asd", "as"));
    }
}
