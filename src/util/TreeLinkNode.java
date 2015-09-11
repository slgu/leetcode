package util;

/**
 * Created by slgu1 on 9/5/15.
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;
    public TreeLinkNode(int x) { val = x; }
    public static void printdebug(TreeLinkNode a){
        System.out.println("begin print tree");
        debug(a);
    }
    public static void debug(TreeLinkNode a){
        if(a == null)
            return;
        System.out.print(String.valueOf(a.val) + ":" + ((a.next == null)?"null":String.valueOf(a.next.val)) + "\n");
        debug(a.left);
        debug(a.right);
    }
}
