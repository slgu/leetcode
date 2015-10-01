/**
 * Created by slgu1 on 9/30/15.
 */

import util.RandomListNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Solution138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        int n = 0;
        mp.clear();
        arr.clear();
        RandomListNode itr = head;
        while (itr != null) {
            arr.add(itr);
            mp.put(itr, n);
            ++n;
            itr = itr.next;
        }
        RandomListNode [] nodes = new RandomListNode[n];
        for (int i = 0; i < n; ++i) {
            nodes[i] = new RandomListNode(arr.get(i).label);
        }
        for (int i = 0; i < n; ++i) {
            if (i != n - 1) {
                nodes[i].next = nodes[i + 1];
            }
            else {
                nodes[i].next = null;
            }
            if (arr.get(i).random == null) {
                nodes[i].random = null;
            }
            else {
                nodes[i].random = nodes[mp.get(arr.get(i).random)];
            }
        }
        return nodes[0];
    }
    private Map <RandomListNode, Integer> mp = new HashMap<RandomListNode, Integer>();
    private ArrayList <RandomListNode> arr = new ArrayList<RandomListNode>();
}
