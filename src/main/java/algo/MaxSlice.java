package algo;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlice {

    Deque<Integer> winow = null;

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return new int[]{};
        }

        winow = new LinkedList<Integer>();
        //3,5,1,7,4
        //k=3
        int[] r = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //清除过期窗口元素
            if (i >= k && winow.peek() < i - k + 1) {
                winow.poll();
            }

            //清除队列中小于这个新元素的成员
            while (!winow.isEmpty() && (nums[winow.peekLast()] < nums[i])) {
                winow.pollLast();
            }

            //加入这个新元素
            winow.offer(i);

            //结果赋值
            if (i >= k - 1) {
                r[j++] = nums[winow.peek()];
            }
        }
        return r;
    }

}
