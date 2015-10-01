/**
 * Created by slgu1 on 9/19/15.
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Solution120_2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0)
            return 0;
        // init last line;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                int val = triangle.get(i).get(j);
                if (dp[j] < dp[j + 1]) {
                    dp[j] = dp[j] + val;
                }
                else {
                    dp[j] = dp[j + 1] + val;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution120 a = new Solution120();
        List<Integer> a1 = Arrays.asList(new Integer[]{2});
        List<Integer> a2 = Arrays.asList(new Integer[]{3, 4});
        List<Integer> a3 = Arrays.asList(new Integer[]{6, 5, 7});
        List<Integer> a4 = Arrays.asList(new Integer[]{4, 1, 8, 3});
        List<List<Integer>> triangle = new LinkedList<List<Integer>>();
        triangle.add(a1);
        triangle.add(a2);
        triangle.add(a3);
        triangle.add(a4);
        System.out.println(a.minimumTotal(triangle));
    }
}

