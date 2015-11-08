/**
 * Created by slgu1 on 9/23/15.
 */
public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i)
            res ^= nums[i];
        final int MAX_BIT_NUM = 32;
        for (int i = 0; i < MAX_BIT_NUM; ++i) {
            if ((res & 1) != 0) {
                int [] res_arr = new int[]{0,0};
                for (int j = 0; j < n; ++j) {
                    if (((nums[j] >> i) & 1) != 0) {
                        res_arr[0] ^= nums[j];
                    }
                    else {
                        res_arr[1] ^= nums[j];
                    }
                }
                return res_arr;
            }
            res >>= 1;
        }
        return null;
    }
}
