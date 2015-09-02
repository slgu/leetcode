import util.ListNode;
import util.ListUtil;
/**
 * Created by slgu1 on 8/28/15.
 */
import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    //step forward
    void dfs(int x, int acc) {
        if(acc == k){
            //end shallow copy
            all_stack_result.add((List <Integer> )stack_result.clone());
            return;
        }
        if(x > n) {
            return;
        }
        stack_result.addLast(x);
        dfs(x + 1, acc + 1);
        stack_result.removeLast();
        dfs(x + 1, acc);
    }
    public List<List<Integer>> combine(int n, int k) {
        //clear stack_result;
        stack_result.clear();
        all_stack_result.clear();
        //set n, k
        this.n = n;
        this.k = k;
        //step forward
        dfs(1, 0);
        return all_stack_result;
    }

    private LinkedList <Integer> stack_result = new LinkedList<Integer>();//store result
    private LinkedList < List <Integer> > all_stack_result = new LinkedList<List<Integer>>();//all result
    private int n;
    private int k;
    public static void main(String [] args){
        System.out.println(new Solution77().combine(0,1));
    }
}
