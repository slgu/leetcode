import util.ListNode;
import util.ListUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by gsl on 7/3/15.
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        int list_num = lists.length;
        ListNode head = null;
        ListNode last = null;
        PriorityQueue <ListNode> heap = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if(l1.val == l2.val)
                    return 0;
                else
                    if(l1.val < l2.val)
                        return -1;
                else
                        return 1;
            }
        });
        for(int i = 0; i < list_num; ++i){
            if(lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        while(true){
            if(heap.isEmpty())
                break;
            ListNode new_append_node = heap.poll();
            if(head == null){
                head = new_append_node;
                last = new_append_node;
            }
            else{
                last.next = new_append_node;
                last = new_append_node;
            }
            if(new_append_node.next != null){
                heap.add(new_append_node.next);
            }
        }
        return head;
    }
    public static ListNode makelist(List<Integer>arr){
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
        Solution23 a = new Solution23();
        ListNode list1 = makelist(new ArrayList<Integer>(){{add(1);add(3);add(5);add(7);}});
        ListNode list2 = makelist(new ArrayList<Integer>(){{add(2);add(4);add(6);add(8);}});
        ListNode [] list_arr = {list1, list2};
        ListNode [] list_arr2 = {list1, null};
        printList(a.mergeKLists(list_arr));
        printList(a.mergeKLists(list_arr2));
    }
}
