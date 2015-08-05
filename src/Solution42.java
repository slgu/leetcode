/**
 * Created by gsl on 7/7/15.
 */

import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;

import java.util.*;

public class Solution42 {
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        int maxn = height[0];
        int index = 0;
        int n = height.length;
        int [] sum = new int[n];
        sum[0] = height[0];
        for(int i = 1; i < n; ++i)
            sum[i] = sum[i - 1] + height[i];
        int result_volume = 0;
        for(int i = 0; i < n; ++i){
            if(height[i] >= maxn){
                if(i - index > 1) {
                    result_volume += (maxn * (i - index - 1) - (sum[i - 1] - sum[index]));
                }
                maxn = height[i];
                index = i;
            }
        }
        maxn = height[n - 1];
        index = n - 1;
        for(int i = n - 2; i >= 0; --i){
            if(height[i] > maxn){
                if(index - i > 1){
                    result_volume += (maxn * (index - i - 1) - (sum[index - 1] - sum[i]));
                }
                maxn = height[i];
                index = i;
            }
        }
        return result_volume;
    }
    public static void main(String[] args) {
        System.out.println(new Solution42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
