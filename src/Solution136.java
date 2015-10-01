/**
 * Created by slgu1 on 9/23/15.
 */

public class Solution136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i)
            res ^= nums[i];
        return res;
    }
}
