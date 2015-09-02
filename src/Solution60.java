import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/17/15.
 */

import java.util.*;

public class Solution60 {
    public String getPermutation(int n, int k) {
        boolean [] used = new boolean[n];
        for(int i = 0; i < n; ++i)
            used[i] = false;
        StringBuilder result = new StringBuilder();
        int n_step[] = new int[n + 1];
        n_step[0] = 1;
        for(int i = 1; i <= n; ++i)
            n_step[i] = i * n_step[i - 1];
        for(int i = 0; i < n; ++i){
            int num = k / n_step[n - i - 1] + 1;
            k = k % n_step[n - i - 1];
            if(k == 0){
                --num;
                k = n_step[n - i - 1];
            }
            int j = 0;
            while(true){
                if(used[j]){
                    ++j;
                    continue;
                }
                else{
                    --num;
                    if(num == 0)
                        break;
                    ++j;
                    continue;
                }
            }
            used[j] = true;
            result.append((char)(j + 1 + '0'));
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Solution60 a = new Solution60();
        for(int i = 1; i <= 6; ++i) {
            System.out.println(a.getPermutation(3, i));
        }
    }
}
