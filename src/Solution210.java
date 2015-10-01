import util.ArrayUtil;
import util.TreeLinkNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.List;

/**
 * Created by slgu1 on 9/22/15.
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        list.clear();
        if (n == 0)
            return new int[0];
        if (n == 1)
            return new int[]{0};
        out = new int[n];
        edge = new ArrayList <ArrayList<Integer>>();
        visit = new boolean[n];
        visitdown = new boolean[n];
        for (int i = 0; i < n; ++i) {
            edge.add(new ArrayList<Integer>());
            visit[i] = visitdown[i] = false;
        }
        //get edges
        for (int i = 0; i < prerequisites.length; ++i) {
            edge.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ++out[prerequisites[i][0]];
        }

        for (int i = 0; i < n; ++i) {
            if (out[i] == 0) {
                if (!dfs(i)) {
                    break;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!visitdown[i])
                return new int[]{};
        }
        int [] res = new int[n];
        int idx = n - 1;
        for (Integer item: list) {
            res[idx--] = item;
        }
        return res;
    }

    public static void main(String... args) {
        Solution210 a = new Solution210();
        int []res = a.findOrder(4, new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        });
        ArrayUtil.printlineararr(res);
    }
    private boolean dfs(int x) {
        visit[x] = true;
        for (int i = 0; i < edge.get(x).size(); ++i) {
            int y = edge.get(x).get(i);
            if (!visit[y]) {
                if (!dfs(y))
                    return false;
            }
            else {
                if (!visitdown[y]) {
                    return false;
                }
            }
        }
        list.add(x);
        visitdown[x] = true;
        return true;
    }

    private int n;
    private int [] out;
    private LinkedList <Integer> list = new LinkedList<Integer>();
    private int current;
    private boolean[] visit;
    private boolean[] visitdown;
    private ArrayList < ArrayList<Integer>> edge;
}
