/**
 * Created by slgu1 on 9/18/15.
 */
import util.TreeNode;
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode node = makeTree(nums, 0, n - 1);
        return node;
    }
    public static void main(String [] args) {
        Solution108 a = new Solution108();
        TreeNode node = a.sortedArrayToBST(new int [] {9,12,14,17});
        TreeNode.debug(node);
    }
    private TreeNode makeTree(int [] nums, int l, int r) {
        if(l == r)
            return new TreeNode(nums[l]);
        if(r < l)
            return null;

        int height = 0;
        int count = r - l + 1;
        while (count != 0) {
            ++height;
            count >>= 1;
        }
        --height;
        count = r - l + 1;
        int extra = count - ((1 << height) - 1);
        int extra_l, extra_r;
        if (extra > (1 << (height - 1))) {
            extra_l = 1 << (height - 1);
            extra_r = extra - extra_l;
        }
        else {
            extra_l = extra;
            extra_r = 0;
        }
        int ltree_length = ((1 << (height - 1)) - 1) + extra_l;
        TreeNode node = new TreeNode(nums[l + ltree_length]);
        node.left = makeTree(nums, l, l + ltree_length - 1);
        node.right = makeTree(nums, l + ltree_length + 1, r);
        return node;
    }
}