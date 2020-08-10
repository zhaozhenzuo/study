package algo;

public class ClimbingStairs70Solution2 {

    public static void main(String[] args) {
        ClimbingStairs70Solution2 obj = new ClimbingStairs70Solution2();
        int r = obj.climbStairs(45);
        System.out.println(r);
    }
    //1836311903

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        Integer[] dp = new Integer[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
