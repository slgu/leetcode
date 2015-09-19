/**
 * Created by slgu1 on 9/16/15.
 */

import util.TreeNode;
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        result = 0;
        if(root == null) return 0;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode node, int now){
        if(node == null)
            return;
        //leaf node
        if(node.left == null && node.right == null){
            result += 10 * now + node.val;
        }
        dfs(node.left, 10 * now + node.val);
        dfs(node.right, 10 * now + node.val);
    }
    private int result;
}
