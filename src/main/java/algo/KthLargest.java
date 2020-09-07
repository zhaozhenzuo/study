package algo;

import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        int[] arr = {};
        KthLargest kthLargest = new KthLargest(1, arr);
        int r1 = kthLargest.add(-3);// returns 4
        System.out.println(r1);
        int r2 = kthLargest.add(-2);// returns 5
        int r3 = kthLargest.add(-4);// returns 5
        int r4 = kthLargest.add(0);// returns 8
        int r5 = kthLargest.add(4);// returns 8

    }

    PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
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
