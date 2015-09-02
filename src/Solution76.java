import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 8/8/15.
 */


import java.util.*;

public class Solution76 {
    public String minWindow(String s, String t) {
        int l_s = s.length();
        int l_t = t.length();
        //special judge
        if(l_t == 0) return "";
        if(l_t > l_s) return "";

        Map <Integer, Integer> mp_used = new HashMap<Integer, Integer>();
        Map <Integer, Integer> mp_need = new HashMap<Integer, Integer>();

        //map need
        for(int i = 0; i < l_t; ++i){
            int key = (int)t.charAt(i);
            if(mp_need.containsKey(key)){
                mp_need.put(key, mp_need.get(key) + 1);
            }
            else{
                mp_need.put(key, 1);
                //used number 0
                mp_used.put(key, 0);
            }
        }

        //iterate and get jump-table
        LinkedList <Integer> deque = new LinkedList<Integer>();
        int count = 0;
        int min_length = -1;
        int li = 0, ri = 0;
        for(int i = 0; i < l_s; ++i){
            int key = (int)s.charAt(i);
            if(mp_need.containsKey(key)){
                //add to deque
                deque.addFirst(i);
                //may add count
                if(mp_used.get(key) < mp_need.get(key)) {
                    ++count;
                }
                mp_used.put(key, mp_used.get(key) + 1);
                //delete from last for un needed key
                while(!deque.isEmpty()){
                    Integer last_key = (int)s.charAt(deque.getLast());
                    //more number no need
                    if(mp_used.get(last_key) > mp_need.get(last_key)){
                        mp_used.put(last_key, mp_used.get(last_key) - 1);
                        deque.removeLast();
                        continue;
                    }
                    else
                        break;
                }
                if(count == t.length()){
                    //reach result update min length
                    int l = deque.getLast();
                    if(min_length == -1 || min_length > i - l){
                        min_length = i - l;
                        li = l;
                        ri = i;
                    }
                }
            }
        }
        if(min_length == -1){
            return "";
        }
        else{
            return s.substring(li, ri + 1);
        }
    }
    public static void main(String[] args) {
        Solution76 a = new Solution76();
        System.out.println(a.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(a.minWindow("aa","aa"));
    }
}
