import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/17/15.
 */

import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    public String toString(){
        return String.format("[%d,%d]",start,end);
    }
}
public class Solution56 {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0){
            return new ArrayList<Interval>();
        }
        //sort intervals by start point
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval t1, Interval t2) {
                if(t1.start == t2.start){
                    if(t1.end == t2.end){
                        return 0;
                    }
                    else if(t1.end < t2.end){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
                else if(t1.start < t2.start){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
        List <Interval> result = new ArrayList<Interval>();
        int st = -1;
        int ed = -1;
        for(Interval item: intervals){
            if(st == -1){
                st = item.start;
                ed = item.end;
            }
            else{
                if(ed >= item.start){
                    if(ed < item.end)
                        ed = item.end;
                }
                else{
                    result.add(new Interval(st,ed));
                    st = item.start;
                    ed = item.end;
                }
            }
        }
        if(st != -1) {
            result.add(new Interval(st, ed));
        }
        return result;
    }
    public static void main(String[] args) {
        Solution56 a = new Solution56();
        List <Interval> b = new ArrayList<Interval>();
        b.add(new Interval(1,3));
        b.add(new Interval(2,6));
        b.add(new Interval(8,10));
        b.add(new Interval(15,18));
        System.out.println(a.merge(b));
    }
}
