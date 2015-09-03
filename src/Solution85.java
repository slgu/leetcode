import util.ListNode;
import util.ListUtil;
import util.ArrayUtil;

import java.util.LinkedList;

/**
 * Created by slgu1 on 9/1/15.
 */
public class Solution85 {
    public static class Item {
        public int val;
        public int num;

        Item(int val, int num) {
            this.val = val;
            this.num = num;
        }
    }

    private LinkedList<Item> itemlist = new LinkedList<Item>();
    private void get_val(int[] height, int [] result) {
        itemlist.clear();
        int n = height.length;
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
    }
    private int [] inc_val;
    private int [] dec_val;
    private int maxheight(int []height){
        int n = height.length;
        get_val(height, inc_val);
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
        get_val(height, dec_val);
        int maxn = -1;
        for (int i = 0; i < n; ++i) {
            int tmp_val = height[n - 1 - i] * (inc_val[i] + dec_val[n - 1 - i] - 1);
            if (maxn == -1 || maxn < tmp_val) {
                maxn = tmp_val;
            }
        }
        x = 0;
        y = n - 1;
        //reverse back
        while (x < y) {
            int item = height[x];
            height[x] = height[y];
            height[y] = item;
            ++x;
            --y;
        }
        return maxn;
    }
    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        if(n == 0)
            return 0;
        int m = matrix[0].length;
        if(m == 0)
            return 0;
        //init
        inc_val = new int[n];
        dec_val = new int[n];
        int [] height = new int[n];
        for(int i = 0; i < n; ++i)
            height[i] = 0;
        int maxn = -1;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j) {
                if (matrix[j][i] == '0') {
                    height[j] = 0;
                } else {
                    ++height[j];
                }
            }
            int tmpval = maxheight(height);
            if(maxn == -1 || maxn < tmpval)
                maxn = tmpval;
        }
        return maxn;
    }
    public static void main(String [] args){
        Solution85 a = new Solution85();
        System.out.println(a.maximalRectangle(new char[][]{
                {'0', '1'},
                {'1', '0'}
        }));
    }
}
