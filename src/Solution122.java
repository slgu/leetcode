/**
 * Created by slgu1 on 10/24/15.
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int minn = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] <= prices[i - 1]) {
                if (prices[i - 1] - minn > 0)
                    profit += (prices[i - 1] - minn);
                minn = prices[i];
            }
        }
        if (prices[prices.length - 1] > minn)
            profit += (prices[prices.length - 1] - minn);

        return profit;
    }
    public static void main(String [] args) {
        Solution122 a = new Solution122();
        System.out.println(a.maxProfit(new int[]{1, 2, 1, 2, 1, 2, 1, 2}));
    }
}
