import java.util.LinkedList;

/**
 * Created by slgu1 on 10/23/15.
 */
public class Solution165_2 {
    public int compareVersion(String version1, String version2) {
        String [] v1_str = version1.split("\\.");
        String [] v2_str = version2.split("\\.");
        int n1 = v1_str.length;
        int n2 = v2_str.length;
        int n = n1;
        if (n2 > n1)
            n = n2;
        for (int i = 0; i < n; ++i) {
            int v1_i = 0;
            if (i < n1)
                v1_i = Integer.parseInt(v1_str[i]);
            int v2_i = 0;
            if (i < n2)
                v2_i = Integer.parseInt(v2_str[i]);
            if (v1_i < v2_i)
                return -1;
            if (v1_i > v2_i)
                return 1;
        }
        return 0;
    }
    public static void main(String [] args) {
        Solution165_2 a = new Solution165_2();
        System.out.println(a.compareVersion("0.1", "1.1"));
        System.out.println(a.compareVersion("1.1", "1.2"));
        System.out.println(a.compareVersion("1.2", "13.3"));
        System.out.println(a.compareVersion("1.2", "1.1"));
    }
}