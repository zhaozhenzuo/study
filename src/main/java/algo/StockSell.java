package algo;

public class StockSell {

    /**
     * 7,1,5,2
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int r = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                r += prices[i] - prices[i - 1];
            }
        }
        return r;
    }

}
