/**
 * Created by slgu1 on 10/25/15.
 */
public class Solution13 {
    private int getVal(char l) {
        switch (l) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public int romanToInt(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int val = getVal(s.charAt(i));
            if (i != n - 1) {
                int val2 = getVal(s.charAt(i + 1));
                if (val2 > val) {
                    res += (val2 - val);
                    ++i;
                    continue;
                }
            }
            res += val;
        }
        return res;
    }
    public static void main(String [] args) {
        Solution13 a = new Solution13();
        System.out.println(a.romanToInt("MMXIV"));
    }
}
