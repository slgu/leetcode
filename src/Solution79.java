import util.ListNode;
import util.ListUtil;
/**
 * Created by slgu1 on 8/29/15.
 */
public class Solution79 {
    boolean dfs(int x, int y, int idx){
        visit[x][y] = true;
        for(int i = 0; i < 4; ++i){
            int xx = x + dic[i][0];
            int yy = y + dic[i][1];
            if(xx >= 0 && xx < n && yy >= 0 && yy < m && !visit[xx][yy] && board[xx][yy] == word.charAt(idx)){
                if(idx == (word.length() - 1))
                    return true;
                if(dfs(xx, yy, idx + 1)) return true;
            }
        }
        visit[x][y] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        visit = new boolean[n][m];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j){
                visit[i][j] = false;
            }
        this.word = word;
        this.board = board;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j) {
                if(board[i][j] == word.charAt(0)){
                    if(word.length() == 1)
                        return true;
                    if(dfs(i, j, 1)) return true;
                }
            }
        }
        return false;
    }
    public static void main(String [] args){
        Solution79 a = new Solution79();
        System.out.println(a.exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, "ABCCED"));
    }
    private String word;
    private char [][] board;
    private boolean [][] visit;
    private int n;
    private int m;
    private int [][] dic = {
        {
            -1, 0
        },
        {
            1, 0
        },
        {
            0, -1
        },
        {
            0, 1
        }
    };
}
