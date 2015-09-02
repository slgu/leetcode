import util.ListNode;
import util.ListUtil;
import java.util.ArrayList;

/**
 * Created by gsl on 7/6/15.
 */
public class Solution34 {
    public int low_find(int [] nums, int target){
        int n = nums.length;
        if(nums[0] == target) return 0;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int middle = (left + right + 1) >> 1;
            if(nums[middle] < target)
                left = middle;
            else{
                right = middle - 1;
            }
        }
        if(left + 1 < n && nums[left + 1] == target)
            return left + 1;
        return -1;
    }
    public  int high_find(int [] nums, int target){
        int n = nums.length;
        if(nums[n - 1] == target) return n - 1;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int middle = (left + right) >> 1;
            if(nums[middle] > target)
                right = middle;
            else{
                left = middle + 1;
            }
        }
        if(right - 1 >= 0 && nums[right - 1] == target)
            return right - 1;
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int left = low_find(nums,target);
        if(left == -1)
            return new int[]{-1,-1};
        int right = high_find(nums, target);
        int [] result = {left,right};
        return result;
    }
    public static void main(String [] args){
        Solution34 a = new Solution34();
        for(int item:a.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)){
            System.out.print(item);
            System.out.print(' ');
        }
        System.out.println("");
    }
}
