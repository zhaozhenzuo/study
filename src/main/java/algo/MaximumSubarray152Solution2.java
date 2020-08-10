package algo;

public class MaximumSubarray152Solution2 {

    public static void main(String[] args) {
        MaximumSubarray152Solution2 obj = new MaximumSubarray152Solution2();
        int[] nums = {2, 3, -2, 4};
        int r = obj.maxProduct(nums);
        System.out.println(r);
    }

    public int maxProduct(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int preDpMax = nums[0];
        int preDpMin = nums[0];
        int max = nums[0];
        int curMax;
        int curMin;
        for (int i = 1; i < nums.length; i++) {
            //最大值
            int preMaxMul=preDpMax * nums[i];
            int preMinMul=preDpMin * nums[i];
            curMax = Math.max(Math.max(preMaxMul, preMinMul), nums[i]);
            //最小值
            curMin = Math.min(Math.min(preMaxMul, preMinMul), nums[i]);
            max = Math.max(curMax, max);
            preDpMax = curMax;
            preDpMin = curMin;
        }
        return max;
    }

}
