/**
 * Created by slgu1 on 9/30/15.
 */
import util.ArrayUtil;
import util.RandomListNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution138_2 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode newhead = new RandomListNode(head.label);
        RandomListNode newitr = newhead;
        RandomListNode nowitr = head;
        while (nowitr != null) {
            newitr.random = nowitr;
            RandomListNode tmpnext = nowitr.next;
            nowitr.next = newitr;
            if (tmpnext != null) {
                newitr.next = new RandomListNode(tmpnext.label);
            }
            else
                newitr.next = null;

            //go on next
            newitr = newitr.next;
            nowitr = tmpnext;
        }
        // set random and recover
        nowitr = newhead;
        ArrayList <RandomListNode> list = new ArrayList<RandomListNode>();
        while (nowitr != null) {
            newitr = nowitr.random;
            if (nowitr.random.random == null)
                nowitr.random = null;
            else
                nowitr.random = nowitr.random.random.next;
            nowitr = nowitr.next;
            list.add(newitr);
        }
        int n = list.size();
        //recover
        for (int i = 0; i < n - 1; ++i)
            list.get(i).next = list.get(i + 1);
        list.get(n - 1).next = null;
        return newhead;
    }
}
