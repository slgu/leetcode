/**
 * Created by slgu1 on 9/23/15.
 */
// http://www.cnblogs.com/yanliang12138/p/4536189.html
public class Solution137 {
    public int singleNumber(int[] nums) {
        final int MAX_BIT_NUM = 32;
        int [] bit = new int[MAX_BIT_NUM];
        int n = nums.length;
        for (int i = 0; i < MAX_BIT_NUM; ++i) {
            int res = 0;
            for (int j = 0; j < n; ++j) {
                res += ((nums[j] >> i) & 1);
            }
            bit[i] = res % 3;
        }
        int res = 0;
        for (int i = MAX_BIT_NUM - 1; i >= 0; --i) {
            res = (res << 1) + bit[i];
        }
        return res;
    }
}