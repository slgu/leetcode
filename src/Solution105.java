/**
 * Created by slgu1 on 9/15/15.
 */
import util.TreeNode;
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //init
        this.preorder = preorder;
        this.inorder = inorder;
        this.n1 = preorder.length;
        if(n1 == 0){
            return null;
        }
        return buildNode(0, n1 - 1, 0, n1 - 1);
    }
    private TreeNode buildNode(int l1, int r1, int l2, int r2){
        if(l1 > r1)
            return null;
        for(int i = l2; i <= r2; ++i){
            if(inorder[i] == preorder[l1]){
                TreeNode node = new TreeNode(inorder[i]);
                node.left = buildNode(l1 + 1,i + l1 - l2, l2, i - 1);
                node.right = buildNode(i + l1 - l2 + 1, r1, i + 1, r2);
                return node;
            }
        }
        return null;
    }
    private int [] preorder;
    private int [] inorder;
    private int n1;
}
