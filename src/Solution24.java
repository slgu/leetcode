import util.ListNode;
import util.ListUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gsl on 7/3/15.
 */
import util.ListNode;
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode last = null;
        ListNode itr = head;
        ListNode res_head = head.next;
        while(true) {
            if (itr == null || itr.next == null)
                return res_head;
            ListNode itr_next = itr.next;
            ListNode itr_next_next = itr_next.next;
            if (last != null){
                last.next = itr_next;
            }
            itr_next.next = itr;
            itr.next = itr_next_next;
            last = itr;
            itr = itr_next_next;
        }
    }
    public static ListNode makelist(List<Integer> arr){
        ListNode head = new ListNode(arr.get(0));
        ListNode last = head;
        for(int i = 1; i <arr.size(); ++i){
            ListNode tmp = new ListNode(arr.get(i));
            last.next = tmp;
            last = tmp;
        }
        return head;
    }
    public static void printList(ListNode head){
        if(head == null){
            System.out.println("ah");
            return;
        }
        System.out.print(head.val);
        System.out.print(' ');
        printList(head.next);
    }
    public static void main(String [] args){
        Solution24 a = new Solution24();
        ListNode list1 = makelist(new ArrayList<Integer>(){{add(1);add(3);add(5);add(7);}});
        ListNode list2 = makelist(new ArrayList<Integer>(){{add(2);add(4);add(6);add(8);}});
        printList(a.swapPairs(list1));
    }
}
