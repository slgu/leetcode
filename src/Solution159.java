/**
 * Created by slgu1 on 10/23/15.
 */
public class Solution159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0)
            return 0;
        int [] lastpos = new int[300];
        for (int i = 0; i < 300; ++i)
            lastpos[i] = -1;
        int n = s.length();
        int maxn = 1;
        int start = 0;
        lastpos[s.charAt(0)] = 0;
        int idx2 = -1;
        int idx1 = s.charAt(0);
        int cntDiff = 1;
        for (int i = 1; i < n; ++i) {
            int idx = s.charAt(i);
            if (lastpos[idx] == -1 && cntDiff == 2) {
                if (lastpos[idx1] > lastpos[idx2]) {
                    start = lastpos[idx2] + 1;
                    lastpos[idx2] = -1;
                    idx2 = idx;
                }
                else {
                    start = lastpos[idx1] + 1;
                    lastpos[idx1] = -1;
                    idx1 = idx;
                }
                lastpos[idx] = i;
            }
            else {
                if (lastpos[idx] == -1) {
                    ++cntDiff;
                    idx2 = idx;
                }
                lastpos[idx] = i;
            }
            if (maxn < i - start + 1)
                maxn = i - start + 1;
        }
        return maxn;
    }
    public static void main(String [] args) {
        Solution159 a = new Solution159();
        System.out.println(a.lengthOfLongestSubstringTwoDistinct("abcabcabc"));
    }
}
