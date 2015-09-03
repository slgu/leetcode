/**
 * Created by slgu1 on 9/3/15.
 */
public class Solution91 {
    public int numDecodings(String s) {
        n = s.length();
        if(n == 0){
            return 0;
        }
        this.s = s;
        dp = new int[n];
        for(int i = 0; i < n; ++i)
            dp[i] = -1;
        if(s.charAt(n - 1) == '0'){
            dp[n - 1] = 0;
        }else {
            dp[n - 1] = 1;
        }
        return dfs(0);

    }
    private int dfs(int x){
        if(x >= n)
            return 1;
        if(dp[x] != -1)
            return dp[x];
        int num1 = s.charAt(x) - '0';
        if(num1 == 0)
            return dp[x] = 0;
        dp[x] = 0;
        dp[x] += dfs(x + 1);
        int num2 = s.charAt(x + 1) - '0';
        if(num1 * 10 + num2 <= 26)
            dp[x] += dfs(x + 2);
        return dp[x];
    }
    private int [] dp;
    private int n;
    private String s;
    public static void main(String [] args){
        Solution91 a = new Solution91();
        System.out.println(a.numDecodings("12"));
    }
}
