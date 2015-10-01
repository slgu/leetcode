/**
 * Created by slgu1 on 9/30/15.
 */
import com.sun.javafx.binding.SelectBinding;

import java.util.*;

public class Solution140 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        //init
        this.s = s;
        this.wordDict = wordDict;
        this.n = s.length();
        mp_res.clear();
        mp_res.put(n, new LinkedList<String>(){{add("");}});
        return dfs(0);
    }

    public static void main(String... args) {
        HashSet <String> hashSet = new HashSet<String>();
        hashSet.add("cat");
        hashSet.add("cats");
        hashSet.add("and");
        hashSet.add("sand");
        hashSet.add("dog");
        System.out.println(new Solution140().wordBreak("catsanddog", hashSet));
    }

    private LinkedList <String> dfs(int i) {
        //memorize
        if (mp_res.containsKey(i)) {
            return mp_res.get(i);
        }
        LinkedList <String> res = new LinkedList<String>();
        for (int j = i; j < n; ++j) {
            if (wordDict.contains(s.substring(i, j + 1))) {
                dfs(j + 1);
                for (String item: mp_res.get(j + 1)) {
                    if (item.equals("")) {
                        res.add(s.substring(i, j + 1));
                    }
                    else {
                        res.add(s.substring(i, j + 1) + " " + item);
                    }
                }
            }
        }
        mp_res.put(i, res);
        return res;
    }

    private String s;
    private Set <String> wordDict;
    private Map <Integer, LinkedList <String>> mp_res = new HashMap<Integer, LinkedList<String>>();
    private int n;
}
