/**
 * Created by gsl on 7/20/15.
 */

import java.util.*;

//matrix fast mi
public class Solution70_2 {
    public void mul_matrix(int [][] a, int [][] b){
        int n = a.length;
        int c[][] = new int[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j){
                c[i][j] = 0;
                for(int x = 0; x < n; ++x)
                    c[i][j] += a[i][x] * b[x][j];
            }
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                a[i][j] = c[i][j];
    }
    public int climbStairs(int n) {
        int init_m[][] = new int[][]{
                {1,1},
                {1,0}
        };
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int res[][] = new int [][]{
                {1,0},
                {0,1}
        };
        int number = n - 2;
        while(number != 0){
            if((number & 1) != 0){
                mul_matrix(res, init_m);
            }
            mul_matrix(init_m, init_m);
            number >>= 1;
        }
        return res[0][0] * 2 + res[0][1];
    }
    public static void main(String[] args) {
        System.out.println(new Solution70_2().climbStairs(5));
    }
}
