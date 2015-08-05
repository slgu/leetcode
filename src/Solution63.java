/**
 * Created by gsl on 7/19/15.
 */

import java.util.*;

//DP
//down or right so a status is just got by last two status
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if(n == 0)
            return 0;
        int m = obstacleGrid[0].length;
        if(m == 0)
            return 0;
        int dp[][] = new int[n][m];
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1)
            return 0;
        dp[0][0] = 1;
        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if(i == 0 && j == 0)
                    continue;
                dp[i][j] = 0;
                //useless pos
                if(obstacleGrid[i][j] == 1)
                    continue;
                if(j != 0 && obstacleGrid[i][j - 1] == 0)
                    dp[i][j] += dp[i][j - 1];
                if(i != 0 && obstacleGrid[i - 1][j] == 0)
                    dp[i][j] += dp[i - 1][j];
            }
        }
        return dp[n - 1][m - 1];
    }
    public static void main(String[] args) {
        Solution63 a = new Solution63();
        System.out.println(a.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }
}
