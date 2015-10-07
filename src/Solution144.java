/**
 * Created by slgu1 on 10/2/15.
 */
import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new LinkedList<Integer>();
        Stack <TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List <Integer> result = new LinkedList<Integer>();
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
        return result;
    }
}
