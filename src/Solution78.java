import util.ListNode;
import util.ListUtil;
/**
 * Created by slgu1 on 8/29/15.
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Solution78 {
    //step forward
    void dfs(int i){
        if(i >= n)
            return;
        stack_result.addLast(nums[i]);
        //if add then put into all_stack result
        all_stack_result.add((List<Integer>) stack_result.clone());
        dfs(i + 1);
        stack_result.removeLast();
        dfs(i + 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        //set nums
        this.nums = nums;
        n = nums.length;
        all_stack_result.add(new LinkedList<Integer>());
        dfs(0);
        return all_stack_result;
    }
    private LinkedList<Integer> stack_result = new LinkedList<Integer>();//store result
    private LinkedList < List <Integer> > all_stack_result = new LinkedList<List<Integer>>();//all result
    private int [] nums;
    private int n;
}
