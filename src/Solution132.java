/**
 * Created by slgu1 on 9/10/15.
 */
public class Solution132 {
    public int minCut(String s) {
        this.s = s;
        this.n = s.length();
        palin = new boolean[n][n];
        for(int l = 0; l < n; ++l) {
            for(int i = 0; l + i < n; ++i) {
                if(l == 0) {
                    palin[i][l] = true;
                    continue;
                }
                if(s.charAt(i) == s.charAt(i + l)){
                    if(l == 1){
                        palin[i][l] = true;
                    }
                    else{
                        palin[i][l] = palin[i + 1][l - 2];
                    }
                }
                else{
                    palin[i][l] = false;
                }
            }
        }
        int [] mincut = new int[n];
        for(int i = 0; i < n; ++i){
            if (i == 0){
                mincut[i] = 0;
                continue;
            }
            mincut[i] = -1;
            for(int k = i; k >= 0; --k){
                if(palin[k][i - k]){
                    if(k == 0){
                        mincut[i] = 0;
                        break;
                    }
                    else{
                        if(mincut[i] == -1 || mincut[k - 1] + 1 < mincut[i])
                            mincut[i] = mincut[k - 1] + 1;
                    }
                }
            }
        }
        return mincut[n - 1];
    }
    public static void main(String [] args){
        Solution132 a = new Solution132();
        System.out.println(a.minCut("efe"));
    }
    private String s;
    private int n;
    private boolean [][] palin;
}
