/**
 * Created by slgu1 on 10/23/15.
 */
import java.util.LinkedList;
import java.util.List;
public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        --lower;
        ++upper;
        int last = lower;
        LinkedList <String> result = new LinkedList<String>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if(nums[i] > last + 1) {
                if (nums[i] - last == 2) {
                    result.add(String.valueOf(last + 1));
                }
                else {
                    result.add(String.valueOf(last + 1) + "->" + String.valueOf(nums[i] - 1));
                }
            }
            last = nums[i];
        }
        if (upper - last >= 2) {
            if (upper - last == 2)
                result.add(String.valueOf(last + 1));
            else
                result.add(String.valueOf(last + 1) + "->" + String.valueOf(upper - 1));
        }
        return result;
    }
    public static void main(String [] args) {
        Solution163 a = new Solution163();
        System.out.println(a.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    }
}
