/**
 * Created by slgu1 on 10/27/15.
 */
import apple.laf.JRSUIUtils;
import org.omg.CORBA.PRIVATE_MEMBER;
import util.TreeNode;

import java.util.Stack;

class BSTIterator {

    public BSTIterator(TreeNode root) {
        TreeNode itr1 = root;
        itr = null;
        while (itr1 != null) {
            itr = itr1;
            st.add(itr1);
            itr1 = itr1.left;
        }
        if (!st.empty()) st.pop();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return itr != null;
    }

    /** @return the next smallest number */
    public int next() {
        int ret = itr.val;
        TreeNode itr1 = null;
        if (itr.right == null) {
            while (true) {
                if (st.empty()) {
                    itr = null;
                    return ret;
                }
                itr1 = st.pop();
                if (itr1.left == itr)
                    break;
                itr = itr1;
            }
            itr = itr1;
        }
        else {
            st.add(itr);
            itr1 = itr.right;
            while (itr1 != null) {
                itr = itr1;
                st.add(itr);
                itr1 = itr1.left;
            }
            st.pop();
        }
        return ret;
    }
    private Stack <TreeNode> st = new Stack<TreeNode>();
    private TreeNode itr;
}
public class Solution173 {
    public static void main(String [] args) {
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(1);
        a.right = new TreeNode(4);
        a.left.right = new TreeNode(2);
        BSTIterator b = new BSTIterator(a);
        while (b.hasNext()) {
            System.out.println(b.next());
        }
    }
}
