import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/11/15.
 */

import java.lang.reflect.Array;
import java.util.*;

public class Solution47 {
    public static void swap(int [] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void reverse(int [] nums, int x, int y) {
        while (x < y) {
            swap(nums, x, y);
            ++x;
            --y;
        }
    }
    public static boolean next_permution(int [] input){
        int n = input.length;
        for(int i = n - 2; i >= 0; --i)
            if(input[i] < input[i + 1]){
                for(int j = i + 1; j < n; ++j)
                    if(input[i] >= input[j]){
                        swap(input, i, j - 1);
                        reverse(input, i + 1, n - 1);
                        return true;
                    }
                swap(input, i, n - 1);
                reverse(input, i + 1, n - 1);
                return true;
            }
        return false;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        ArrayList < List<Integer> > result_permutions = new ArrayList<List<Integer>>();
        do{
            List <Integer> tmp = new ArrayList<Integer>();
            for(int item:nums){
                tmp.add(item);
            }
            result_permutions.add(tmp);
        }while(next_permution(nums));
        return result_permutions;
    }
    public static void main(String[] args) {
        Solution47 a = new Solution47();
        System.out.println(a.permuteUnique(new int[]{1,1,2}));
    }
}
