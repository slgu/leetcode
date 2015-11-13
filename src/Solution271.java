import java.util.LinkedList;
import java.util.List;

/**
 * Created by slgu1 on 11/13/15.
 */
class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        int n = strs.size();
        for (int i = 0; i < strs.size(); ++i) {
            int tmp = strs.get(i).length();
            builder.append(tmp);
            builder.append(":");
            builder.append(strs.get(i));
        }
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        LinkedList <String> list = new LinkedList<String>();
        int beginIdx = 0;
        while (beginIdx < s.length()) {
            int idx = s.indexOf(':', beginIdx);
            if (idx == -1)
                break;
            int total = Integer.parseInt(s.substring(beginIdx, idx));
            list.add(s.substring(idx + 1, idx + 1 + total));
            beginIdx = idx + 1 + total;
        }
        return list;
    }
}

public class Solution271 {
    public static void main(String [] args) {
        Codec a = new Codec();
        String res = a.encode(new LinkedList<String>(){{add("a");add("b");add("c");}});
        System.out.println(res);
        List <String> res2 = a.decode(res);
        System.out.println(res2);
    }
}
