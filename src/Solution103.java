import java.util.LinkedList;
import java.util.Queue;
/**
 * Created by slgu1 on 9/15/15.
 */
import util.TreeNode;
import java.util.List;
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList <TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList <TreeNode> newqueue = new LinkedList<TreeNode>();
        if(root == null){
            return new LinkedList<List<Integer>>();
        }
        queue.add(root);
        int level = 0;
        List < List <Integer>> res = new LinkedList<List<Integer>>();
        while(!queue.isEmpty()){
            LinkedList <Integer> this_level_list = new LinkedList<Integer>();
            while(!queue.isEmpty()){
                TreeNode popnode = queue.pop();
                this_level_list.add(popnode.val);
                if(level % 2 == 1){
                    if(popnode.right != null)
                        newqueue.addFirst(popnode.right);
                    if(popnode.left != null)
                        newqueue.addFirst(popnode.left);
                }
                else{
                    if(popnode.left != null)
                        newqueue.addFirst(popnode.left);
                    if(popnode.right != null)
                        newqueue.addFirst(popnode.right);
                }
            }
            ++level;
            res.add(this_level_list);
            LinkedList <TreeNode> tmp = newqueue;
            newqueue = queue;
            queue = tmp;
        }
        return res;
    }
    public static void main(String [] args){
        Solution103 a = new Solution103();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(a.zigzagLevelOrder(root));
    }
}
