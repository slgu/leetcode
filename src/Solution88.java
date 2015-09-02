/**
 * Created by slgu1 on 9/2/15.
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;
        int x = 0;
        int y = 0;
        int l = nums1.length;
        int write_pos = l - n;
        while(x < m || y < n){
            if(x >= m){
                nums1[write_pos] = nums2[y];
                ++y;
                ++write_pos;
                if(write_pos == l)
                    write_pos = 0;
                continue;
            }
            if(y >= n){
                nums1[write_pos] = nums1[x];
                ++x;
                ++write_pos;
                if(write_pos == l)
                    write_pos = 0;
                continue;
            }
            if(nums1[x] < nums2[y]){
                nums1[write_pos] = nums1[x];
                ++x;
            }
            else{
                nums1[write_pos] = nums2[y];
                ++y;
            }
            ++write_pos;
            if(write_pos == l)
                write_pos = 0;
        }
        //save last n
        for(int i = 0; i < n; ++i)
            nums2[i] = nums1[l - n + i];
        //reverse insert m
        for(int i = 0; i < m; ++i){
            nums1[m + n - 1 - i] = nums1[m - 1 - i];
        }
        //copy from nums2 to nums1
        for(int i = 0; i < n; ++i){
            nums1[i] = nums2[i];
        }
    }
}
