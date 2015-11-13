/**
 * Created by slgu1 on 11/11/15.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;
public class Solution257 {
    private String change(Stack <Integer> st) {
        StringBuilder builder = new StringBuilder();
        Integer [] strings = new Integer[]{};
        strings = st.toArray(strings);
        for (int i = 0; i < strings.length; ++i) {
            builder.append(strings[i]);
            if (i != strings.length - 1)
                builder.append("->");
        }
        return builder.toString();
    }

    private void dfs(TreeNode node, Stack <Integer> st, LinkedList <String> resString) {
        if (node == null)
            return;
        st.add(node.val);
        if (node.left == null && node.right == null) {
            resString.add(change(st));
            st.pop();
            return;
        }
        if (node.left != null)
            dfs(node.left, st, resString);
        if (node.right != null)
            dfs(node.right, st, resString);
        st.pop();
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList <String> resString = new LinkedList<String>();
        Stack <Integer> st = new Stack<Integer>();
        dfs(root, st, resString);
        return resString;
    }
    public static void main(String [] args) {
        Solution257 a = new Solution257();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        System.out.println(a.binaryTreePaths(node));
    }
}
