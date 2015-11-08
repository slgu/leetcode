/**
 * Created by slgu1 on 10/27/15.
 */
public class Solution38 {
    public String countAndSay(int n) {
        String start = "1";
        while ((--n) != 0) {
            int nn = start.length();
            int lastcnt = 1;
            StringBuilder next = new StringBuilder();
            for (int i = 1; i < nn; ++i) {
                if (start.charAt(i) != start.charAt(i - 1)) {
                    next.append(String.valueOf(lastcnt));
                    next.append(start.charAt(i - 1));
                    lastcnt = 1;
                }
                else {
                    ++lastcnt;
                }
            }
            next.append(String.valueOf(lastcnt));
            next.append(start.charAt(nn - 1));
            start = next.toString();
        }
        return start;
    }
    public static void main(String [] args) {
        Solution38 a = new Solution38();
        System.out.println(a.countAndSay(5));
    }
}
