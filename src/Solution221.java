/**
 * Created by slgu1 on 10/28/15.
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0)
            return 0;
        int m = matrix[0].length;
        int [][]dp = new int[n][m];
        int maxn = -1;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = 1;
                if (i > 0 && dp[i - 1][j] - 1 > dp[i][j])
                    dp[i][j] = dp[i - 1][j] - 1;
                if (j > 0 && dp[i][j - 1] - 1 > dp[i][j])
                    dp[i][j] = dp[i][j - 1] - 1;
                int cnt = dp[i][j];
                while (true) {
                    if (i + cnt >= n || j + cnt >= m)
                        break;
                    boolean flg = true;
                    for (int k = 0; k < cnt + 1; ++k)
                        if (matrix[i + cnt][k + j] == '0') {
                            flg = false;
                            break;
                        }
                    if (!flg)
                        break;
                    for (int k = 0; k < cnt + 1; ++k)
                        if (matrix[k + i][j + cnt] == '0') {
                            flg = false;
                            break;
                        }
                    if (!flg)
                        break;
                    ++cnt;
                }
                if (maxn == -1 || maxn < cnt)
                    maxn = cnt;
                dp[i][j] = cnt;
            }
        if (maxn == -1)
            return 0;
        return maxn * maxn;
    }
    public static void main(String [] args) {
        Solution221 a = new Solution221();
        System.out.println(a.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}
