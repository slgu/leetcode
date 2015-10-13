/**
 * Created by slgu1 on 10/13/15.
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return 0;
        int l = 0;
        if (nums[0] > nums[1])
            return 0;
        int r = n - 1;
        if (nums[r] > nums[r - 1])
            return r;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (m == 0) {
                ++l;
                continue;
            }
            if (m == n - 1) {
                --r;
                continue;
            }
            //return
            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1])
                return m;

            if (nums[m - 1] > nums[m]) {
                r = m - 1;
                continue;
            }

            if (nums[m + 1] > nums[m]) {
                l = m + 1;
                continue;
            }
        }
        return 0;
    }
    public static void main(String [] args) {
        Solution162 a = new Solution162();
        System.out.println(a.findPeakElement(new int[]{1, 2, 3, 1}));
    }
}
