import util.ListNode;
import util.ListUtil;
import util.ArrayUtil;

/**
 * Created by slgu1 on 8/31/15.
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        //special judge
        if(nums.length == 0)
            return 0;
        int lastinsertidx = 0;
        boolean equalflg = false;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == nums[i - 1]){
                if(equalflg){
                    //pass
                }
                else{
                    ++lastinsertidx;
                    nums[lastinsertidx] = nums[i];
                }
                equalflg = true;
            }
            else{
                equalflg = false;
                ++lastinsertidx;
                nums[lastinsertidx] = nums[i];
            }
        }
        return lastinsertidx + 1;
    }
    public static void main(String [] args){
        Solution80 a = new Solution80();
        int [] b = new int[]{};
        System.out.println(a.removeDuplicates(b));
        ArrayUtil.printlineararr(b);
    }
}
