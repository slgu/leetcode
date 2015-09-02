import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/4/15.
 */
import  java.util.*;
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || words == null || words.length == 0)
            return null;

        //main str length
        int n = s.length();

        //same length l
        int l = words[0].length();
        int total_words_num = words.length;
        //set mp words
        HashMap <String, Integer> mp_words = new HashMap<String, Integer>();
        for(String word: words){
            if(mp_words.containsKey(word)){
                mp_words.put(word, mp_words.get(word) + 1);
            }
            else{
                mp_words.put(word, 1);
            }
        }

        //now cursor words
        HashMap <String, Integer> now_cur_words = new HashMap<String, Integer>();
        List <Integer> result_list = new ArrayList<Integer>();
        for(int i = 0; i < l; ++i){
            now_cur_words.clear();
            int count = 0;
            int left = i;
            for(int j = i; j + l <= n; j += l) {
                String cur_str = s.substring(j, j + l);
                if (mp_words.containsKey(cur_str)) {
                    if(now_cur_words.containsKey(cur_str)){
                        now_cur_words.put(cur_str, now_cur_words.get(cur_str) + 1);
                    }
                    else{
                        now_cur_words.put(cur_str, 1);
                    }
                    if(now_cur_words.get(cur_str) <= mp_words.get(cur_str)){
                        ++count;
                    }
                    else{
                        while ( (now_cur_words.get(cur_str) > mp_words.get(cur_str)) &&(left < j)){
                            String tmp = s.substring(left, left + l);
                            now_cur_words.put(tmp, now_cur_words.get(tmp) - 1);
                            //slide right decrease count and add left
                            --count;
                            left = left + l;
                        }
                        //add now cursor word count
                        ++count;
                    }
                    if(count == total_words_num){
                        result_list.add(left);
                        //slide right decrease count and add left
                        --count;
                        String tmp = s.substring(left,left + l);
                        now_cur_words.put(tmp, now_cur_words.get(tmp) - 1);
                        left = left + l;
                    }
                } else {
                    now_cur_words.clear();
                    count = 0;
                    left = j + l;
                }
            }
        }
        return result_list;
    }
    public static void main(String [] args){
        //System.out.println(kmp("ababababab","abab"));
        Solution30 a = new Solution30();
        System.out.println(a.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }
}
