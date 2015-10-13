/**
 * Created by slgu1 on 10/12/15.
 */
public class Solution154 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        int l = 0, r = n - 1;
        int minn = nums[0];
        while (l <= r) {
            int m = (l + r) >> 1;
            if (nums[m] > nums[l]) {
                if (nums[l] < minn)
                    minn = nums[l];
                l = m + 1;
            }
            else if (nums[m] < nums[l]) {
                if (nums[m] < minn)
                    minn = nums[m];
                r = m - 1;
            }
            else {
                if (nums[l] < minn)
                    minn = nums[l];
                ++l;
            }
        }
        return minn;
    }
    public static void main(String [] args) {
        Solution154 a = new Solution154();
        System.out.println(a.findMin(new int[]{5,5,5,5,5,5,5,5,5,0}));
    }
}