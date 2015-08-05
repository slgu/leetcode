/**
 * Created by gsl on 7/3/15.
 */

import java.util.*;
public class Solution18 {
    static int fuck(int a, int b, int c, int d){
        return a * 121 * 11  + b * 121 + c * 11 + d;
    }
    public List< List<Integer> > fourSum(int[] nums, int target) {
        //sort nums
        Arrays.sort(nums);
        int n = nums.length;
        Set <Integer> valid_set = new HashSet<Integer>();
        List <List <Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < n - 3; ++i)
            for(int j = i + 1; j < n - 2; ++j){
                int res = target - nums[i] - nums[j];
                //cut
                if(nums[j + 1] + nums[j + 2] > res || nums[n - 1] + nums[n -2] < res)
                    continue;
                int v1 = j + 1;
                int v2 = n - 1;
                while(v1 < v2){
                    //valid combination
                    if(nums[v1] + nums[v2] == res){
                        int hash_valid = fuck(nums[i],nums[j],nums[v1], nums[v2]);
                        if(valid_set.contains(hash_valid)) {
                            ++v1;
                            --v2;
                            continue;
                        }
                        valid_set.add(hash_valid);
                        List <Integer> result_item = new ArrayList<Integer>();
                        result_item.add(nums[i]);
                        result_item.add(nums[j]);
                        result_item.add(nums[v1]);
                        result_item.add(nums[v2]);
                        //insert result
                        result.add(result_item);
                        ++v1;
                        --v2;
                    }
                    else if(nums[v1] + nums[v2] < res){
                        //forward
                        ++v1;
                    }
                    else{
                        //backward
                        --v2;
                    }
                }
            }
        return result;
    }
    public static void main(String []args){
        Solution18 a = new Solution18();
        List <List<Integer>> res = a.fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0);
        System.out.println(res);
    }
}
