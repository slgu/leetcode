import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/13/15.
 */

import java.util.*;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int maxn = -1000000000;
        int last_maxn = 0;
        for(int i  = 0; i < nums.length; ++i){
            if(last_maxn < 0){
                last_maxn = nums[i];
            }
            else{
                last_maxn = last_maxn + nums[i];
            }
            if(maxn < last_maxn)
                maxn = last_maxn;
        }
        return maxn;
    }
    public static void main(String[] args) {
    }
}
