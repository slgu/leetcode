/**
 * Created by slgu1 on 10/5/15.
 */
import util.ListNode;
import util.ListUtil;

public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        //special judge
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        ListNode virtual_head = new ListNode(0);
        virtual_head.next = head;

        ListNode last = head;
        ListNode now = head.next;
        while (now != null) {
            //find now position
            ListNode nxt = now.next;
            ListNode last_itr = virtual_head;
            ListNode itr = virtual_head.next;
            while (itr.val < now.val) {
                itr = itr.next;
                last_itr = last_itr.next;
            }
            if (now != itr) {
                //change
                last_itr.next = now;
                now.next = itr;
                last.next = nxt;
                now = nxt;
            }
            else {
                //step
                last = now;
                now = nxt;
            }
        }
        return virtual_head.next;
    }
    public static void main(String [] args) {
        Solution147 a = new Solution147();
        ListNode head = a.insertionSortList(ListUtil.makelist(new int[]{9, 8, 7, 6, 5, 4, 6, 2, 1}));
        ListUtil.printlist(head);
    }
}
