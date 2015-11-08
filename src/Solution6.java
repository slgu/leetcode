/**
 * Created by slgu1 on 10/16/15.
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return new String(s.getBytes());
        StringBuilder builder = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((j % (2 * numRows - 2)) == i || (j % (2 * numRows - 2)) == (2 * numRows - 2 - i))
                    builder.append(s.charAt(j));
            }
        }
        return builder.toString();
    }
    public static void main(String [] args) {
        Solution6 a = new Solution6();
        System.out.println(a.convert("PAYPALISHIRING", 3));
    }
}
