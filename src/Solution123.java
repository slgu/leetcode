/**
 * Created by slgu1 on 9/7/15.
 */
/*
next idea:
按照股票差价构成新数组
prices[1]-prices[0], prices[2]-prices[1], prices[3]-prices[2], ..., prices[n-1]-prices[n-2]。
求新数组的最大子段和就是我们求得最大利润，假设最大子段和是从新数组第 i 到第 j 项，
那么子段和= prices[j]-prices[j-1]+prices[j-1]-prices[j-2]+...+prices[i]-prices[i-1] = prices[j]-prices[i-1],
即prices[j]是最大价格，prices[i-1]是最小价格
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int n = prices.length;
        int [] max1 = new int [n];
        int [] max2 = new int [n];
        int minn = prices[0];
        for(int i = 1; i < n; ++i){
            if(i == 1 || prices[i] - minn > max1[i - 1])
                max1[i] = prices[i] - minn;
            else{
                max1[i] = max1[i - 1];
            }
            if(prices[i] < minn)
                minn = prices[i];
        }
        int maxn = prices[n - 1];
        for(int i = n - 2; i >= 0; --i){
            if(i == n - 2 || maxn - prices[i] > max2[i + 1]){
                max2[i] = maxn - prices[i];
            }
            else{
                max2[i] = max2[i + 1];
            }
            if(prices[i] > maxn)
                maxn = prices[i];
        }
        int maxprofit = 0;
        if(max2[0] > maxprofit)
            maxprofit = max2[0];
        if(max1[n - 1] > maxprofit)
            maxprofit = max1[n - 1];
        for(int i = 1; i <= n - 3; ++i){
            int tmp = 0;
            if(max1[i] > 0)
                tmp += max1[i];
            if(max2[i + 1] > 0)
                tmp += max2[i + 1];
            if(tmp > maxprofit)
                maxprofit = tmp;
        }
        return maxprofit;
    }
    public static void main(String [] args){
        Solution123 a = new Solution123();
        System.out.println(a.maxProfit(new int[]{1, 4, 2, 7}));
    }
}
