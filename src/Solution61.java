import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/19/15.
 */

import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution61 {
    private static int getlen(ListNode head){
        int n = 0;
        while(head != null){
            ++n;
            head = head.next;
        }
        return n;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        int n = getlen(head);
        ListNode tail = head;
        while(tail.next != null)
            tail = tail.next;
        k = k % n;
        if(k == 0)
            return head;
        k = n - k;
        ListNode tmp = head;
        while((--k) != 0){
            tmp = tmp.next;
        }
        //set newhead
        ListNode newhead = tmp.next;
        //set null
        tmp.next = null;
        //set tail connect to head
        tail.next = head;
        return newhead;
    }
    public static void main(String[] args) {

    }
}
