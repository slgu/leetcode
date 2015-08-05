/**
 * Created by gsl on 7/20/15.
 */

import java.util.*;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; --i){
            digits[i] = digits[i] + 1;
            if(digits[i] == 10){
                digits[i] = 0;
            }
            else
                return digits;
        }
        int [] result = new int[n + 1];
        result[0] = 1;
        for(int i = 1; i <= n; ++i)
            result[i] = 0;
        return result;
    }
    public static void main(String[] args) {
    }
}
