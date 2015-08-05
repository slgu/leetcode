/**
 * Created by gsl on 7/7/15.
 */
import java.util.*;
public class Solution40 {
    private ArrayList < List <Integer> >result;
    private LinkedList<Integer> stack = new LinkedList<Integer>();
    void dfs(int x, int n, int []candidates, int target,int now_sum){
        if(now_sum > target) return;
        if(now_sum == target){
            //deep copy
            LinkedList <Integer> result_item = new LinkedList<Integer>(Arrays.asList(new Integer[stack.size()]));
            Collections.copy(result_item, stack);
            result.add(result_item);
            return;
        }
        if(x >= n)
            return;
        stack.push(candidates[x]);
        dfs(x + 1, n, candidates, target, now_sum + candidates[x]);
        stack.pop();
        while(x + 1 < n && candidates[x + 1] == candidates[x]) {
            ++x;
        }
        dfs(x + 1, n, candidates, target, now_sum);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        dfs(0, n, candidates, target, 0);
        return result;
    }
    public static void main(String [] args){
        Solution40 a = new Solution40();
        System.out.println(a.combinationSum2(new int[]{10, 1,2,7,6,1,5}, 8));
    }
}
