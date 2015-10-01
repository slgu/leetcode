package util;

/**
 * Created by slgu1 on 9/21/15.
 */
import java.util.List;
import java.util.ArrayList;

public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
