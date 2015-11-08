import java.util.HashMap;
import java.util.Map;
/*TODO*/

/**
 * Created by slgu1 on 10/23/15.
 */
public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return  "0";
        int flg = 1;
        long lnumerator = numerator;
        long ldenominator = denominator;
        if (numerator < 0) {
            flg = -flg;
            lnumerator = -lnumerator;
        }
        if (denominator < 0) {
            flg = -flg;
            ldenominator = -ldenominator;
        }
        long firstPart = lnumerator / ldenominator;
        lnumerator = lnumerator - firstPart * ldenominator;

        String firstParts = "";
        if (flg != 1)
            firstParts += "-";
        firstParts += String.valueOf(firstPart);
        if (lnumerator == 0)
            return firstParts;
        StringBuilder result = new StringBuilder();
        Map <Long, Integer> mp = new HashMap<Long, Integer>();
        int i = 0;
        while (true) {
            lnumerator = lnumerator * 10;
            if (mp.containsKey(lnumerator)) {
                int start_pos = mp.get(lnumerator);
                String res = firstParts;
                res += ".";
                res += result.substring(0, start_pos);
                res += "(";
                res += result.substring(start_pos, i);
                res += ")";
                return res;
            }
            mp.put(lnumerator, i);
            long pos = lnumerator / ldenominator;
            result.append(pos);
            lnumerator = lnumerator - pos * ldenominator;
            if (lnumerator == 0)
                return firstParts + "." + result.toString();
            ++i;
        }
    }
    public static void main(String [] args) {
        Solution166 a = new Solution166();
        System.out.println(a.fractionToDecimal(-2147483648, 1));
        System.out.println(a.fractionToDecimal(1,-2147483648));
        System.out.println(a.fractionToDecimal(1,-7));
        System.out.println(a.fractionToDecimal(-22,-3));
    }
}