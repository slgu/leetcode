import java.util.LinkedList;
import java.util.List;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
 */
/*0 1 2 3 4 5 6 7 8 9 */
public class Solution247 {
    private static int [] self_name = new int[] {0, 1, 8};
    public void dfs(int i, int j, char [] fill, List <String> res) {
        if (i > j) {
                                   /* add result */
            res.add(new String(fill));
            return;
        }
        if (i == j) {
            for (int k = 0; k < self_name.length; ++k) {
                fill[i] = (char)('0' + self_name[k]);
                dfs(i + 1, j - 1, fill, res);
            }
            return;
        }
        else {
            for (int k = 0; k < self_name.length; ++k) {
                if (k == 0 && i == 0)
                    continue;
                fill[i] = fill[j] = (char)('0' + self_name[k]);
                dfs(i + 1, j - 1, fill, res);
            }
            fill[i] = '6';
            fill[j] = '9';
            dfs(i + 1, j - 1, fill, res);
            fill[i] = '9';
            fill[j] = '6';
            dfs(i + 1, j - 1, fill, res);
        }
    }
    public List<String> findStrobogrammatic(int n) {
        if (n == 0)
            return new LinkedList<String>();
        List <String> res = new LinkedList <String> ();
        char [] fill = new char[n];
        dfs(0, n - 1, fill, res);
        return res;
    }
    public static void main(String [] args) {
        Solution247 a = new Solution247();
        System.out.println(a.findStrobogrammatic(1));
    }
}

