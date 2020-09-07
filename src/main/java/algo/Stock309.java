package algo;

public class Stock309 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }

        int[][] mp = new int[prices.length][3];

        mp[0][0] = 0;
        mp[0][1] = -prices[0];
        mp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            mp[i][0] = Math.max(mp[i - 1][0], mp[i - 1][1] + prices[i]);
            mp[i][1]=Math.max(mp[i-1][1],mp[i-1][2]-prices[i]);
            mp[i][2]=mp[i-1][0];
        }
        return Math.max(mp[prices.length-1][0],mp[prices.length-1][2]);
    }

}
