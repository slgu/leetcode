/**
 * Created by slgu1 on 10/6/15.
 */
import util.Point;

import java.util.HashMap;
import java.util.Map;

public class Solution149 {
    public int maxPoints(Point[] points) {
        int n = points.length;
        //special judge
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        HashMap <Double, Integer> mp = new HashMap<Double, Integer>();
        int maxn = 1;
        for (int i = 0; i < n; ++i) {
            mp.clear();
            int same = 0;
            int x_straight = 0;
            int tmp_maxn = 0;
            for (int j = i + 1; j < n; ++j) {
                //same
                if (points[j].x == points[i].x && points[j].y == points[i].y)
                    ++same;
                else if (points[j].x == points[i].x)
                    ++x_straight;
                else {
                    double skew = 1.0 * (points[j].y - points[i].y) / (points[j].x - points[i].x);
                    // 0.0 and -0.0 problem
                    if (skew == -0.0)
                        skew = 0.0;
                    if (mp.containsKey(skew)) {
                        //update
                        if (mp.get(skew) + 1 > tmp_maxn) {
                            tmp_maxn = mp.get(skew) + 1;
                        }
                        mp.put(skew, mp.get(skew) + 1);
                    }
                    else {
                        if (tmp_maxn == 0)
                            tmp_maxn = 1;
                        mp.put(skew, 1);
                    }
                }
            }
            if (tmp_maxn < x_straight)
                tmp_maxn = x_straight;
            tmp_maxn += same;
            if (maxn < tmp_maxn)
                maxn = tmp_maxn;
        }
        return maxn + 1;
    }
    public static void main(String [] args) {
        Solution149 a = new Solution149();
        Point [] b = new Point[3];
        b[0] = new Point(2,3);
        b[1] = new Point(3,3);
        b[2] = new Point(-5,3);
        System.out.println(a.maxPoints(b));
    }
}