import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/13/15.
 */

import java.util.*;

public class Solution48 {
    public void printmatrix(int [][] a){
        int n = a.length;
        int m = a[0].length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                System.out.print(a[i][j]);
                System.out.print(' ');
            }
            System.out.println("");
        }
    }
    public void rotate(int[][] matrix) {
        printmatrix(matrix);
        int n = matrix.length;
        if(n % 2 != 0) {
            int center = n / 2;
            for (int i = 0; i <= n / 2; ++i)
                for (int j = 1; j <= n / 2; ++j) {
                    //rotate
                    int tmp = matrix[center + j][center + i];
                    matrix[center + j][center + i] = matrix[center - i][center + j];
                    matrix[center - i][center + j] = matrix[center - j][center - i];
                    matrix[center - j][center - i] = matrix[center + i][center - j];
                    matrix[center + i][center - j] = tmp;
                }
        }
        else{
            int center = n / 2;
            for (int i = 1; i <= n / 2; ++i)
                for (int j = 1; j <= n / 2; ++j) {
                    //rotate
                    int tmp = matrix[center + j - 1][center + i - 1];
                    matrix[center + j - 1][center + i - 1] = matrix[center - i][center + j - 1];
                    matrix[center - i][center + j - 1] = matrix[center - j][center - i];
                    matrix[center - j][center - i] = matrix[center + i - 1][center - j];
                    matrix[center + i - 1][center - j] = tmp;
                }
        }
        printmatrix(matrix);
    }
    public static void main(String[] args) {
        Solution48 a = new Solution48();
        a.rotate(new int[][]{{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}});
        a.rotate(new int[][]{{1,2,3},{1,2,3},{1,2,3}});
    }
}
