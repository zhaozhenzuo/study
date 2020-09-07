package algo;

import java.util.ArrayDeque;

public class Solution239 {

    public static void main(String[] args) {
        Solution239 obj = new Solution239();
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        int[] r = obj.maxSlidingWindow(nums, k);
        for (int i : r) {
            System.out.println(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return new int[]{0};
        }

        ArrayDeque<Integer> arrayDeque = new ArrayDeque();

        //[1,3,-1,-3,5,3,6,7], 和 k = 3
        int n = nums.length;
        int[] r = new int[n - k + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            //清除
            clean(nums, i, arrayDeque, k);

            //加入
            arrayDeque.addLast(i);
            if (i >= (k - 1) && i < n) {
                r[count++] = nums[arrayDeque.getFirst()];
            }
        }
        return r;
    }

    public void clean(int[] nums, int i, ArrayDeque<Integer> arrayDeque, int k) {
        //清除窗口最左边的过期元素
        if(arrayDeque.isEmpty()){
            return;
        }

        if ((i - arrayDeque.getFirst()) >= k) {
            //当前lastIndex值过期
            arrayDeque.removeFirst();
        }
        //1, 3, 1, 2, 0, 5
        int iValue = nums[i];
        while (!arrayDeque.isEmpty() && (iValue > nums[arrayDeque.getLast()])) {
            arrayDeque.removeLast();
        }
    }

}
