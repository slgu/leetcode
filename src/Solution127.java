import util.StringUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

/**
 * Created by slgu1 on 9/15/15.
 */
public class Solution127 {

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set <String> visit = new HashSet<String>();
        Map <String, Integer> mp = new HashMap<String, Integer>();
        mp.put(endWord, 1);
        Set <String> now_work = new HashSet<String>();
        Set <String> next_work = new HashSet<String>();
        now_work.add(endWord);
        wordDict.add(beginWord);
        wordDict.remove(endWord);
        while(true){
            for(String item: now_work){
                int step = mp.get(item);
                int l = item.length();
                for(int i = 0; i < l; ++i){
                    for(int j = 'a'; j <= 'z'; ++j) {
                        if(item.charAt(i) == j)
                            continue;
                        String change = item.substring(0,i);
                        change = change + (char)j;
                        change = change + item.substring(i + 1);
                        if(wordDict.contains(change)){
                            wordDict.remove(change);
                            mp.put(change, step + 1);
                            next_work.add(change);
                        }
                    }
                }
            }
            if(next_work.size() == 0)
                break;
            if(mp.containsKey(beginWord))
                break;
            Set <String> tmp = now_work;
            now_work = next_work;
            next_work = tmp;
            next_work.clear();
        }
        if(mp.containsKey(beginWord)){
            return mp.get(beginWord);
        }
        else{
            return 0;
        }
    }

    public static void main(String [] args){
        Solution127 a = new Solution127();
        String begin = "hit";
        String end = "cog";
        Set <String> wordlist = new HashSet<String>();
        wordlist.add("hot");
        wordlist.add("dot");
        wordlist.add("dog");
        wordlist.add("lot");
        wordlist.add("log");
        System.out.println(a.ladderLength(begin, end, wordlist));
    }
}
