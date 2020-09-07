package algo;

public class StockSell122 {

    public static void main(String[] args) {
        StockSell122 stockSell122 = new StockSell122();
        int[] arr = {7, 1, 5, 3, 6, 4};
        int r = stockSell122.maxProfit(arr);
        System.out.println(r);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[][] mp = new int[prices.length][2];
        mp[0][0] = 0;
        mp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            mp[i][0] = Math.max(mp[i - 1][0], mp[i - 1][1] + prices[i]);
            mp[i][1] = Math.max(mp[i - 1][1], mp[i - 1][0] - prices[i]);
        }
        return mp[prices.length - 1][0];
    }
}
