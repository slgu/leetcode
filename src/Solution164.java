import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by slgu1 on 10/13/15.
 */
//TODO write in the blog
//bucket sort
public class Solution164 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return 0;
        int maxn = nums[0];
        int minn = nums[0];
        for (int i = 1; i < n; ++i) {
            if (maxn < nums[i])
                maxn = nums[i];
            if (minn > nums[i])
                minn = nums[i];
        }
        if (maxn == minn)
            return 0;
        int avgLen = (maxn - minn) / (n - 1);
        if (avgLen == 0)
            ++avgLen;
        int bucketNum = (maxn - minn) / avgLen + 1;
        int [] bucketMin = new int[bucketNum];
        boolean [] bucketFlg = new boolean[bucketNum];
        for (int i = 0; i < bucketNum; ++i)
            bucketFlg[i] = false;
        int [] bucketMax = new int[bucketNum];
        for (int i = 0; i < n; ++i) {
            int idx = (nums[i] - minn) / avgLen;
            if (!bucketFlg[idx]) {
                bucketFlg[idx] = true;
                bucketMin[idx] = nums[i];
                bucketMax[idx] = nums[i];
            }
            else {
                if (bucketMax[idx] < nums[i])
                    bucketMax[idx] = nums[i];
                if (bucketMin[idx] > nums[i])
                    bucketMin[idx] = nums[i];
            }
        }
        boolean flg = false;
        int lastmaxn = -1;
        int maximumGap = -1;
        for (int i = 0; i < bucketNum; ++i) {
            if (bucketFlg[i] == false)
                continue;
            if (!flg) {
                flg = true;
                lastmaxn = bucketMax[i];
            }
            else {
                if (maximumGap < bucketMin[i] - lastmaxn)
                    maximumGap = bucketMin[i] - lastmaxn;
                lastmaxn = bucketMax[i];
            }
        }
        return maximumGap;
    }
    public static void main(String [] args) {
        Solution164 a = new Solution164();
        System.out.println(a.maximumGap(new int[]{1, 1,1,1,1,2}));
    }
}
