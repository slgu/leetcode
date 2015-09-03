/**
 * Created by slgu1 on 9/3/15.
 */
import util.ListNode;
import util.ListUtil;
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode virtualhead = new ListNode(0);
        virtualhead.next = head;
        ListNode lastitr = virtualhead;
        ListNode itr = head;//iteratre
        ListNode m_ptr = null;
        int count = 0;
        while(itr != null){
            ++count;
            ListNode nextptr = itr.next;
            if(count == m){
                //first
                //set m_ptr
                m_ptr = lastitr;
                lastitr = itr;
            }
            else if(count > m && count <= n){
                lastitr.next = itr.next;
                itr.next = m_ptr.next;
                m_ptr.next = itr;
            }
            else if(count > n)
                break;
            else{
                lastitr = itr;
            }
            itr = nextptr;
        }
        if(m == 1) {
            return virtualhead.next;
        }
        else{
            return head;
        }
    }
    public static void main(String [] args){
        Solution92 a = new Solution92();
        ListNode head = ListUtil.makelist(new int [] {1,2,3});
        ListUtil.printlist(a.reverseBetween(head, 2, 3));
    }
}