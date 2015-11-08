import util.ArrayUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by slgu1 on 10/27/15.
 */
public class Solution286 {
    static class Pair {
        public int x;
        public int y;
        public int dist;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
            dist = 0;
        }
    }
    void bfs (int i, int j) {
        Queue <Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i, j));
        int [] dx = new int[]{1,-1,0,0};
        int [] dy = new int[]{0,0,1,-1};
        while (!q.isEmpty()) {
            Pair node = q.poll();
            for (int k = 0; k < 4; ++k) {
                int xx = node.x + dx[k];
                int yy = node.y + dy[k];
                if (xx < 0 || xx >= n)
                    continue;
                if (yy < 0 || yy >= m)
                    continue;
                if (rooms[xx][yy] == 0 || rooms[xx][yy] == -1)
                    continue;
                if (rooms[xx][yy] != INF) {
                    if (rooms[xx][yy] > node.dist + 1) {
                        rooms[xx][yy] = node.dist + 1;
                        Pair addNode = new Pair(xx, yy);
                        addNode.dist = rooms[xx][yy];
                        q.add(addNode);
                    }
                }
                else {
                    rooms[xx][yy] = node.dist + 1;
                    Pair addNode = new Pair(xx, yy);
                    addNode.dist = rooms[xx][yy];
                    q.add(addNode);
                }
            }
        }
    }
    public void wallsAndGates(int[][] rooms) {
        this.rooms = rooms;
        n = rooms.length;
        if (n == 0)
            return;
        m = rooms[0].length;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (rooms[i][j] == 0)
                    bfs(i, j);
    }
    private int n;
    private int m;
    private int [][] rooms;
    private static final int INF = 2147483647;
    public static void main(String [] args) {
        int [][] rooms = new int[][]{
                {INF,  -1,  0, INF},
                {INF, INF, INF,  -1},
                {INF,  -1, INF,  -1},
                {0, -1, INF, INF}
        };
        Solution286 a = new Solution286();
        a.wallsAndGates(rooms);
        ArrayUtil.printarr(rooms);
    }
}
