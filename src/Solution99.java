/**
 * Created by slgu1 on 9/4/15.
 */
//TODO write in blog
import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution99{
    public static class Pair <A,B>{
        A first = null;
        B second = null;
        Boolean third = false;
        Pair(){
        }
        Pair(A a, B b){
            first = a;
            second = b;
        }
        String tostr(){
            return first.toString() + "," + second.toString() + "," + third.toString();
        }
    }
    public void recoverTree(TreeNode root) {
        recover(root);
        //swap
        int tmp = recoverl.val;
        recoverl.val = recoverr.val;
        recoverr.val = tmp;
    }
    public static void main(String [] args){
        Solution99 a = new Solution99();
        TreeNode root = new TreeNode(146);
        TreeNode l1 = new TreeNode(71);
        TreeNode l2 = new TreeNode(-13);
        TreeNode l21 = new TreeNode(231);
        l2.left = l21;
        root.left = l1;
        root.right = l2;
        TreeNode l22 = new TreeNode(399);
        l2.right = l22;
        TreeNode l11 = new TreeNode(55);
        l1.left = l11;
        TreeNode l111 = new TreeNode(321);
        l11.left = l111;
        TreeNode l1111 = new TreeNode(-33);
        l111.left = l1111;
        System.out.println(TreeNode.inorderTraversal(root));
        a.recoverTree(root);
        System.out.println(TreeNode.inorderTraversal(root));
    }
    private Pair <TreeNode, TreeNode> recover(TreeNode root){
        Pair <TreeNode, TreeNode> result = new Pair<TreeNode, TreeNode>();
        result.third = true;
        result.first =  result.second = root;
        Pair <TreeNode, TreeNode> resultl = null;
        Pair <TreeNode, TreeNode> resultr = null;
        if(root.left == null){

        }
        else{
            resultl = recover(root.left);
            result.first = resultl.first;
            if(!resultl.third)
                result.third = false;
            if(resultl.third && root.val < resultl.second.val){
                if(recoverl == null) {
                    recoverl = resultl.second;
                }
                result.third = false;
            }
        }
        if(recoverl == null) {
            if ((resultl == null || (resultl.third && resultl.second.val < root.val)) && root.right != null) {
                resultr = recover(root.right);
                if (resultr.first.val < root.val) {
                    recoverl = root;
                }
            }
        }
        if(root.right == null){

        }
        else{
            if(resultr == null)
                resultr = recover(root.right);
            result.second = resultr.second;
            if(!resultr.third)
                result.third = false;
            if(resultr.third && root.val > resultr.first.val){
                recoverr = resultr.first;
                result.third = false;
            }
        }
        if ((resultr == null || (resultr.third && resultr.first.val > root.val)) && root.left != null) {
            if (resultl.second.val > root.val) {
                recoverr = root;
            }
        }
        return result;
    }
    private TreeNode recoverl;
    private TreeNode recoverr;
}
