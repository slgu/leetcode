class Reader4 {
    private int idx = 0;
    private static String s = "ab";
    int read4(char [] buf) {
        int i;
        for (i = idx; i < idx + 4 && i < s.length(); ++i)
            buf[i - idx] = s.charAt(i);
        int ret = i - idx;
        idx = idx + 4;
        return ret;
    }
}
public class Solution157 extends Reader4 {
    public int read(char[] buf, int n) {
        int ret4;
        char [] innerBuf = new char[4];
        int idx = 0;
        int ret = 0;
        while (n > 0) {
            ret4 = read4(innerBuf);
            int writenum = ret4;
            if (writenum > n)
                writenum = n;
            for (int i = 0; i < writenum; ++i) {
                buf[idx] = innerBuf[i];
                ++idx;
            }
            ret += writenum;
            if (ret4 != 4)
                return ret;
            n -= writenum;
        }
        return ret;
    }
    public static void main(String [] args) {
        Solution157 a = new Solution157();
        char [] buff = new char[1];
        a.read(buff, 1);
        for (int i = 0; i < buff.length; ++i)
            System.out.print(buff[i]);
        System.out.println("");
        a.read(buff, 1);
        for (int i = 0; i < buff.length; ++i)
            System.out.print(buff[i]);
        System.out.println("");
    }
}