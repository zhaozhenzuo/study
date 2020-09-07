package algo;

import java.util.LinkedList;
import java.util.Queue;

public class QuetoStack225 {

    Queue<Integer> q1=new LinkedList();
    Queue<Integer> q2=new LinkedList();

    Integer top;

    /** Initialize your data structure here. */
    public QuetoStack225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top=x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size=q1.size();
        while(size-->1){
            top=q1.poll();
            q2.add(top);
        }
        int r= q1.poll();
        q1=q2;
        q2=new LinkedList<>();
        return r;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

}
