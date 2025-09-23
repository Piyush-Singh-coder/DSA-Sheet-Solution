package DailyTemperature;

import java.util.*;

public class DailyTemperature {
    public static int[] optimal(int temperatures[]){
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];
        int nextGreater[] = new int[n];
        for(int i = n-1; i>=0; i--){
            int curr = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] <= curr){
                stack.pop();
            }
            if (stack.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(nextGreater));
        for(int i = 0; i<n; i++){
            if (nextGreater[i] == -1){
                res[i] = 0;
            }else{
                res[i] = nextGreater[i] - i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int temperatures[] = {89,62,70,58,47,47,46,76,100,70};
        System.out.println(Arrays.toString(optimal(temperatures)));
    }
}
