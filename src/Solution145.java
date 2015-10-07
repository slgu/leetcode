/**
 * Created by slgu1 on 10/2/15.
 */
import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new LinkedList<Integer>();
        LinkedList <Integer> list = new LinkedList<Integer>();
        Stack <TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if (node.left != null)
                stack.add(node.left);
            if (node.right != null)
                stack.add(node.right);
        }
        return list;
    }
}
