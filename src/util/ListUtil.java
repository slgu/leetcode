package util;

/**
 * Created by slgu1 on 9/2/15.
 */
public class ListUtil {
    public static void printlist(ListNode head){
        int max = 10;
        while(head != null){
            --max;
            if(max == 0)
                break;
            System.out.print(head.val);
            System.out.print(' ');
            head = head.next;
        }
        System.out.println("");
    }
    public static ListNode makelist(int [] arr){
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        head.next = null;
        ListNode idx = head;
        for(int i = 1; i < arr.length; ++i){
            idx.next = new ListNode(arr[i]);
            idx = idx.next;
            idx.next = null;
        }
        return head;
    }
}
