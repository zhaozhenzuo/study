package algo;

public class LongestSeq300 {

    public static void main(String[] args) {
        //[4,10,4,3,8,9]
        LongestSeq300 longestSeq300 = new LongestSeq300();
        int[] arr = {4,4};
        int r = longestSeq300.lengthOfLIS(arr);
        System.out.println(r);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        //4,10,4,3,8,9
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int r=1;
        for (int i = 1; i < nums.length; i++) {
            int max=0;
            for (int j = 0; j < i; j++) {
                int temp =1;
                if (nums[i] > nums[j]) {
                    temp = dp[j] + 1;
                }
                if(temp>max){
                    max=temp;
                }
            }
            dp[i]=max;
            if(max>r){
               r=max;
            }
        }
        return r;
    }

}
