import javax.annotation.processing.SupportedSourceVersion;

/**
 * Created by slgu1 on 10/27/15.
 */
public class Solution215 {
    int find(int i, int j, int k) {
        if (i == j)
            return nums[i];
        //partion
        int x = i + 1;
        int y = j;
        int changepos = 0;
        while (x < y) {
            while (x < y && nums[x] <= nums[i])
                ++x;
            while (x < y && nums[y] >= nums[i])
                --y;
            if (x < y) {
                int tmp = nums[x];
                nums[x] = nums[y];
                nums[y] = tmp;
                ++x;
                --y;
            }
        }
        changepos = x;
        if (nums[changepos] > nums[i])
            --changepos;
        int tmp = nums[i];
        nums[i] = nums[changepos];
        nums[changepos] = tmp;
        if (k == j - changepos + 1)
            return nums[changepos];
        else if (k > j - changepos + 1)
            return find(i, changepos - 1, k - (j - changepos + 1));
        else
            return find(changepos + 1, j, k);
    }
    public int findKthLargest(int[] nums, int k) {
        n = nums.length;
        this.nums = nums;
        return find(0, n - 1, k);
    }
    public static void main(String [] args) {
        Solution215 a = new Solution215();
        System.out.println(a.findKthLargest(new int[]{2,1},1));
        System.out.println(a.findKthLargest(new int[]{3,3,3,3,4,3,3,3,3}, 5));
    }
    private int [] nums;
    private int n;
}
