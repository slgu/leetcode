import util.TreeLinkNode;

/**
 * Created by slgu1 on 9/5/15.
 */
public class Solution117 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode father = null;
        TreeLinkNode current = root;
        while(current != null) {
            if(current.left != null && current.right != null) {
                current.left.next = current.right;
            }
            TreeLinkNode idx = current;
            while (idx != null){
                //next is right
                if(idx.left != null && idx.right != null) {
                    idx.left.next = idx.right;
                }
                if(idx.next == null)
                    break;
                if(father != null && father.right == idx.next){
                    if(idx.right != null){
                        idx.right.next = idx.next;
                    }
                    else if(idx.left != null){
                        idx.left.next = idx.next;
                    }
                    idx = idx.next;
                }
                else {
                    TreeLinkNode haschildnext = idx.next;
                    while(((haschildnext != null) && (((haschildnext.left == null) && (haschildnext.right == null))))){
                        haschildnext = haschildnext.next;
                    }
                    if(haschildnext != null){
                        father = haschildnext;
                        if(haschildnext.left != null){
                            idx.next = haschildnext.left;
                        }
                        else{
                            idx.next = haschildnext.right;
                        }
                        if(idx.right != null){
                            idx.right.next = idx.next;
                        }
                        else if(idx.left != null){
                            idx.left.next = idx.next;
                        }
                    }
                    else{
                        idx.next = null;
                    }
                    idx = idx.next;
                }
            }
            TreeLinkNode nextstart = current;
            while((nextstart != null && (((nextstart.left == null) && (nextstart.right == null))))) nextstart = nextstart.next;
            if(nextstart == null){
                break;
            }
            else{
                father = nextstart;
                if(nextstart.left == null){
                    current = nextstart.right;
                }
                else{
                    current = nextstart.left;
                }
            }
        }
    }
    public static void main(String [] args){
        Solution117 a = new Solution117();
        TreeLinkNode b = new TreeLinkNode(1);
        b.left = new TreeLinkNode(2);
        b.right = new TreeLinkNode(3);
        b.left.left = new TreeLinkNode(4);
        b.left.right = new TreeLinkNode(5);
        b.right.left = new TreeLinkNode(6);
        b.right.right = new TreeLinkNode(7);
        b.left.left.left = new TreeLinkNode(8);
        b.left.left.right = new TreeLinkNode(9);
        b.left.right.left = new TreeLinkNode(10);
        b.left.right.right = new TreeLinkNode(11);
        b.right.left.left = new TreeLinkNode(12);
        b.right.left.right = new TreeLinkNode(13);
        b.right.right.left = new TreeLinkNode(14);
        TreeLinkNode.printdebug(b);
        a.connect(b);
        TreeLinkNode.printdebug(b);
    }
}
