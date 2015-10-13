/**
 * Created by slgu1 on 10/7/15.
 */
public class Solution151 {
    public String reverseWords(String s) {
        if (s == null)
            return null;
        if (s.length() == 0)
            return "";
        StringBuilder builder = new StringBuilder();
        StringBuilder wordbuilder = new StringBuilder();
        int n = s.length();
        boolean flag = false;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == ' ') {
                if (flag) {
                    builder.append(wordbuilder.reverse());
                    wordbuilder = new StringBuilder();
                    flag = false;
                    builder.append(' ');
                }
            }
            else {
                flag = true;
                wordbuilder.append(s.charAt(i));
            }
        }
        if (flag) {
            builder.append(wordbuilder.reverse());
        }
        else {
            if (builder.length() != 0)
                builder.deleteCharAt(builder.length() - 1);
        }
        return builder.reverse().toString();
    }
    public static void main(String [] args) {
        Solution151 a = new Solution151();
        System.out.println(a.reverseWords("the sky is blue") + "$");
        System.out.println(a.reverseWords(" ") + "$");
    }
}