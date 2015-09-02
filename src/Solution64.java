import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/19/15.
 */

import java.util.*;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n == 0 || m == 0)
            return 0;
        int dp[][] = new int [n][m];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j){
                if(i == 0 && j == 0)
                    continue;;
                dp[i][j] = -1;
                if(i > 0)
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                if(j > 0 && (dp[i][j] == -1 || dp[i][j] > dp[i][j - 1] + grid[i][j]))
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
            }
        return dp[n - 1][m - 1];
    }
    public static void main(String[] args) {
    }
}
