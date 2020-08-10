package algo;

public class MaximumSubarray152 {

    public int maxProduct(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int max = nums[0];
        int[] dp;
        for (int i = 0; i < nums.length; i++) {
            dp=new int[nums.length];
            for (int j = i; j < nums.length; j++) {
                if (j == i) {
                    //第一个数字，初始化
                    dp[i] = nums[i];
                } else {
                    dp[j] = dp[j - 1] * nums[j];
                }
                if (dp[j] > max) {
                    max = dp[j];
                }
            }
        }
        return max;
    }

}
