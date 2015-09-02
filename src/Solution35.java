import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/6/15.
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
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
        if(left == 0 && nums[0] > target) return 0;
        return left + 1;
    }
    public static void main(String [] args){
        Solution35 a = new Solution35();
        System.out.println(a.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(a.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(a.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(a.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
