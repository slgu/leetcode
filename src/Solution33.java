/**
 * Created by gsl on 7/6/15.
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int middle = (left + right) >> 1;
            if(nums[middle] == target)
                return middle;
            if(nums[middle] > target){
                if(nums[middle] >= nums[0]) {
                    if(target >= nums[0])
                        right = middle - 1;
                    else
                        left = middle + 1;
                }
                else{
                    right = middle - 1;
                }
            }
            else{
                if(nums[middle] >= nums[0]){
                    left = middle + 1;
                }
                else{
                    if(nums[n - 1] >= target)
                        left = middle + 1;
                    else
                        right = middle - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String [] args){
        Solution33 a = new Solution33();
        //System.out.println(a.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(a.search(new int[]{3,5,1}, 3));
    }
}
