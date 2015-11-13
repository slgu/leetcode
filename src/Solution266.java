/**
 * Created by slgu1 on 11/13/15.
 */
/*TODO char 2 bytes*/
public class Solution266 {
    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        int totalCnt = 256 * 256;
        int used [] = new int[totalCnt];
        for (int i = 0; i < totalCnt; ++i)
            used[i] = 0;
        for (int i = 0; i < n; ++i) {
            //System.out.println((int)s.charAt(i));
            ++used[s.charAt(i)];
        }
        boolean flg = false;
        for (int i = 0; i < totalCnt; ++i)
            if (used[i] % 2 != 0) {
                if (flg)
                    return false;
                flg = true;
            }
        return true;
    }
    public static void main(String [] args) {
        Solution266 a = new Solution266();
        System.out.println(a.canPermutePalindrome("中a中"));
    }
}