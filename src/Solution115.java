/**
 * Created by slgu1 on 9/3/15.
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int [][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 0; i <= n1; ++i)
            for(int j = 0; j <= n2; ++j)
                dp[i][j] = 0;
        for(int i = 0; i <= n1; ++i)
            dp[i][0] = 1;
        for(int i = 1; i <= n1; ++i){
            for(int j = 1; j <= i && j <= n2; ++j){
                dp[i][j] = 0;
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] += dp[i - 1][j - 1];
                }
                dp[i][j] += dp[i - 1][j];
            }
        }
        return dp[n1][n2];
    }
    public static void main(String [] args){
        Solution115 a = new Solution115();
        System.out.println(a.numDistinct("rabbbit", "rabbit"));
    }
}
