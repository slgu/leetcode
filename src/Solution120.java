/**
 * Created by slgu1 on 9/19/15.
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        if(n == 0)
            return 0;
        dp = new int [n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                dp[i][j] = -1;
        this.triangle = triangle;
        return dfs(0,0);
    }
    public static void main(String [] args) {
        Solution120 a = new Solution120();
        List <Integer> a1 = Arrays.asList(new Integer[] {2});
        List <Integer> a2 = Arrays.asList(new Integer[] {3,4});
        List <Integer> a3 = Arrays.asList(new Integer[] {6,5,7});
        List <Integer> a4 = Arrays.asList(new Integer[] {4,1,8,3});
        List < List <Integer> > triangle = new LinkedList<List<Integer>>();
        triangle.add(a1);
        triangle.add(a2);
        triangle.add(a3);
        triangle.add(a4);
        System.out.println(a.minimumTotal(triangle));
    }
    private int [][] dp;
    private List <List <Integer>> triangle;
    private int dfs(int i, int j){
        if (dp[i][j] != -1)
            return dp[i][j];

        int res = triangle.get(i).get(j);
        if (i + 1 < n) {
            int lsum = dfs(i + 1, j);
            int rsum = dfs(i + 1, j + 1);
            if (lsum > rsum)
                return dp[i][j] = res + rsum;
            else
                return dp[i][j] = res + lsum;
        }
        else
            return dp[i][j] = res;
    }
    private int n;
}
