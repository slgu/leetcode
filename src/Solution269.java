import util.ArrayUtil;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by slgu1 on 11/13/15.
 */
public class Solution269 {
    public String alienOrder(String[] words) {
        int n = words.length;
        boolean used[] = new boolean[26];
        boolean edges[][] = new boolean[26][26];
        int inDegree[] = new int[26];
        for (int i = 0; i < 26; ++i) {
            used[i] = false;
            inDegree[i] = 0;
            for (int j = 0; j < 26; ++j)
                edges[i][j] = false;
        }
        if (words.length == 0)
            return "";

        //set used for idx:0
        for (int j = 0; j < words[0].length(); ++j)
            used[words[0].charAt(j) - 'a'] = true;

        for (int i = 1; i < n; ++i) {

            //set used
            for (int j = 0; j < words[i].length(); ++j)
                used[words[i].charAt(j) - 'a'] = true;

            //compare to last
            int len = words[i - 1].length();
            int len1 = words[i].length();
            if (len > len1)
                len = len1;
            for (int k = 0; k < len; ++k) {
                char c1 = words[i].charAt(k);
                char c2 = words[i - 1].charAt(k);
                if (c1 != c2) {
                    ++inDegree[c2 - 'a'];
                    edges[c1 - 'a'][c2 - 'a'] = true;
                    break;
                }
            }
        }
        //toposort
        int total = 0;
        for (int i = 0; i < 26; ++i)
            if (used[i])
                ++total;
        StringBuilder builder = new StringBuilder();
        while ((total--) != 0) {
            int idx = -1;
            for (int i = 0; i < 26; ++i)
                if (used[i] && inDegree[i] == 0) {
                    idx = i;
                    break;
                }
            if (idx == -1)
                return "";
            builder.append((char)('a' + idx));
            for (int j = 0; j < 26; ++j)
                if (used[j] && edges[idx][j])
                    --inDegree[j];
            //set unused
            used[idx] = false;
        }
        return builder.reverse().toString();
    }
    public static void main(String [] args) {
        Solution269 a = new Solution269();
        System.out.println(a.alienOrder(new String[]{
                "z",
                "x"
        }));
    }
}
