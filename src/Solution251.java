import java.util.*;

/**
 * Created by slgu1 on 11/13/15.
 */
class Vector2D {

    private Iterator <List <Integer>> outer_itr;
    private Iterator <Integer> inner_itr;
    public Vector2D(List<List<Integer>> vec2d) {
        outer_itr = vec2d.iterator();
        inner_itr = null;
    }

    public int next() {
        return inner_itr.next();
    }

    public boolean hasNext() {
        if (inner_itr != null && inner_itr.hasNext())
            return true;
        if (outer_itr.hasNext()) {
            while (outer_itr.hasNext()) {
                inner_itr = outer_itr.next().iterator();
                if (inner_itr.hasNext())
                    return true;
            }
        }
        return false;
    }
}
public class Solution251 {
    public static void main(String [] args) {
        final LinkedList <Integer> a1 = new LinkedList<Integer>(){{add(1);add(2);}};
        final LinkedList <Integer> a2 = new LinkedList<Integer>(){{add(3);}};
        final LinkedList <Integer> a3 = new LinkedList<Integer>(){{add(4);add(5);add(6);}};
        LinkedList <List <Integer>> test =
                new LinkedList<List<Integer>>(){{add(a1);add(a2);add(a3);}};
        Vector2D a = new Vector2D(test);
        while(a.hasNext()) {
            System.out.println(a.next());
        }
    }
}
