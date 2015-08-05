/**
 * Created by gsl on 7/13/15.
 */

import java.util.*;

public class Solution54 {
    //这题目可以直接搜索,因为每次要转方向一定是顺时针转向
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new LinkedList<Integer>();
        }
        int x = 0;
        int y = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        //gogogogo


        LinkedList <Integer> result = new LinkedList<Integer>();
        while(true){
            result.add(matrix[x][y]);
            if(x < (n + 1) / 2){
                if(y >= x - 1 && y < m - x - 1){
                    ++y;
                    continue;
                }
            }
            if(x >= (n + 1) / 2){
                if(y > n - 1 - x && y <= (m - 1 - (n - 1 - x))){
                    --y;
                    continue;
                }
            }
            if(y < m / 2){
                if(x > y + 1 && x <= n - 1 - y){
                    --x;
                    continue;
                }
            }
            if(y >= m / 2){
                if(x >= m - 1 - y && x < ((n - 1) - (m - 1 - y))){
                    ++x;
                    continue;
                }
            }
            break;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Solution54().spiralOrder(new int [][]{
                { 1, 2, 3 ,4,4},
                {4, 5, 6 ,5,5},
                {7, 8, 9 ,10,6},
                {7, 8, 9 ,10,6},
                {7, 8, 9 ,10,6}
        }));
        System.out.println(new Solution54().spiralOrder(new int [][]{
                {1,2},
                {4,5},
                {4,5}
        }));
    }
}
