/**
 * Created by gsl on 7/16/15.
 */

import java.util.*;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return true;
        if(nums[0] == 0)
            return false;
        int far = -1;
        for(int i = 0; i < n - 1; ++i){
            if(far == -1 || far >= i){
                if(nums[i] > 0){
                    if(far < i + nums[i]) {
                        far = i + nums[i];
                        if(far >= n - 1)
                            return true;
                    }
                }
            }
            else
                return false;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new Solution55().canJump(new int []{3,2,1,0,4}));
    }
}
