/**
 * Created by slgu1 on 9/30/15.
 */
import java.util.HashSet;
import java.util.Set;
public class Solution139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict.contains(s))
            return true;
        if (s.equals(""))
            return false;
        n = s.length();
        dp = new int[n + 1];
        dp[n] = 1;
        for (int i = 0; i < n; ++i)
            dp[i] = -1;
        return dfs(s, wordDict, 0);
    }
    public static void main(String... args) {
        Set <String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        System.out.println(new Solution139().wordBreak("leetcode", dict));
    }
    private boolean dfs(String s, Set <String> wordDict, int i) {
        if (dp[i] != -1)
            return dp[i] == 1;
        for (int j = i; j < n; ++j) {
            if (wordDict.contains(s.substring(i, j + 1).toString()) && dfs(s, wordDict, j + 1)) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
    private int [] dp;
    private int n;
}
