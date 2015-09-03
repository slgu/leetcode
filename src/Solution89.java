/**
 * Created by slgu1 on 9/2/15.
 */
import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class Solution89 {
    private boolean dfs(int x){
        vt.addLast(x);
        visit.add(x);
        ++now_num;
        if(now_num == num){
            return true;
        }
        for(int i = 0; i < n; ++i){
            int new_x = x ^ (1 << i);
            if(!visit.contains(new_x)){
                if(dfs(new_x))
                    return true;
            }
        }
        //backtracking
        --now_num;
        vt.removeLast();
        visit.remove(x);
        return false;
    }
    public List<Integer> grayCode(int n) {
        //init
        visit.clear();
        num = (int)Math.pow(2, n);
        this.n = n;
        now_num = 0;
        dfs(0);
        return (List <Integer>) vt.clone();
    }
    private Set <Integer> visit = new HashSet<Integer>();
    private LinkedList <Integer> vt = new LinkedList<Integer>();
    private int num;
    private int n;
    private int now_num;
    public static void main(String [] args){
        Solution89 a= new Solution89();
        System.out.println(a.grayCode(2));
    }
}
