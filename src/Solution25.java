/**
 * Created by slgu1 on 10/17/15.
 */
import util.ListNode;
import util.ListUtil;


public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode itr = head;
        int length = 0;
        while (itr != null) {
            ++length;
            itr = itr.next;
        }
        length = length / k;
        if (length == 0)
            return head;
        itr = head.next;
        ListNode last = head;
        ListNode nowhead = head;
        ListNode nowlast = null;
        ListNode newhead = null;
        int reverse_number = 1;
        int cnt = 1;
        while (itr != null) {
            ListUtil.printlist(newhead);
            ListNode nxt = itr.next;
            if ((cnt % k) == 0) {
                if (reverse_number == length)
                    break;
                ++reverse_number;
                nowhead = itr;
                nowlast = last;
                last = itr;
            }
            else {
                last.next = nxt;
                itr.next = nowhead;
                nowhead = itr;
                if (nowlast != null)
                    nowlast.next = itr;
                else
                    newhead = itr;
            }
            itr = nxt;
            ++cnt;
        }
        return newhead;
    }
    public static void main(String [] args) {
        ListNode a = ListUtil.makelist(new int[]{1, 2, 3, 4, 5});
        ListUtil.printlist(a);
        a = new Solution25().reverseKGroup(a, 3);
        ListUtil.printlist(a);
    }
}
