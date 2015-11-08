public class Solution248 {
    private int judge_l (int number) {
        if (number > 8)
            return 3;
        if (number > 1)
            return 2;
        if (number > 0)
            return 1;
        return 0;
    }
    private int judge_le (int number) {
        if (number >= 8)
            return 3;
        if (number >= 1)
            return 2;
        if (number >= 0)
            return 1;
        return 0;
    }
    private int maxn_num(int x, int y) {
        if (x > y)
            return 1;
        return maxn[y - x][1];
    }
    private int lower_num (String high, boolean flg) {
        if (high.equals("0")) {
            if (flg)
                return 1;
            else
                return 0;
        }
        int n = high.length();
        int total = 0;
        if (n >= 2)
            total = total + sum[n - 2];
        return total + lower_num_dfs(high, 0, n - 1, flg);
    }
    /* true <= false < */
    private int lower_num_dfs (String high, int x, int y, boolean flg) {
        int int_flg = flg?1:0;
        if (x > y)
            return int_flg;
        if (dp[x][int_flg] != -1)
            return dp[x][int_flg];
        int total = 0;
        int x_num = high.charAt(x) - '0';
        int y_num = high.charAt(y) - '0';
        int x_l = judge_l(x_num);
        int x_le = judge_le(x_num);
        if (x == y) {
            if (flg)
                return dp[x][int_flg] = x_le;
            else
                return dp[x][int_flg] = x_l;
        }
        if (x == 0) {
            --x_l;
            --x_le;
        }
        if (x_l == x_le) {
            total = total + x_l * maxn_num(x + 1, y - 1);
        }
        else {
            total = total + x_l * maxn_num(x + 1, y - 1);
            if (y_num > x_num)
                total = total + lower_num_dfs(high, x + 1, y - 1, true);
            else if (y_num == x_num) {
                total = total + lower_num_dfs(high, x + 1, y - 1, flg);
            }
            else {
                total = total + lower_num_dfs(high, x + 1, y - 1, false);
            }
        }
        if (x_num > 6)
            total = total + maxn_num(x + 1, y - 1);
        else if (x_num == 6){
            if (y_num == 9) {
                total = total + lower_num_dfs(high, x + 1, y - 1, flg);
            }
        }
        if (x_num == 9) {
            if (y_num > 6)
                total = total + lower_num_dfs(high, x + 1, y - 1, true);
            else if (y_num == 6)
                total = total + lower_num_dfs(high, x + 1, y - 1, flg);
        }
        return dp[x][int_flg] = total;
    }
    public int strobogrammaticInRange(String low, String high) {
        int n1 = high.length();
        int n2 = low.length();
        maxn = new int[n1][2];
        sum = new int[n1];
        maxn[0][0] = maxn[0][1] = 3;
        if (n1 > 1) {
            maxn[1][0] = 4;
            maxn[1][1] = 5;
        }
        for (int i = 2; i < n1; ++i) {
            maxn[i][0] = maxn[i - 2][1] * 4;
            maxn[i][1] = maxn[i - 2][1] * 5;
        }
        sum[0] = maxn[0][0];
        for (int i = 1; i < n1; ++i)
            sum[i] = maxn[i][0] + sum[i - 1];
        dp = new int[n1][2];
        for (int i = 0; i < n1; ++i)
            for (int j = 0; j < 2; ++j)
                dp[i][j] = -1;
        int num1 = lower_num(high, true);
        dp = new int[n2][2];
        for (int i = 0; i < n2; ++i)
            for (int j = 0; j < 2; ++j)
                dp[i][j] = -1;
        int num2 = lower_num(low, false);
        System.out.println(num1);
        System.out.println(num2);
        if (num1 > num2)
            return num1 - num2;
        else
            return 0;
    }
    private int [][] maxn;
    private int [] sum;
    private int [][]dp;
    public static void main(String [] args) {
        Solution248 a = new Solution248();
        System.out.println(a.strobogrammaticInRange("1001","11111"));
    }
}