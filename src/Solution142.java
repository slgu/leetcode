/**
 * Created by slgu1 on 10/2/15.
 */
import util.ListNode;
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fastnode = head;
        ListNode lownode = head;
        fastnode = fastnode.next;
        if (fastnode == null)
            return null;
        lownode = fastnode.next;
        while (fastnode != null && lownode != null) {
            if (fastnode == lownode) {
                lownode = head;
                while (fastnode != lownode) {
                    fastnode = fastnode.next;
                    lownode = lownode.next;
                }
                return fastnode;
            }
            fastnode = fastnode.next;
            lownode = lownode.next;
            if (lownode == null)
                return null;
            lownode = lownode.next;
        }
        return null;
    }
}
