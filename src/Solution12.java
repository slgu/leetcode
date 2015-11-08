/**
 * Created by slgu1 on 10/25/15.
 */
public class Solution12 {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            if (num >= 1000) {
                int k = num / 1000;
                for (int i = 0; i < k; ++i)
                    res.append("M");
                num = num - k * 1000;
                continue;
            }
            if (num >= 900) {
                res.append("CM");
                num -= 900;
                continue;
            }
            if (num >= 500) {
                res.append("D");
                num -= 500;
                continue;
            }
            if (num >= 400) {
                res.append("CD");
                num -= 400;
                continue;
            }
            if (num >= 100) {
                int k = num / 100;
                for (int i = 0; i < k; ++i)
                    res.append("C");
                num = num - k * 100;
                continue;
            }
            if (num >= 90) {
                res.append("XC");
                num -= 90;
                continue;
            }
            if (num >= 50) {
                res.append("L");
                num -= 50;
                continue;
            }
            if (num >= 40) {
                res.append("XL");
                num -= 40;
                continue;
            }
            if (num >= 10) {
                int k = num / 10;
                for (int i = 0; i < k; ++i)
                    res.append("X");
                num = num - 10 * k;
                continue;
            }
            if (num == 9) {
                res.append("IX");
                break;
            }
            if (num >= 5) {
                res.append("V");
                num -= 5;
                continue;
            }
            if (num == 4) {
                res.append("IV");
                break;
            }
            else {
                for (int i = 0; i < num; ++i)
                    res.append("I");
                break;
            }
        }
        return res.toString();
    }
    public static void main(String [] args) {
        Solution12 a = new Solution12();
        System.out.println(a.intToRoman(2014));
    }
}
