/**
 * Created by gsl on 7/13/15.
 */

import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;

import java.util.*;

public class Solution51 {
    private static List <String> get_result(int [] place){
        int n = place.length;
        List <String> result = new LinkedList<String>();
        for(int i = 0; i < n; ++i){
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < n; ++j){
                if(place[i] == j){
                    builder.append('Q');
                }
                else {
                    builder.append('.');
                }
            }
            result.add(builder.toString());
        }
        return result;
    }
    private int [] place;
    private int n;
    private List < List <String> > result = new LinkedList<List<String>>();
    private void dfs(int x){
        if(x == n){
            //ok this is an answer
            result.add(get_result(place));
        }
        for(int pos = 0; pos < n; ++pos){
            boolean can_flg = true;
            for(int i = 0; i < x; ++i){
                if(place[i] == pos || place[i] - pos == i - x || place[i] - pos == x - i){
                    can_flg = false;
                    break;
                }
            }
            if(can_flg){
                place[x] = pos;
                dfs(x + 1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        place = new int[n];
        this.n = n;
        result.clear();
        dfs(0);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Solution51().solveNQueens(4));
    }
}
