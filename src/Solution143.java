/**
 * Created by slgu1 on 10/2/15.
 */
import com.sun.org.apache.bcel.internal.generic.FADD;
import util.ListNode;
import util.ListUtil;

public class Solution143 {
    private ListNode reverse(ListNode head) {
        ListNode itr = head.next;
        ListNode itrlast = head;
        itrlast.next = null;
        ListNode itrnext = null;
        while (itr != null) {
            itrnext = itr.next;
            itr.next = itrlast;
            itrlast = itr;
            itr = itrnext;
        }
        return itrlast;
    }
    private void combine(ListNode head1, ListNode head2) {
        ListNode itr1 = head1;
        ListNode itr2 = head2;
        ListNode itr1next;
        ListNode itr2next;
        ListNode newhead = null;
        ListNode lastitr = null;
        while(itr1 != null || itr2 != null) {
            if (itr1 != null) {
                if (newhead == null) {
                    newhead = itr1;
                    lastitr = itr1;
                }
                else {
                    lastitr.next = itr1;
                    lastitr = itr1;
                }
                itr1 = itr1.next;
            }
            if (itr2 != null) {
                if (newhead == null) {
                    newhead = itr2;
                    lastitr = itr2;
                }
                else {
                    lastitr.next = itr2;
                    lastitr = itr2;
                }
                itr2 = itr2.next;
            }
        }
    }
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        if (head.next == null)
            return;
        if (head.next.next == null)
            return;
        ListNode fastnode = head;
        ListNode lownode = head;
        while (fastnode != null) {
            fastnode = fastnode.next;
            if (fastnode == null)
                break;
            lownode = lownode.next;
            fastnode = fastnode.next;
        }
        fastnode = lownode.next;
        lownode.next = null;
        fastnode = reverse(fastnode);
        combine(head, fastnode);
    }
    public static void main(String... args) {
        Solution143 b = new Solution143();
        ListNode a = ListUtil.makelist(new int[]{1, 2, 3, 4,5});
        ListUtil.printlist(a);
        b.reorderList(a);
        ListUtil.printlist(a);
    }
}