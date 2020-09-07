package algo;

import java.util.HashSet;
import java.util.Set;

public class Coin322 {

    public static void main(String[] args) {
        int[] coins = new int[]{3, 2};
        int amount = 4;
        Coin322 coin322 = new Coin322();
        int r = coin322.coinChange(coins, amount);
        System.out.println(r);
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length <= 0 || amount <= 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        Set<Integer> cacheMap = new HashSet<>(coins.length);
        for (int v : coins) {
            cacheMap.add(v);
        }
        if (cacheMap.contains(amount)) {
            //求的金额就在面值列表中
            return 1;
        }

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            if (cacheMap.contains(i)) {
                dp[i] = 1;
                continue;
            }
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
