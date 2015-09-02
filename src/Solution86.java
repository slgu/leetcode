import util.ListNode;
import util.ListUtil;
/**
 * Created by slgu1 on 9/2/15.
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;
        ListNode lastless = null;
        ListNode lastidx = null;
        ListNode idx = head;
        while(idx != null){
            ListNode next = idx.next;
            if(idx.val < x) {
                if(lastless != null){
                    if(lastless.next != idx) {
                        if(lastidx != null){
                            lastidx.next = idx.next;
                        }
                        idx.next = lastless.next;
                        lastless.next = idx;
                    }
                    else{
                        lastidx = idx;
                    }
                }
                else{
                    if(head != idx){
                        if(lastidx != null){
                            lastidx.next = idx.next;
                        }
                        idx.next = head;
                        head = idx;
                    }
                }
                lastless = idx;
            }
            else{
                lastidx = idx;
            }
            idx = next;
        }
        ListUtil.printlist(head);
        return head;
    }
    public static void main(String [] args){
        Solution86 a = new Solution86();
        ListNode head = ListUtil.makelist(new int[]{5, 5, 5, 1, 4, 3, 2, 5, 2});
        a.partition(head, 3);
    }
}
