/**
 * Created by slgu1 on 9/4/15.
 */
import util.TreeNode;


public class Solution98 {
    static class Triple <A,B,C>{
        A first;
        B second;
        C third;
        Triple(){

        }
        Triple(A a, B b,C c){
            first = a;
            second = b;
            third = c;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return isvalidbst(root).first;
    }
    public static void main(String [] args){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(-1);
        System.out.print(new Solution98().isValidBST(node));
    }
    private Triple <Boolean, Integer, Integer> isvalidbst(TreeNode root){
        Triple <Boolean, Integer, Integer> result = new Triple<Boolean, Integer, Integer>();
        result.first = true;
        result.second = result.third = root.val;
        //if left or right hahaha
        if(root.left == null){

        }
        else{
            //judge
            Triple <Boolean, Integer, Integer> resultl = isvalidbst(root.left);
            if(resultl.first == false || resultl.third >= root.val){
                result.first = false;
                return result;
            }
            result.second = resultl.second;
        }
        if(root.right == null){

        }
        else{
            //judge
            Triple <Boolean, Integer, Integer> resultr = isvalidbst(root.right);
            if(resultr.first == false || resultr.second <= root.val){
                result.first = false;
                return result;
            }
            result.third = resultr.third;
        }
        return result;
    }
}
