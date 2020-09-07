package algo;

public class StockSell121 {

//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length <= 1) {
//            return 0;
//        }
//
//        int preMinBuyPrice = prices[0];
//        int maxProfit = 0;
//        for (int i =1;i<prices.length;i++) {
//            maxProfit=Math.max(maxProfit,prices[i]-preMinBuyPrice);
//            preMinBuyPrice=Math.min(preMinBuyPrice,prices[i]);
//        }
//        return maxProfit;
//    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }

        int k = 1;
        int[][][] mp = new int[prices.length][2][k+1];
        mp[0][0][0] = 0;
        mp[0][0][1] = 0;
        mp[0][1][0] = -prices[0];
        mp[0][1][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                mp[i][0][j] = j != 0 ? Math.max(mp[i - 1][0][j], mp[i][1][j - 1] + prices[i]) : mp[i - 1][0][j];
                mp[i][1][j]=Math.max(mp[i-1][1][j],mp[i-1][0][j]-prices[i]);
            }
        }
        return Math.max(mp[prices.length-1][0][0],mp[prices.length-1][0][1]);
    }

}
