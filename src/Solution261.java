/**
 * Created by slgu1 on 11/13/15.
 */
/*
    add a rank to a node, balance it.
    time complexity min(m, n) * log(n)
 */
public class Solution261 {
    private int getFather(int k) {
        if (father[k] == -1)
            return k;
        else
            return father[k] = getFather(father[k]);
    }
    public boolean validTree(int n, int[][] edges) {
        father = new int[n];
        for (int i = 0; i < n; ++i)
            father[i] = -1;
        for (int i = 0; i < edges.length; ++i) {
            int x = edges[i][0];
            int y = edges[i][1];
            int fx = getFather(x);
            int fy = getFather(y);
            if (fx == fy)
                return false;
            father[fx] = fy;
        }
        int thisFather = -1;
        for (int i = 0; i < n; ++i) {
            int tmp = getFather(i);
            if (thisFather == -1)
                thisFather = tmp;
            else if (tmp != thisFather)
                return false;
        }
        return true;
    }
    public static void main(String [] args) {
        Solution261 a = new Solution261();
        System.out.println(a.validTree(2, new int[][]{
                /*
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {1,4}
                */
        }));
    }
    private int [] father;
}