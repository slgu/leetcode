/**
 * Created by slgu1 on 10/16/15.
 */
import util.ListNode;
import util.ListUtil;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode first = head;
        ListNode second = head;
        ListNode secondlast = null;
        while ((n--) != 0) {
            if (first == null)
                return null;
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            secondlast = second;
            second = second.next;
        }
        if (secondlast == null) {
            return second.next;
        }
        secondlast.next = second.next;
        return head;
    }
    public static void main(String [] args) {
        Solution19 a = new Solution19();
        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(3);
        b.next.next.next = new ListNode(4);
        b.next.next.next.next = new ListNode(5);
        b = a.removeNthFromEnd(b, 5);
        ListUtil.printlist(b);
    }
}