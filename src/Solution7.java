/**
 * Created by slgu1 on 10/16/15.
 */
public class Solution7 {
    public int reverse(int x) {
        if (x == 0)
            return 0;
        boolean flg = false;
        if (x < 0) {
            x = -x;
            flg = true;
        }
        int reverse = 0;
        while (x != 0) {
            int extra = x % 10;
            int tmp = reverse;
            reverse = reverse << 1;
            if (reverse < 0)
                return 0;
            reverse = reverse << 1;
            if (reverse < 0)
                return 0;
            reverse = reverse << 1;
            if (reverse < 0)
                return 0;
            reverse = reverse + 2 * tmp + extra;
            if (reverse < 0)
                return 0;
            x /= 10;
        }
        if (flg)
            reverse = -reverse;
        return reverse;
    }
    public static void main(String [] args) {
        Solution7 a = new Solution7();
        System.out.println(a.reverse(1153436469));
    }
}
