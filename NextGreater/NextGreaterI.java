package NextGreater;

import java.util.*;
public class NextGreaterI {
    public static int[] optimal(int nums1[], int nums2[]){
        int res[] = new int[nums1.length];
        // int next[] = new int[nums2.length];
        HashMap<Integer,Integer> next = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i= nums2.length-1; i>=0; i--){
            int curr = nums2[i];
            while (!stack.isEmpty() && stack.peek() < curr){
                stack.pop();
            }
            if (stack.isEmpty()){
                next.put(nums2[i], -1);
            }else{
                next.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        for(int i = 0; i<nums1.length; i++){
            res[i] = next.get(nums1[i]);
        }
        return res;
    }
    public static void main (String [] args){
        int nums1 [] = {4,1,2};
        int nums2 [] = {1,3,4,2};
        System.out.println(Arrays.toString(optimal(nums1, nums2)));
    }
}
