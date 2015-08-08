/**
 * Created by gsl on 8/8/15.
 */

import java.util.*;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) return false;
        int m = matrix[0].length;
        if(m == 0) return false;
        int l = 0;
        int r = n * m - 1;
        while(l <= r){
            int middle = (l + r) >> 1;
            int xi = middle / m;
            int yi = middle % m;
            if(matrix[xi][yi] == target){
                return true;
            }
            else if (matrix[xi][yi] < target){
                l = middle + 1;
            }
            else{
                r = middle - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    }
}
