/**
 * Created by slgu1 on 9/19/15.
 */
import util.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution114 {
    public void flatten(TreeNode root) {
        adjust(root);
    }
    private TreeNode adjust(TreeNode node) {
        if (node == null)
            return null;

        TreeNode leftadjust = adjust(node.left);
        TreeNode rightadjust = adjust(node.right);
        TreeNode ret = node;
        if (node.left == null) {
            if (rightadjust == null) {
                ret = node;
            }
            else {
                ret = rightadjust;
            }
        }
        else {
            TreeNode lnode = node.left;
            TreeNode rnode = node.right;
            node.right = lnode;
            node.left = null;
            leftadjust.right = rnode;
            if (rnode == null) {
                ret = leftadjust;
            }
            else {
                ret = rightadjust;
            }
        }
        return ret;
    }
    public static void main(String [] args) {
        Solution114 a = new Solution114();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(3);
        a.flatten(node);
        TreeNode.debug(node);
    }
}
