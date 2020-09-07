package algo;

public class Stock123 {

    public static void main(String[] args) {
        Stock123 stock123 = new Stock123();
        int[] arr = {1,2,3,4,5};
        int r = stock123.maxProfit(arr);
//        int r=stock123.maxProfit(2,arr);
        System.out.println(r);
    }

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int[][][] mp = new int[prices.length][2][k + 1];
        for (int i = 0; i <= k; i++) {
            // 第 1 天买入 - 卖出循环 K 次之后不再买入，所以初始值为 0
            mp[0][0][i] = 0;
            // 第 1 天买入 - 卖出循环 K 次之后又买入，所以初始值为 -prices[0]
            mp[0][1][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                mp[i][0][j] = j != 0 ? Math.max(mp[i - 1][1][j - 1] + prices[i], mp[i - 1][0][j]) : mp[i - 1][0][j];
                mp[i][1][j] = Math.max(mp[i - 1][0][j] - prices[i], mp[i - 1][1][j]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++)
            max = Math.max(max, mp[prices.length - 1][0][i]);
        return max;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        //持有股票数状态，0或1
        int remainStore = 2;
        //交易次数
        int changeNum = 3;
        int[][][] mp = new int[prices.length][remainStore][changeNum];

        //初始化值定义
        mp[0][0][0] = 0;
        mp[0][0][1] = 0;
        mp[0][0][2] = 0;
        mp[0][1][0] = -prices[0];
        mp[0][1][1] = -prices[0];
        mp[0][1][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int k = 0; k < changeNum; k++) {
                mp[i][0][k] = k!=0? Math.max(mp[i - 1][0][k], mp[i - 1][1][k - 1] + prices[i]):mp[i - 1][0][k];
                mp[i][1][k] = Math.max(mp[i - 1][1][k], mp[i - 1][0][k] - prices[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < changeNum; i++)
            max = Math.max(max, mp[prices.length - 1][0][i]);
        return max;
    }

}
