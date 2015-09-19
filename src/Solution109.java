/**
 * Created by slgu1 on 9/18/15.
 */
import util.TreeNode;
import util.ListNode;
// TODO write in blog
public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        int l = getLength(head);
        //make cur
        this.cur = head;
        return makeNode(0, l - 1);
    }

    public static void main(String [] args) {
        Solution109 a = new Solution109();
        ListNode head = new ListNode(1);
        ListNode start = head;
        for (int i = 2; i < 10; ++i) {
            start.next = new ListNode(i);
            start = start.next;
        }
        TreeNode.debug(a.sortedListToBST(head));
    }
    private static int getLength(ListNode head){
        if (head == null)
            return 0;
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }
    private ListNode cur;
    private TreeNode makeNode(int l, int r) {
        if (l == r) {
            TreeNode node = new TreeNode(cur.val);
            updateCur();
            return node;
        }
        if(l > r)
            return null;
        int m = (l + r) >> 1;
        TreeNode lnode = makeNode(l, m - 1);
        TreeNode result = new TreeNode(cur.val);
        updateCur();
        TreeNode rnode = makeNode(m + 1, r);
        result.left = lnode;
        result.right = rnode;
        return result;
    }
    private void updateCur(){
        cur = cur.next;
    }
}