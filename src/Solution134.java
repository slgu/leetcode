/**
 * Created by slgu1 on 9/22/15.
 */
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = 0;
        int extra = 0;
        int n = gas.length;
        for (int i = 0; i <= n - 1; ++i) {
            extra = extra + gas[i] - cost[i];
            if (extra < 0) {
                idx = i + 1;
                extra = 0;
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += gas[i];
            res -= cost[i];
        }
        if (res < 0)
            return -1;
        else
            return idx;
    }
}
