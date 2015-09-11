/**
 * Created by slgu1 on 9/4/15.
 */
import sun.awt.image.ImageWatched;
import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        return construct(1, n);
    }

    private TreeNode clonetree(TreeNode head){
        if(head == null) return null;
        TreeNode clonehead = new TreeNode(head.val);
        clonehead.left = clonetree(head.left);
        clonehead.right = clonetree(head.right);
        return clonehead;
    }

    private LinkedList<TreeNode> construct(int l, int r){
        if(l == r){
            LinkedList <TreeNode> result = new LinkedList<TreeNode>();
            result.add(new TreeNode(l));
            return result;
        }

        if(l > r){
            LinkedList <TreeNode> result = new LinkedList<TreeNode>();
            result.add(null);
            return result;
        }

        //result
        LinkedList <TreeNode> result = new LinkedList<TreeNode>();
        for(int center = l; center <= r; ++center){
            LinkedList <TreeNode> left_combine = construct(l, center - 1);
            LinkedList <TreeNode> right_combine = construct(center + 1, r);
            for(TreeNode lnode: left_combine){
                for(TreeNode rnode: right_combine){
                    //clone l r
                    TreeNode clonel = clonetree(lnode);
                    TreeNode cloner = clonetree(rnode);
                    TreeNode head = new TreeNode(center);
                    head.left = clonel;
                    head.right = cloner;
                    result.add(head);
                }
            }
        }
        return result;
    }
}
