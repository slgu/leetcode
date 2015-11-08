/**
 * Created by slgu1 on 10/23/15.
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int n =  numbers.length;
        if (n < 2)
            return new int[]{-1,-1};
        for (int i = 0; i < n; ++i) {
            int l = i + 1;
            int r = n - 1;
            while (l <= r) {
                int m = (l + r) >> 1;
                if (numbers[i] + numbers[m] == target)
                    return new int[]{i + 1, m + 1};
                else if (numbers[i] + numbers[m] > target)
                    r = m - 1;
                else
                    l = m + 1;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String [] args) {
        Solution167 a = new Solution167();
        int [] res = a.twoSum(new int[]{2, 7, 11, 15},9);
        for (int i = 0; i < res.length; ++i)
            System.out.println(res[i]);
    }
}