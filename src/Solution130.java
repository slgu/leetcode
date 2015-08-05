import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gsl on 15/5/12.
 */
public class Solution130 {
    int n, m;
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};
    char board [][];
    boolean checkborder(int i, int j){
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    class Point{
        int i;
        int j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    void bfs(int i, int j){
        Queue <Point> q = new LinkedList<Point>();
        q.offer(new Point(i,j));
        while(!q.isEmpty()){
            Point pop = q.poll();
            board[pop.i][pop.j] = 'K';
            for(int k = 0; k < 4; ++k){
                int di = pop.i + dx[k];
                int dj = pop.j + dy[k];
                if(checkborder(di, dj) && board[di][dj] == 'O')
                    q.offer(new Point(di, dj));
            }
        }
    }
    public void solve(char[][] board) {
        n = board.length;
        if(n == 0) return;
        m = board[0].length;
        this.board = board;
        for(int i = 0; i < n; ++i){
            if(board[i][0] == 'O') bfs(i,0);
            if(board[i][m-1] == 'O') bfs(i, m - 1);
        }
        for(int i = 0; i < m; ++i){
            if(board[0][i] == 'O') bfs(0, i);
            if(board[n-1][i] == 'O') bfs(n - 1, i);
        }
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j){
                if(board[i][j] == 'K')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
    }
    public static void main(String [] args){
        Solution130 s = new Solution130();
        char board[][] = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        s.solve(board);
        for(int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j){
                System.out.print(board[i][j]);
                System.out.print(' ');
            }
            System.out.println("");
        }
    }
}
