/**
 * Created by slgu1 on 9/7/15.
 */
import util.TreeNode;
public class Solution124 {
    int dfs(TreeNode cur){
        if(cur == null)
            return 0;
        int sum1 = dfs(cur.left);
        int sum2 = dfs(cur.right);
        int thismax = 0;
        if(sum1 > 0) thismax += sum1;
        if(sum2 > 0) thismax += sum2;
        thismax += cur.val;
        //update maxn
        if(maxn == null || maxn < thismax) {
            maxn = thismax;
        }
        if(sum1 <= 0 && sum2 <= 0){
            return cur.val;
        }
        else{
            if(sum1 > sum2)
                return cur.val + sum1;
            else
                return cur.val + sum2;
        }
    }
    public int maxPathSum(TreeNode root) {
        //init
        maxn = null;
        dfs(root);
        return maxn;
    }
    public static void main(String [] args){
        Solution124 b = new Solution124();
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.left.left = new TreeNode(3);
        a.left.left.left = new TreeNode(4);
        System.out.println(b.maxPathSum(a));

    }
    private Integer maxn;
}
