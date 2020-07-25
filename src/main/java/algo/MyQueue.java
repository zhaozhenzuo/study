package algo;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> inputStack=new Stack();
    Stack<Integer> outputStack=new Stack();

    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
    }

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outputStack.isEmpty()){
            //输出栈为空，则将输入栈的数据存入输出栈
            pushToOutputStack();
        }
        return (int)outputStack.pop();
    }

    private void pushToOutputStack(){
        if(inputStack.isEmpty()){
            return;
        }
        while(!inputStack.isEmpty()){
            outputStack.push(inputStack.pop());
        }
    }

    /** Get the front element. */
    public int peek() {
        if(outputStack.isEmpty()){
            //输出栈为空，则将输入栈的数据存入输出栈
            pushToOutputStack();
        }
        return (int)outputStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

}
