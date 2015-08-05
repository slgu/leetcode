/**
 * Created by gsl on 7/20/15.
 */

import java.util.*;

public class Solution68 {
    public String make_string(String [] words, int i, int j, int nl, int l){
        StringBuilder res = new StringBuilder();
        res.append(words[i]);
        int nu = j - i;
        if(nu == 0){
            for(int x = 0; x < l - nl; ++x)
                res.append(' ');
            return res.toString();
        }
        int per = (l - nl) / nu;
        int extra = l - nl - nu * per;
        for(int k = 0; k < nu; ++k){
            int need_space = per;
            if(k + 1 <= extra){
                need_space += 1;
            }
            for(int x = 0; x < need_space; ++x)
                res.append(' ');
            //add string
            res.append(words[i + k + 1]);
        }
        return res.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        if(words.length == 0)
            return new ArrayList<String>();
        int nl = words[0].length();
        int n = words.length;
        int last = 0;
        List <String> result = new ArrayList<String>();
        for(int i = 1; i < n; ++i){
            if(nl + words[i].length() + i - last > maxWidth){
                result.add(make_string(words, last, i - 1, nl, maxWidth));
                last = i;
                nl = words[i].length();
            }
            else{
                nl += words[i].length();
            }
        }
        StringBuilder lastline = new StringBuilder();
        lastline.append(words[last]);
        for(int i = last + 1; i <= n - 1; ++i) {
            lastline.append(' ');
            lastline.append(words[i]);
        }
        for(int i = 0; i < maxWidth - (nl + (n - 1) - last); ++i)
            lastline.append(' ');
        result.add(lastline.toString());
        return result;
    }
    public static void main(String[] args) {
        Solution68 a = new Solution68();
        System.out.println(a.fullJustify(new String[]{
                "This", "is", "an", "example", "of", "text", "justification."
        }, 16));
        System.out.println(a.fullJustify(new String[]{
                "Listen","to","many,","speak","to","a","few."
        }, 6));
    }
}
