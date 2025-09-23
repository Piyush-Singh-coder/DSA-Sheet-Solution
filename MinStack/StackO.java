package MinStack;

import java.util.*;
public class StackO {
    static class MinStack {
        private int min;
        private Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()){
            stack.push(val);
            min = val;
        }
        else{
            if (min > val){
                stack.push(2*val - min);
                min = val;
            }else{
                stack.push(val);
            }
        }
    }
    
    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        if (top < min){
            min = 2*min - top;
        }
    }
    
    public int top() {
        int top = stack.peek();
        if (top < min){
            return min;
        }
        else{
            return top;
        }
        
    }
    
    public int getMin() {
        return min;
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
