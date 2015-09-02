import util.ListNode;
import util.ListUtil;
/**
 * Created by slgu1 on 9/1/15.
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode last = null;
        ListNode now = head;
        ListNode idx = null;
        while(now != null){
            if(last != null && now.val == last.val){

            }
            else{
                if(now.next != null && now.next.val == now.val){

                }
                else{
                    if(idx == null){
                        idx = head;
                    }
                    else{
                        idx = idx.next;
                    }
                    idx.val = now.val;
                }
            }
            last = now;
            now = now.next;
        }
        if(idx == null)
            return null;
        idx.next = null;
        return head;
    }
}
