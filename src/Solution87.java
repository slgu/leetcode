/**
 * Created by slgu1 on 9/2/15.
 */
//TODO write in blog
//记忆化DP加cut
public class Solution87 {
    private int scramble(int x1, int x2, int k){
        if(similar[x1][x2][k] != 0)
            return similar[x1][x2][k];
        if(k == 0){
            if(s1.charAt(x1) == s2.charAt(x2))
                return similar[x1][x2][k] = 1;
            else
                return similar[x1][x2][k] = 2;
        }
        //cut
        int [] cut_num = new int[26];
        for(int i = 0; i < 26; ++i)
            cut_num[i] = 0;
        for(int i = 0; i <= k; ++i){
            ++cut_num[s1.charAt(x1 + i) - 'a'];
            --cut_num[s2.charAt(x2 + i) - 'a'];
        }
        for(int i = 0; i < 26; ++i) {
            if (cut_num[i] != 0)
                return similar[x1][x2][k] = 2;
        }
        //枚举
        for(int l1 = 0; l1 < k; ++l1){
            int l2 = k - l1 - 1;
            if(scramble(x1,x2,l1) == 1 && scramble(x1 + l1 + 1, x2 + l1 + 1, l2) == 1)
                return similar[x1][x2][k] = 1;
            if(scramble(x1,x2 + l2 + 1,l1) == 1 && scramble(x1 + l1 + 1, x2, l2) == 1)
                return similar[x1][x2][k] = 1;
        }
        return similar[x1][x2][k] = 2;
    }
    public boolean isScramble(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        this.s1 = s1;
        this.s2 = s2;
        if(n1 != n2)
            return false;
        int n = n1;
        similar = new int[n][n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                for(int k = 0; k < n; ++k)
                    similar[i][j][k] = 0;
        return scramble(0,0, n - 1) == 1;
    }
    private int [][][] similar;
    private String s1, s2;
    public static void main(String [] args){
        System.out.println(new Solution87().isScramble("great","tgrea"));
    }
}
