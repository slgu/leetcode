import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/17/15.
 */

import java.sql.Array;
import java.util.*;
public class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0){
            ArrayList <Interval> result = new ArrayList<Interval>();
            result.add(newInterval);
            return result;
        }
        int n = intervals.size();
        //special judge
        if(newInterval.end < intervals.get(0).start){
            ArrayList <Interval> result = new ArrayList<Interval>(Arrays.asList(new Interval[n]));
            Collections.copy(result,intervals);
            result.add(0, newInterval);
            return result;
        }
        if(newInterval.start > intervals.get(n - 1).end){
            ArrayList <Interval> result = new ArrayList<Interval>(Arrays.asList(new Interval[n]));
            Collections.copy(result,intervals);
            result.add(newInterval);
            return result;
        }
        int l = 0;
        int r = n - 1;
        int l_pos = -1;
        int r_pos = -1;
        while(l < r){
            int m = (l + r) >> 1;
            Interval m_interval = intervals.get(m);
            if(newInterval.start > m_interval.end){
               l = m + 1;
            }
            else if (newInterval.start < m_interval.start){
                r = m;
            }
            else{
                l_pos = m;
                break;
            }
        }
        if(l_pos == -1)
            l_pos = r;
        l = 0;
        r = n - 1;
        while(l < r){
            int m = (l + r + 1) >> 1;
            Interval m_interval = intervals.get(m);
            if(newInterval.end > m_interval.end){
                l = m;
            }
            else if (newInterval.end < m_interval.start){
                r = m - 1;
            }
            else{
                r_pos = m;
                break;
            }
        }
        if(r_pos == -1)
            r_pos = l;
        l_pos = Math.min(l_pos,n - 1);
        l_pos = Math.max(0, l_pos);
        r_pos = Math.min(r_pos, n - 1);
        r_pos = Math.max(0, r_pos);
        List <Interval> result_list = new ArrayList<Interval>();
        for(int i = 0; i < l_pos; ++i){
            result_list.add(intervals.get(i));
        }
        l = Math.min(newInterval.start, intervals.get(l_pos).start);
        r = Math.max(newInterval.end, intervals.get(r_pos).end);
        result_list.add(new Interval(l,r));
        for(int i = r_pos + 1; i < n; ++i)
            result_list.add(intervals.get(i));
        return result_list;
    }
    public static void main(String[] args) {
        Solution57 a = new Solution57();
        List <Interval> b = new ArrayList<Interval>();
        b.add(new Interval(1,5));
        Interval c = new Interval(5,7);
        System.out.println(a.insert(b, c));
    }
}
