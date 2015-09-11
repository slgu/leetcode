/**
 * Created by slgu1 on 9/4/15.
 */
//based on morris 0(1) space inorder-traverse

//TODO write in blog
import util.TreeNode;
public class Solution99_2 {
    public void recoverTree(TreeNode root) {
        TreeNode current = root;
        TreeNode pre = null;
        TreeNode now = null;
        TreeNode recoverl = null;
        TreeNode recoverr = null;
        boolean lrflg = false;
        while(current != null){
            if(current.left == null){
                pre = now;
                now = current;
                if(pre != null && pre.val > now.val){
                    if(!lrflg) {
                        recoverl = pre;
                        recoverr = now;
                        lrflg = true;
                    }
                    else{
                        recoverr = now;
                    }
                }
                current = current.right;
            }
            else{
                TreeNode left_r = current.left;
                while(left_r.right != null && left_r.right != current){
                    left_r = left_r.right;
                }
                if(left_r.right == current){
                    //clear clue
                    left_r.right = null;
                    pre = now;
                    now = current;
                    if(pre != null && pre.val > now.val) {
                        if (!lrflg) {
                            recoverl = pre;
                            recoverr = now;
                            lrflg = true;
                        } else {
                            recoverr = now;
                        }
                    }
                    //left has gone go right
                    current = current.right;
                }
                else {
                    left_r.right = current;
                    current = current.left;
                }
            }
        }
        //swap
        int tmp = recoverl.val;
        recoverl.val = recoverr.val;
        recoverr.val = tmp;
    }
    public static void main(String [] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        Solution99_2 a = new Solution99_2();
        System.out.println(TreeNode.inorderTraversal(root));
        a.recoverTree(root);
        System.out.println(TreeNode.inorderTraversal(root));
    }
}
