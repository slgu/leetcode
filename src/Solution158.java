public class Solution158 extends Reader4 {
    private char [] innerBuf = new char[4];
    private int innerBufCnt = 0;
    private int start = 0;
    public int read(char[] buf, int n) {
        int ret4;
        char [] tmpBuf = new char[4];
        int idx = 0;
        int ret = 0;
        /* first read data from buffer */
        int writenum = innerBufCnt;
        if (writenum > n)
            writenum = n;
        for (int i = 0; i < writenum; ++i) {
            buf[idx] = innerBuf[start + i];
            ++idx;
        }
        innerBufCnt -= writenum;
        start += writenum;
        ret = writenum;
        n -= writenum;
        /* read from file */
        while (n > 0) {
            ret4 = read4(tmpBuf);
            writenum = ret4;
            if (writenum > n)
                writenum = n;
            for (int i = 0; i < writenum; ++i) {
                buf[idx] = tmpBuf[i];
                ++idx;
            }
            ret += writenum;
            n -= writenum;
            if (n == 0) {
                /* maybe read more useless data from file */
                if (ret4 >= writenum) {
                    start = 0;
                    for (int i = writenum; i < ret4; ++i)
                        innerBuf[i - writenum] = tmpBuf[i];
                    innerBufCnt = ret4 - writenum;
                }
            }
            if (ret4 != 4)
                return ret;
        }
        return ret;
    }
    public static void main(String [] args) {
        Solution158 a = new Solution158();
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
