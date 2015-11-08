/**
 * Created by slgu1 on 10/27/15.
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        //edge test
        if (s.equals(""))
            return true;
        int n = s.length();
        int x = 0;
        int y = n - 1;
        while (x < y) {
            char tmpx = 'a';
            char tmpy = 'b';
            while (x < y) {
                tmpx = s.charAt(x);
                if (tmpx >= '0' && tmpx <= '9')
                    break;
                if (tmpx >= 'a' && tmpx <= 'z')
                    break;
                if (tmpx >= 'A' && tmpx <= 'Z') {
                    tmpx = (char) ((tmpx - 'A') + 'a');
                    break;
                }
                ++x;
            }
            while (x < y) {
                tmpy = s.charAt(y);
                if (tmpy >= '0' && tmpy <= '9')
                    break;
                if (tmpy >= 'a' && tmpy <= 'z')
                    break;
                if (tmpy >= 'A' && tmpy <= 'Z') {
                    tmpy = (char) ((tmpy - 'A') + 'a');
                    break;
                }
                --y;
            }
            if (x < y) {
                if (tmpx == tmpy) {
                    ++x;
                    --y;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
        return true;
    }
    public static void main(String [] args) {
        Solution125 a = new Solution125();
        System.out.println(a.isPalindrome("A man, a plan, a canal: Panama"));
    }
}