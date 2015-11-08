import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Created by slgu1 on 9/21/15.
 */
public class Solution207_2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        if (n == 0 || n == 1)
            return true;
        out = new int[n];
        visit = new boolean[n];
        visitdown = new boolean[n];
        edge = new ArrayList <ArrayList <Integer>>();
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
                if(!dfs(i))
                    return false;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!visit[i])
                return false;
        }
        return true;
    }
    private boolean dfs(int x) {
        visit[x] = true;
        for (int i = 0; i < edge.get(x).size(); ++i) {
            int y = edge.get(x).get(i);
            if (visit[y]) {
                if (!visitdown[y])
                    return false;
            }
            else {
                if (!dfs(y))
                    return false;
            }
        }
        visitdown[x] = true;
        return true;
    }
    private int n;
    private int [] out;
    private boolean [] visit;
    private boolean [] visitdown;
    private ArrayList < ArrayList<Integer>> edge;
}