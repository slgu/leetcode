import util.ListNode;
import util.ListUtil;
/**
 * Created by slgu1 on 9/1/15.
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode last = head;
        ListNode now = head.next;
        ListNode idx = head;
        while(now != null){
            if(now.val == last.val){
                //not add
            }
            else{
                idx.val = last.val;
                idx = idx.next;
            }
            now = now.next;
            last = last.next;
        }
        idx.val = last.val;
        idx.next = null;
        return head;
    }
}
