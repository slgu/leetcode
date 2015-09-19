/**
 * Created by slgu1 on 9/19/15.
 */
import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        result.clear();
        stack_data.clear();
        if(root == null){
            return result;
        }
        dfs(root, 0);
        return result;
    }

    void dfs(TreeNode node, int val) {
        //judge leaf
        if (node.left == null && node.right == null){
            if (node.val + val == this.sum) {
                stack_data.addLast(node.val);
                result.add((List<Integer>) stack_data.clone());
                stack_data.removeLast();
                return;
            }
        }

        stack_data.addLast(node.val);
        if (node.left != null)
            dfs(node.left, val + node.val);
        if (node.right != null)
            dfs(node.right, val + node.val);
        stack_data.removeLast();
    }
    private int sum;
    private List < List <Integer> > result = new LinkedList<List<Integer>>();
    private LinkedList <Integer> stack_data = new LinkedList<Integer>();
}
