/**
 * Created by slgu1 on 10/16/15.
 */
import com.sun.javafx.binding.SelectBinding;
import util.ListNode;
public class Solution165 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode itr1 = headA;
        ListNode itr2 = headB;
        int cnt = 0;
        while ((itr1 != null) || (itr2 != null)) {
            if (itr1 == null) {
                ++cnt;
                itr2 = itr2.next;
            }
            else if (itr2 == null) {
                --cnt;
                itr1 = itr1.next;
            }
            else {
                itr1 = itr1.next;
                itr2 = itr2.next;
            }
        }
        itr1 = headA;
        itr2 = headB;
        if (cnt > 0) {
            while((cnt--) != 0) {
                itr2 = itr2.next;
            }
        }
        else {
            while((cnt++) != 0) {
                itr1 = itr1.next;
            }
        }
        while ((itr1 != null) && (itr2 != null)) {
            if (itr1 == itr2)
                return itr1;
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        return null;
    }
    public static void main(String [] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        ListNode b = new ListNode(4);
        b.next = new ListNode(5);
        b.next.next = a.next;
        System.out.println(new Solution165().getIntersectionNode(a, b));
    }
}