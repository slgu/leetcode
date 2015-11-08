import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by slgu1 on 10/28/15.
 */
public class Solution253 {
    static class Pair implements Comparable <Pair> {
        int idx;
        boolean inOutFlag;
        Pair(int idx, boolean inOutFlag) {
            this.idx = idx;
            this.inOutFlag = inOutFlag;
        }

        @Override
        public int compareTo(Pair o) {
            if (idx < o.idx)
                return -1;
            else if (idx == o.idx) {
                if (inOutFlag == o.inOutFlag)
                    return 0;
                if (inOutFlag)
                    return -1;
            }
            return 1;
        }

    }
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0)
            return 0;
        int n = intervals.length;
        Pair [] pairs = new Pair[2 * n];
        for (int i = 0; i < n; ++i) {
            pairs[2 * i] = new Pair(intervals[i].start, false);
            pairs[2 * i + 1] = new Pair(intervals[i].end, true);
        }
        Arrays.sort(pairs);
        int cnt = 0;
        int maxn = 0;
        for (int i = 0; i < 2 * n; ++i) {
            if (pairs[i].inOutFlag)
                --cnt;
            else
                ++cnt;
            if (cnt > maxn)
                maxn = cnt;
        }
        return maxn;
    }
    public static void main(String [] args) {
        Solution253 a = new Solution253();
        System.out.println(a.minMeetingRooms(new Interval[]{
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(9, 20)
        }));
    }
}
