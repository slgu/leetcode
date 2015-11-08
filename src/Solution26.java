/**
 * Created by slgu1 on 10/26/15.
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int n = nums.length;
        int lastidx = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            else {
                nums[++lastidx] = nums[i];
            }
        }
        return lastidx + 1;
    }
}
