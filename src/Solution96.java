/**
 * Created by slgu1 on 9/4/15.
 */

public class Solution96 {
    public int numTrees(int n) {
        if(n == 0)
            return 0;
        this.n = n;
        dp = new int [n + 1];
        for(int i = 0; i <= n; ++i)
            dp[i] = -1;
        dp[0] = 1;
        return dfs(n);
    }
    private int dfs(int x){
        if(dp[x] != -1){
            return dp[x];
        }
        dp[x] = 0;
        for(int i = 1; i <= x; ++i){
            dp[x] += dfs(i - 1) * dfs(x - i);
        }
        return dp[x];
    }
    private int [] dp;
    private int n;
}
