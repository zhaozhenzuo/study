package algo;

import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        int r1 = kthLargest.add(3);// returns 4
        int r2 = kthLargest.add(5);// returns 5
        int r3 = kthLargest.add(10);// returns 5
        int r4 = kthLargest.add(9);// returns 8
        int r5 = kthLargest.add(4);// returns 8

    }

    PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int val : a)
            add(val);
    }

    public int add(int val) {
        if (priorityQueue.size() >= k) {
            //当堆超过k个元素时
            if (val > priorityQueue.peek()) {
                //如果当前要插入的元素比堆中最小元素大，则需要册队堆中最小元素，并插入这个元素
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        } else {
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }

}
