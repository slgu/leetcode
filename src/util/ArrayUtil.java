package util;/**
 * Created by gsl on 8/7/15.
 */

import java.util.*;

public class ArrayUtil {
    public static <T> void printarr (T [][] matrix){
        System.out.println("begin print matrix");
        if(matrix == null)
            return;
        int n = matrix.length;
        if(n == 0)
            return;
        int m = matrix[0].length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j) {
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println("");
        }
    }
    public static void printarr (int [][] matrix){
        System.out.println("begin print matrix");
        if(matrix == null)
            return;
        int n = matrix.length;
        if(n == 0)
            return;
        int m = matrix[0].length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j) {
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
    }
}
