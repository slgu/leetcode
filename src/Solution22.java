import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gsl on 7/3/15.
 */
public class Solution22 {
    static Map <Integer, List<String>> mp = new HashMap<Integer, List<String>>();

    public List<String> generateParenthesis(int n) {
        if(n == 0){
            mp.put(0,new ArrayList<String>(){{add("");}});
            return mp.get(0);
        }
        else
        if(n == 1){
            mp.put(1,new ArrayList<String>(){{add("()");}});
            return mp.get(1);
        }
        if(mp.containsKey(n)){
            return mp.get(n);
        }
        List <String> result = new ArrayList<String>();
        for(int i = 0; i <= n - 1; ++ i){
            int left = i;
            int right = n - 1 - i;
            List<String> left_arr = generateParenthesis(i);
            List<String> right_arr = generateParenthesis(n - 1 - i);
            for(String left_item: left_arr){
                for(String right_item:right_arr){
                    result.add("(" + left_item + ")" + right_item);
                }
            }
        }
        mp.put(n, result);
        return result;
    }
    public static void main(String [] args){
        Solution22 a = new Solution22();
        System.out.println(a.generateParenthesis(3));
    }
}
