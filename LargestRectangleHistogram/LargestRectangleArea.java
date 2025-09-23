package LargestRectangleHistogram;

import java.util.*;

public class LargestRectangleArea {
    public static int optimal(int heights[]){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length; 
        int leftSmall[] = new int[n];
        int rightSmall [] = new int [n];
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                leftSmall[i] = -1;
            }else{
                leftSmall[i] = stack.peek();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            stack.pop();
        }
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                rightSmall[i] = n;
            }else{
                rightSmall[i] = stack.peek();
            }
            stack.push(i);
        }
        int max = 0;
        int ans = 0;
        for(int i = 0; i<n ; i++){
            int width = rightSmall[i] - leftSmall[i] -1;
            ans = width * heights[i];
            max = Math.max(max, ans);
        }
        return max;
    }
    public static void main (String[] args){
        int heights[] = {2,1,5,6,2,3};
        System.out.println(optimal(heights));

    }
}
