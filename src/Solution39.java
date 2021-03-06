import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/7/15.
 */
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.*;

public class Solution39 {
    private ArrayList < List <Integer> >result;
    private LinkedList<Integer> stack = new LinkedList<Integer>();
    void dfs(int x, int n, int []candidates, int target,int now_sum){
        if(x >= n)
            return;
        if(now_sum > target) return;
        if(now_sum == target){
            //deep copy
            LinkedList <Integer> result_item = new LinkedList<Integer>(Arrays.asList(new Integer[stack.size()]));
            Collections.copy(result_item, stack);
            result.add(result_item);
            return;
        }
        stack.push(candidates[x]);
        dfs(x, n, candidates, target, now_sum + candidates[x]);
        stack.pop();
        dfs(x + 1, n, candidates, target, now_sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //sort array
        Arrays.sort(candidates);
        int l = 0;
        int r = candidates.length - 1;
        while(l < r){
            int tmp = candidates[l];
            candidates[l] = candidates[r];
            candidates[r] = tmp;
            ++l;
            --r;
        }
        //new result
        result = new ArrayList<List<Integer>>();
        //clear stack
        stack.clear();
        int n = candidates.length;
        dfs(0, n, candidates, target,0);
        System.out.println(result);
        return result;
    }
    public static void main(String[] args){
        Solution39 a = new Solution39();
        System.out.println(a.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
