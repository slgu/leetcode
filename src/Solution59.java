/**
 * Created by gsl on 7/17/15.
 */

import java.util.*;

public class Solution59 {
    public static void printmatrix(int [][]matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println("");
        }
    }
    public int[][] generateMatrix(int n) {
        int count = n * n;
        int [][] matrix = new int[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                matrix[i][j] = 0;
        int [][]direct = {
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };
        int stx = 0;
        int sty = 0;
        int new_stx,new_sty;
        int now_direct = 0;
        for(int i = 1; i <= count; ++i){
            matrix[stx][sty] = i;
            new_stx = stx + direct[now_direct][0];
            new_sty = sty + direct[now_direct][1];
            if(new_stx >= 0 && new_sty >= 0 && new_sty < n && new_stx < n && matrix[new_stx][new_sty] == 0){
                stx = new_stx;
                sty = new_sty;
            }
            else {
                now_direct = (now_direct + 1) % 4;
                stx = stx + direct[now_direct][0];
                sty = sty + direct[now_direct][1];
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        Solution59 a = new Solution59();
        printmatrix(a.generateMatrix(5));
    }
}
