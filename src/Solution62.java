/**
 * Created by gsl on 7/19/15.
 */

import java.util.*;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        --m;
        --n;
        if(m >= n){
            int tmp = m;
            m = n;
            n = tmp;
        }
        if(n == 0 && m == 0)
            return 1;
        //combine number
        int [][] combine = new int[n + m + 1][m + 1];
        for(int i = 1; i <= n + m; ++i){
            combine[i][0] = 1;
            for(int j = 1; j <= i && j <= m; ++j){
                if(i == j)
                    combine[i][j] = 1;
                else
                    combine[i][j] = combine[i - 1][j - 1] + combine[i - 1][j];
            }
        }
        return combine[n + m][m];
    }
    public static void main(String[] args) {
    }
}
