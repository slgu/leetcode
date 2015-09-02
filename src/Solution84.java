import util.ListNode;
import util.ListUtil;
import java.util.LinkedList;
import java.util.SimpleTimeZone;
import java.util.stream.StreamSupport;

/**
 * Created by slgu1 on 9/1/15.
 */
//TODO write in blog
public class Solution84 {
    public static class Item {
        public int val;
        public int num;

        Item(int val, int num) {
            this.val = val;
            this.num = num;
        }
    }

    private LinkedList<Item> itemlist = new LinkedList<Item>();
    private int n;

    private int[] get_val(int[] height) {
        itemlist.clear();
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            int val = height[i];
            int num = 1;
            while (true) {
                if (itemlist.isEmpty())
                    break;
                Item last = itemlist.peekLast();
                if (last.val >= val) {
                    num += last.num;
                    itemlist.removeLast();
                    continue;
                } else {
                    break;
                }
            }
            itemlist.addLast(new Item(val, num));
            result[i] = num;
        }
        return result;
    }

    public int largestRectangleArea(int[] height) {
        if(height.length == 0)
            return 0;
        itemlist.clear();
        n = height.length;
        int[] inc_val = get_val(height);
        int x = 0;
        int y = n - 1;
        //reverse
        while (x < y) {
            int item = height[x];
            height[x] = height[y];
            height[y] = item;
            ++x;
            --y;
        }
        int[] dec_val = get_val(height);
        int maxn = -1;
        for (int i = 0; i < n; ++i) {
            int tmp_val = height[n - 1 - i] * (inc_val[i] + dec_val[n - 1 - i] - 1);
            if (maxn == -1 || maxn < tmp_val) {
                maxn = tmp_val;
            }
        }
        return maxn;
    }
    public static void main(String [] args){
        Solution84 a = new Solution84();
        System.out.println(a.largestRectangleArea(new int[]{2, 4}));
    }
}
