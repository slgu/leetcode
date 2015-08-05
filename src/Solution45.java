/**
 * Created by gsl on 7/11/15.
 */

import java.util.*;

public class Solution45 {

    public int jump(int[] nums) {
        int n = nums.length;
        int far = 0;
        int [] dp = new int [n];
        dp[0] = 0;
        for(int i = 0; i < n - 1; ++i){
            //judge update place
            for(int j = far + 1; j <= i + nums[i] && j < n; ++j)
                dp[j] = dp[i] + 1;
            if(far < i + nums[i]){
                far = i + nums[i];
            }
            //update last
            if(far == n - 1)
                break;
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Solution45 a = new Solution45();
        System.out.println(a.jump(new int[]{1,2}));
    }
}
