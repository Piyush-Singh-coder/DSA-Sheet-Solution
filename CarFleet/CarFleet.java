package CarFleet;

import java.util.*;
public class CarFleet {
    public static int optimal(int position[], int speed[], int target){
        int n = speed.length; 
        int res [][] = new int[n][2];
        for(int i = 0; i<n ; i++){
            res[i][0] = position[i];
            res[i][1] = speed[i];
        }
        Arrays.sort(res, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i<n; i++){
            int time = (target - res[i][0])/res[i][1];
            stack.push((double)time);
            if(stack.size() >=2 && stack.get(stack.size()-2) >= stack.peek()){
                stack.pop();
            }
        }
        return stack.size();
    }
    public static void main(String[] args) {
        int target = 10;
        int position [] = {4,1,0,7};
        int speed [] = {2,2,1,1};
        int res = optimal(position, speed, target);
        System.out.println(res);
    }
}
