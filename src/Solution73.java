/**
 * Created by gsl on 8/7/15.
 */

import java.util.*;
import util.ArrayUtil;
//除了这样使用标志位判断，还可以将本来的bool数组 放在第一行第一列，其中第一行第一列通过bool数组特别判断
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        final int special_num1 = 1827287112;//row done
        final int special_num2 = 1237192371;//col done
        final int special_num3 = 1237102333;//both done
        int n = matrix.length;
        if(n == 0)
            return;
        int m = matrix[0].length;
        if(m == 0)
            return;
        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    //change to special_num first
                    if (i != 0 && (matrix[i - 1][j] == special_num1 || matrix[i - 1][j] == special_num3 || matrix[i - 1][j] == 0)) {
                        //has done
                    } else {
                        //change by i
                        for (int k = 0; k < n; ++k) {
                            if (matrix[k][j] != 0) {
                                if (matrix[k][j] == special_num2) {
                                    matrix[k][j] = special_num3;
                                } else if (matrix[k][j] == special_num3) {
                                } else {
                                    matrix[k][j] = special_num1;
                                }
                            }
                        }
                    }

                    if (j != 0 && (matrix[i][j - 1] == special_num2 || matrix[i][j - 1] == special_num3 || matrix[i][j - 1] == 0)) {
                        //has done
                    } else {
                        //change by i
                        for (int k = 0; k < m; ++k) {
                            if(matrix[i][k] != 0) {
                                if (matrix[i][k] == special_num1) {
                                    matrix[i][k] = special_num3;
                                } else if (matrix[i][k] == special_num3) {
                                } else {
                                    matrix[i][k] = special_num2;
                                }
                            }
                        }
                    }
                }
            }
        }
        //change special num to 0
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                if(matrix[i][j] == special_num1 || matrix[i][j] == special_num2 || matrix[i][j] == special_num3)
                    matrix[i][j] = 0;
    }
    public static void main(String[] args) {
        Solution73 a = new Solution73();
        a.setZeroes(new int[][]{
                {0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}
        });
    }
}
