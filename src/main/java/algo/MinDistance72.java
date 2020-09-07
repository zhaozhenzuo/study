package algo;

public class MinDistance72 {

    public static void main(String[] args) {
        MinDistance72 minDistance72=new MinDistance72();
        String word1 = "horse";
        String word2 = "ros";
        int r=minDistance72.minDistance(word1,word2);
        System.out.println(r);
    }


    public int minDistance(String word1, String word2) {
        if ((word1 == null && word2 == null)
           || (word1.length()<=0 && word2.length()<=0)) {
            return 0;
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;

        // 边界状态初始化
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        for (int i = 1; i <= word1Arr.length; i++) {
            for (int j = 1; j <= word2Arr.length; j++) {
                if (word1Arr[i - 1] == word2Arr[j - 1]) {
                    //相等
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //不相等的情况
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]))+1;
                }
            }
        }
        return dp[word1Arr.length][word2Arr.length];
    }

}
