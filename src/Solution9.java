/**
 * Created by slgu1 on 10/16/15.
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        boolean flg = false;
        if (x < 0) {
            x = -x;
            flg = true;
        }
        int tmpx = x;
        int reverse = 0;
        while (x != 0) {
            int extra = x % 10;
            int tmp = reverse;
            reverse = reverse << 1;
            if (reverse < 0)
                return false;
            reverse = reverse << 1;
            if (reverse < 0)
                return false;
            reverse = reverse << 1;
            if (reverse < 0)
                return false;
            reverse = reverse + 2 * tmp + extra;
            if (reverse < 0)
                return false;
            x /= 10;
        }
        if (flg)
            reverse = -reverse;
        return reverse == tmpx;
    }
}