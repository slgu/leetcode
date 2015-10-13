/**
 * Created by slgu1 on 10/7/15.
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int [][] dp = new int[n][22];
        dp[0][0] = dp[0][1] = 0;
        int maxn = -1;
        if (nums[0] > 0) {
            dp[0][0] = nums[0];
            maxn = nums[0];
        }
        else if (nums[0] < 0)
            dp[0][1] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > 0) {
                if (dp[i - 1][0] !=  0)
                    dp[i][0] = dp[i - 1][0] * nums[i];
                else
                    dp[i][0] = nums[i];
                if (dp[i - 1][1] != 0)
                    dp[i][1] = dp[i - 1][1] * nums[i];
                else
                    dp[i][1] = 0;
            }
            else if (nums[i] == 0) {
                dp[i][0] = dp[i][1] = 0;
            }
            else {
                if (dp[i - 1][1] !=  0)
                    dp[i][0] = dp[i - 1][1] * nums[i];
                else
                    dp[i][0] = 0;
                if (dp[i - 1][0] != 0)
                    dp[i][1] = dp[i - 1][0] * nums[i];
                else
                    dp[i][1] = nums[i];
            }
            if (dp[i][0] > maxn)
                maxn = dp[i][0];
        }
        return maxn;
    }
    public static void main(String [] args) {
        Solution152 a = new Solution152();
        System.out.println(a.maxProduct(new int[]{0, -3}));
    }
}