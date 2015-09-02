import util.ListNode;
import util.ListUtil;
import java.util.ArrayList;

/**
 * Created by gsl on 7/6/15.
 */
public class Solution37 {
    ArrayList <Integer> x_fill = new ArrayList<Integer>();
    ArrayList <Integer> y_fill = new ArrayList<Integer>();
    int search_depth;
    char [][] board;
    public static void print(char [][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j) {
                System.out.print(arr[i][j]);
                System.out.print(' ');
            }
            System.out.println("");
        }
    }
    boolean dfs(int now_pos){
        if(now_pos == search_depth)
            return true;
        int x = x_fill.get(now_pos);
        int y = y_fill.get(now_pos);
        boolean digit_usage[] = new boolean[10];
        for(int i = 0; i < 10; ++i)
            digit_usage[i] = false;

        //set v h true
        for(int i = 0; i < 9; ++i)
            if(i != x && board[i][y] != '.')
                digit_usage[board[i][y] - '0'] = true;
        for(int i = 0; i < 9; ++i)
            if(i != y && board[x][i] != '.')
                digit_usage[board[x][i] - '0'] = true;

        //set 3*3 true
        int start_x = x / 3 * 3;
        int start_y = y / 3 * 3;
        for(int i  = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j){
                if(x == start_x + i && y == start_y + j)
                    continue;;
                if(board[start_x + i][start_y + j] != '.'){
                    digit_usage[board[start_x + i][start_y + j] -'0'] = true;
                }
            }
        for(int i = 1; i <= 9; ++i){
            if(digit_usage[i] == false){
                board[x][y] = (char)('0' + i);
                if(dfs(now_pos + 1)) return true;
                //reset
                board[x][y] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        //init self-variable
        this.board = board;
        x_fill.clear();
        y_fill.clear();
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j){
                if(board[i][j] == '.'){
                    x_fill.add(i);
                    y_fill.add(j);
                }
            }
        //get search depth
        search_depth = x_fill.size();

        //dfs
        dfs(0);

        //set return variable
        board = this.board;
        print(board);
    }
    public static void main(String [] args){
        char [][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'0','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Solution37 a = new Solution37();
        a.solveSudoku(board);
    }
}
