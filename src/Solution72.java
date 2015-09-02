import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 8/7/15.
 */

import java.util.*;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if(n1 == 0) return n2;
        if(n2 == 0) return n1;
        int [][]dp = new int[n1 + 1][n2 + 1];
        dp[0][1] = 1;
        dp[1][0] = 1;
        dp[0][0] = 0;
        for(int i = 1; i <= n1; ++i)
            dp[i][0] = i;
        for(int i = 1; i <= n2; ++i)
            dp[0][i] = i;
        for(int i = 0; i < n1; ++i){
            for(int j = 0; j < n2; ++j){
                int tmp = -1;
                if(word1.charAt(i) == word2.charAt(j))
                    tmp = dp[i][j];
                if(tmp == -1 || tmp > dp[i + 1][j] + 1)
                    tmp = dp[i + 1][j] + 1;
                if(tmp == -1 || tmp > dp[i][j + 1] + 1)
                    tmp = dp[i][j + 1] + 1;
                if(tmp == -1 || tmp > dp[i][j] + 1)
                    tmp = dp[i][j] + 1;
                dp[i + 1][j + 1] = tmp;
            }
        }
        return dp[n1][n2];
    }
    public static void main(String[] args) {
        Solution72 a = new Solution72();
        System.out.println(a.minDistance("sea", "ate"));
    }
}
