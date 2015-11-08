/**
 * Created by slgu1 on 10/28/15.
 */
import util.TreeNode;
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p)
            return p;
        if (root == q)
            return q;
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}
