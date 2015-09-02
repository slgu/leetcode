import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/20/15.
 */

import java.util.*;

public class Solution70 {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        int f[] = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        for(int i = 3; i <= n; ++i){
            f[i] = f[i - 2] + f[i - 1];
        }
        return f[n];
    }
    public static void main(String[] args) {
    }
}
