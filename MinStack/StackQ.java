package MinStack;

import java.util.*;

public class StackQ {
    static class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        int top =  stack.pop();
        if (minStack.peek() == top){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(1);
        m.push(3);
        m.push(-4);
        m.push(45);
        m.pop();
        m.pop();
        System.out.println(m.getMin());
    }
}
