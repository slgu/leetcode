/**
 * Created by slgu1 on 9/5/15.
 */
import util.TreeLinkNode;
public class Solution116 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode current = root;
        while(current != null) {
            if(current.left != null) {
                current.left.next = current.right;
            }
            TreeLinkNode idx = current;
            if(idx != null && idx.next != null){
                if(idx.right != null){
                    idx.right.next = idx.next;
                }
            }
            idx = idx.next;
            while (idx != null && idx.next != null){
                idx.next.left.next = idx.next.right;
                idx.next = idx.next.left;
                if(idx.right != null){
                    idx.right.next = idx.next;
                }
                idx = idx.next;
                if(idx.right != null){
                    idx.right.next = idx.next;
                }
                idx = idx.next;
            }
            current = current.left;
        }
    }
    public static void main(String [] args){
        Solution116 a = new Solution116();
        TreeLinkNode b = new TreeLinkNode(1);
        b.left = new TreeLinkNode(2);
        b.right = new TreeLinkNode(3);
        b.left.left = new TreeLinkNode(4);
        b.left.right = new TreeLinkNode(5);
        b.right.left = new TreeLinkNode(6);
        b.right.right = new TreeLinkNode(7);
        TreeLinkNode.debug(b);
        a.connect(b);
        TreeLinkNode.debug(b);
    }
}



