import java.util.ArrayList;

/**
 * Created by gsl on 7/6/15.
 */
public class Solution31 {
    public static void printarray(int [] nums){
        for(int item:nums){
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println("");
    }
    //reverse array
    public static void reverse(int [] nums, int i, int j){
        while(i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            ++i;
            --j;
        }
    }
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1)
            return;
        int n = nums.length;
        //back-forward
        for(int i = n - 2; i >= 0; --i){
            if(nums[i] >= nums[i + 1]) continue;
            //insert i
            int j;
            for(j = i + 1; j < n; ++j) {
                if (nums[j] <= nums[i]) break;
            }
            int tmp = nums[j - 1];
            nums[j - 1] = nums[i];
            nums[i] = tmp;
            reverse(nums, i + 1, n - 1);
            return;
        }
        //no next so swap to get begin
        reverse(nums, 0, n - 1);
    }
    public static void main(String [] args){
        int [] nums = {1,3,4,5,5,7,6,5,3,2,1};
        int [] nums2 = {1,3};
        int [] nums3 = {3,1};
        Solution31 a = new Solution31();
        a.nextPermutation(nums);
        a.nextPermutation(nums2);
        a.nextPermutation(nums3);
        printarray(nums);
        printarray(nums2);
        printarray(nums3);
    }
}
