/**
 * Created by slgu1 on 11/11/15.
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int begin_i = n - 1;
        int begin_j = 0;
        while (true) {
            if (matrix[begin_i][begin_j] < target) {
                if (begin_j == m - 1)
                    break;
                ++begin_j;
            }
            else if (matrix[begin_i][begin_j] == target) {
                return true;
            }
            else {
                if (begin_i == 0)
                    break;
                --begin_i;
            }
        }
        return false;
    }
    public static void main(String [] args) {
        Solution240 a = new Solution240();
        System.out.println(a.searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 20));
    }
}
