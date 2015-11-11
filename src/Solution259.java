import java.util.Arrays;

public class Solution259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    count += (k - j);
                    ++j;
                }
                else {
                    --k;
                }
            }
        }
        return count;
    }
    public static void main(String [] args) {
        Solution259 a = new Solution259();
        System.out.println(a.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }
}
