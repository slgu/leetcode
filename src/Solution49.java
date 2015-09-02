import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/13/15.
 */

import java.util.*;

public class Solution49 {
    public static String sort_str(String str){
        char [] tmp_arr = str.toCharArray();
        Arrays.sort(tmp_arr);
        return String.valueOf(tmp_arr);
    }
    public List<String> anagrams(String[] strs) {
        int n = strs.length;
        Map <String, List<String> > mp = new HashMap<String, List<String>>();
        mp.clear();
        for(int i = 0; i < n; ++i){
            String tmp = sort_str(strs[i]);
            //insert origin to map
            if(mp.containsKey(tmp)){
                mp.get(tmp).add(strs[i]);
            }
            else{
                List <String> key_list = new LinkedList<String>();
                key_list.add(strs[i]);
                mp.put(tmp, key_list);
            }
            strs[i] = tmp;
        }
        Arrays.sort(strs);
        List <String> result_list = new LinkedList<String>();
        for(int i = 0; i < n - 1; ++i){
            if(strs[i].compareTo(strs[i + 1]) == 0)
                 result_list.addAll(mp.get(strs[i]));
            while (i < n -1 && strs[i].compareTo(strs[i + 1]) == 0)
                ++i;
        }
        return result_list;
    }
    public static void main(String[] args) {
        Solution49 a = new Solution49();
        System.out.println(a.anagrams(new String[]{"abc", "def", "cab", "bca"}));
    }
}
