/**
 * Created by slgu1 on 10/28/15.
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
            return 0;
        int nowsum = nums[0];
        int lastidx = 0;
        int minn = -1;
        if (nowsum > s) {
            return 1;
        }
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            nowsum += nums[i];
            while (nowsum - nums[lastidx] >= s) {
                nowsum -= nums[lastidx];
                ++lastidx;
            }
            if (nowsum >= s) {
                if (minn == -1 || minn > i - lastidx + 1)
                    minn = i - lastidx + 1;
            }
        }
        if (minn == -1)
            return 0;
        return minn;
    }
}
