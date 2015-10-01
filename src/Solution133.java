/**
 * Created by slgu1 on 9/21/15.
 */
import util.UndirectedGraphNode;

import java.util.*;

public class Solution133 {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        mp_edge.clear();
        mp_label.clear();
        visit.clear();
        dfs(node);
        //clone new nodes
        UndirectedGraphNode [] nodes = new UndirectedGraphNode[n];
        //add edges
        for (int i = 0; i < n; ++i) {
            nodes[i] = new UndirectedGraphNode(mp_edge.get(i).label);
        }
        for (int i = 0; i < n; ++i) {
            for (UndirectedGraphNode nodeitem: mp_edge.get(i).neighbors) {
                int nextidx = mp_label.get(nodeitem.label);
                // add edge
                nodes[i].neighbors.add(nodes[nextidx]);
            }
        }
        return nodes[0];
    }
    private Map <Integer, Integer> mp_label = new HashMap<Integer, Integer>();
    private ArrayList <UndirectedGraphNode>  mp_edge = new ArrayList<UndirectedGraphNode>();
    private int n;
    private Set <Integer> visit = new HashSet<Integer>();
    private void dfs(UndirectedGraphNode node) {
        //add node num
        visit.add(node.label);
        mp_edge.add(node);
        mp_label.put(node.label, n);
        ++n;
        for (UndirectedGraphNode nodeitem: node.neighbors) {
            if (!visit.contains(nodeitem.label)) {
                dfs(nodeitem);
            }
        }
    }
}
