/**
 * Created by slgu1 on 10/2/15.
 */
import util.ListNode;
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fastnode = head;
        ListNode lownode = head;
        fastnode = fastnode.next;
        if (fastnode == null)
            return false;
        lownode = fastnode.next;
        while (fastnode != null && lownode != null) {
            if (fastnode == lownode)
                return true;
            fastnode = fastnode.next;
            lownode = lownode.next;
            if (lownode == null)
                return false;
            lownode = lownode.next;
        }
        return false;
    }
}
