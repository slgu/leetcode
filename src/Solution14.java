/**
 * Created by slgu1 on 10/25/15.
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int idx = 0;
        int n = strs.length;
        StringBuilder builder = new StringBuilder();
        while (true) {
            int lastchar = -1;
            for (int i = 0; i < n; ++i) {
                if (idx >= strs[i].length())
                    return builder.toString();
                if (lastchar == -1)
                    lastchar = strs[i].charAt(idx);
                else if (lastchar != strs[i].charAt(idx))
                    return builder.toString();
            }
            builder.append((char)lastchar);
            ++idx;
        }
    }
    public static void main(String [] args) {
        Solution14 a = new Solution14();
        System.out.println(a.longestCommonPrefix(new String[]{"123", "12", "124"}));
    }
}
