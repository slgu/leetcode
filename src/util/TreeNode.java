package util;

/**
 * Created by slgu1 on 9/4/15.
 */
import java.util.LinkedList;
import java.util.List;
public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;
    public static List<Integer> inorderTraversal(TreeNode root){
        if(root == null)
            return new LinkedList<Integer>();
        LinkedList <TreeNode> nodedeque = new LinkedList<TreeNode>();
        LinkedList <Boolean> flagdeque = new LinkedList<Boolean>();
        //init
        nodedeque.addFirst(root);
        flagdeque.add(true);
        LinkedList <Integer> result = new LinkedList<Integer>();
        while(!nodedeque.isEmpty()){
            TreeNode top = nodedeque.pollFirst();
            Boolean flg = flagdeque.pollFirst();
            //new here
            if(flg){
                //if end
                if(top.right != null){
                    nodedeque.addFirst(top.right);
                    flagdeque.addFirst(true);
                }
                nodedeque.addFirst(top);
                flagdeque.addFirst(false);
                if(top.left != null){
                    nodedeque.addFirst(top.left);
                    flagdeque.addFirst(true);
                }
                //done
            }
            else{
                //add to result
                result.add(top.val);
            }
        }
        return result;
    }
    public TreeNode(int x) { val = x; }
}
