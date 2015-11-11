/**
 * Created by slgu1 on 11/11/15.
 */
/* TODO */
public class Solution214 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1)
            return new String(s);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            builder.append("_");
            builder.append(s.charAt(i));
        }
        builder.append("_");
        String another_s = builder.toString();
        n = another_s.length();
        int [] dp = new int[n];
        dp[0] = 1;
        int last_idx = 0;
        int last_maxn = 1;
        for (int i = 1; i < n; ++i) {
            if (last_idx + last_maxn - 1 > i) {
                int map_i = 2 * last_idx - i;
                int cnt = last_idx + last_maxn - 1 - i;
                if (cnt > dp[map_i] - 1)
                    cnt = dp[map_i] - 1;
                while (i + cnt < n && i - cnt > 0) {
                    if (another_s.charAt(i + cnt) == another_s.charAt(i - cnt))
                        ++cnt;
                    else
                        break;
                }
                dp[i] = cnt;
                if (i + cnt > last_idx + last_maxn) {
                    last_idx = i;
                    last_maxn = cnt;
                }
            }
            else {
                int cnt = 1;
                while (i + cnt < n && i - cnt >= 0) {
                    if (another_s.charAt(i + cnt) == another_s.charAt(i - cnt))
                        ++cnt;
                    else
                        break;
                }
                dp[i] = cnt;
                last_idx = i;
                last_maxn = cnt;
            }
        }
        int maxn = 1;
        for (int i = 0; i < n; ++i) {
            if (another_s.charAt(i) == '_') {
                if ((i + 1) / 2 == dp[i] / 2) {
                    if (maxn < dp[i] / 2 * 2)
                        maxn = dp[i] / 2 * 2;
                }
            }
            else {
                if ((i + 1) / 2 == 1 + (dp[i] - 1) / 2) {
                    if (maxn < (i + 1) / 2 * 2 - 1)
                        maxn = (i + 1) / 2 * 2 - 1;
                }
            }
        }
        n = s.length();
        builder = new StringBuilder();
        for (int j = n - 1; j >= maxn; --j)
            builder.append(s.charAt(j));
        builder.append(s);
        return builder.toString();
    }
    public static void main(String [] args) {
        Solution214 a = new Solution214();
        System.out.println(a.shortestPalindrome("abcd"));
    }
}
