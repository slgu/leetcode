import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by slgu1 on 9/21/15.
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        if (n == 0 || n == 1)
            return true;
        out = new int[n];
        edge = new ArrayList <ArrayList <Integer>>();
        for (int i = 0; i < n; ++i) {
            edge.add(new ArrayList<Integer>());
        }
        Queue <Integer> queue = new LinkedList<Integer>();
        //get edges
        for (int i = 0; i < prerequisites.length; ++i) {
            edge.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ++out[prerequisites[i][0]];
        }
        for (int i = 0; i < n; ++i) {
            if (out[i] == 0)
                queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            ++count;
            if (count == n)
                break;
            for (int i = 0; i < edge.get(idx).size(); ++i) {
                int y = edge.get(idx).get(i);
                --out[y];
                if (out[y] == 0)
                    queue.add(y);
            }
        }
        return count == n;
    }
    private int n;
    private int [] out;
    private ArrayList < ArrayList<Integer>> edge;
}