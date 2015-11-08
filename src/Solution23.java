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
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        PriorityQueue <ListNode> queue = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode virtualHead = new ListNode(0);
        ListNode last = virtualHead;
        int k = lists.length;
        for (int i = 0; i < k; ++i) {
            if (lists[i] != null)
                queue.add(lists[i]);
        }
        while (!queue.isEmpty()) {
            ListNode nxt = queue.poll();
            last.next = nxt;
            last = nxt;
            if (nxt.next != null)
                queue.add(nxt.next);
        }
        return virtualHead.next;
    }
    public static void main(String [] args) {
        ListNode [] lists = new ListNode[]{
               ListUtil.makelist(new int[]{1,2,3}),
               ListUtil.makelist(new int[]{}),
               ListUtil.makelist(new int[]{7,8,9})
        };
        Solution23 a = new Solution23();
        ListUtil.printlist(a.mergeKLists(lists));
    }
}

