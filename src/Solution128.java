import java.util.HashSet;
import java.util.Set;

/**
 * Created by slgu1 on 9/7/15.
 */
//core algorithm: hash!! in 0(n)
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Set <Integer> num_set = new HashSet<Integer>();
        for(int item:nums){
            num_set.add(item);
        }
        int res = 0;
        for(int item:nums){
            if(!num_set.contains(item)){
                continue;
            }
            int count = 1;
            int current = item;
            while(true){
                --current;
                if(num_set.contains(current)){
                    ++count;
                    num_set.remove(current);
                }
                else{
                    break;
                }
            }
            current = item;
            while(true){
                ++current;
                if(num_set.contains(current)){
                    ++count;
                    num_set.remove(current);
                }
                else{
                    break;
                }
            }
            if(res < count)
                res = count;
        }
        return res;
    }
}
