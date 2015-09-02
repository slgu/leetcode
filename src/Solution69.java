import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/20/15.
 */

import java.util.*;

public class Solution69 {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        int left = 1;
        int right = 46340;
        while(left < right){
            int middle = (left + right + 1) >> 1;
            if(middle * middle < x){
                left = middle;
            }
            else if(middle * middle == x) {
                return middle;
            }
            else{
                right = right - 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Solution69 a = new Solution69();
        System.out.println(a.mySqrt(1));
    }
}
