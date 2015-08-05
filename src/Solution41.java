/**
 * Created by gsl on 7/7/15.
 */

import java.util.*;

//傻逼leetcode。。。题意一直说不清
public class Solution41 {
    private static void swap(int [] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0)
            return 1;
        int i = 0;
        int n = nums.length;
        while(i < n){
            if(nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
            else{
                ++i;
            }
        }
        for(i = 0; i < n; ++i)
            if(i + 1 != nums[i])
                return i + 1;
        return n + 1;
    }
    public static void main(String[] args) {
        System.out.println(new Solution41().firstMissingPositive(new int[]{1,1}));
    }
}
