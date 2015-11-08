/**
 * Created by slgu1 on 10/23/15.
 */
import util.TreeNode;
public class Solution156 {
    private TreeNode result;
    private TreeNode dfs(TreeNode node) {
        if (node.left == null) {
            result = node;
            return node;
        }

        TreeNode res = dfs(node.left);
        res.left = node.right;
        res.right = node;
        node.left = null;
        node.right = null;
        return node;
    }
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return null;
        dfs(root);
        return result;
    }
    public static void main(String [] args) {
        Solution156 a = new Solution156();
        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);
        b.left.left = new TreeNode(4);
        b.left.right = new TreeNode(5);
        TreeNode.debug(b);
        TreeNode result = a.upsideDownBinaryTree(b);
        TreeNode.debug(result);
    }
}
