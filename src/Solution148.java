/**
 * Created by slgu1 on 10/5/15.
 */
import util.ListNode;
import util.ListUtil;

import java.util.List;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        //fast and quick to get mid
        ListNode fast = head;
        ListNode low = head;
        while (true) {
            fast = fast.next;
            if (fast == null)
                break;
            fast = fast.next;
            if (fast == null)
                break;
            low = low.next;
        }
        fast = low.next;
        low.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        if (left == null)
            return right;
        if (right == null)
            return left;
        ListNode res = merge(left, right);
        return res;
    }

    public static void main(String [] args) {
        Solution148 a = new Solution148();
        ListNode head = a.sortList(ListUtil.makelist(new int[]{9, 8, 7, 6, 5, 4, 3}));
        ListUtil.printlist(head);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode idx1 = left;
        ListNode idx2 = right;
        ListNode head = new ListNode(0);
        ListNode last = head;
        while (idx1 != null || idx2 != null) {
            if (idx1 == null) {
                last.next = idx2;
                idx2 = idx2.next;
                last = last.next;
            }
            else if (idx2 == null) {
                last.next = idx1;
                idx1 = idx1.next;
                last = last.next;
            }
            else {
                if (idx1.val > idx2.val) {
                    ListNode idx2next = idx2.next;
                    last.next = idx2;
                    idx2 = idx2next;
                    last = last.next;
                }
                else {
                    ListNode idx1next = idx1.next;
                    last.next = idx1;
                    idx1 = idx1next;
                    last = last.next;
                }
            }
        }
        return head.next;
    }
}
