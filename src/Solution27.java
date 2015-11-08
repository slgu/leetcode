/**
 * Created by slgu1 on 10/26/15.
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int idx = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                ++idx;
            }
        }
        return idx;
    }
}
