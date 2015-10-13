/**
 * Created by slgu1 on 10/7/15.
 */
public class Solution153 {
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
            if (m == l) {
                if (minn > nums[l])
                    minn = nums[l];
                if (minn > nums[r])
                    minn = nums[r];
                break;
            }
            if (nums[m] > nums[l]) {
                l = m + 1;
                if (minn > nums[l])
                    minn = nums[l];
            }
            else {
                if (minn > nums[m])
                    minn = nums[m];
                r = m - 1;
            }
        }
        return minn;
    }
    public static void main(String [] args) {
        Solution153 a = new Solution153();
        System.out.println(a.findMin(new int[]{4,5,6,7,0, 1, 2}));
    }
}
