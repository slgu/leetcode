/**
 * Created by slgu1 on 9/4/15.
 */
public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if(n3 != n1 + n2) {
            return false;
        }
        dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for(int i = 0; i <= n1; ++i)
            for(int j = 0; j <= n2; ++j){
                if(i == 0 && j == 0)
                    continue;
                dp[i][j] = false;
                if(i >= 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
                    dp[i][j] = true;
                if(j >= 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])
                    dp[i][j] = true;
            }
        return dp[n1][n2];
    }
    private boolean [][]dp;
}
