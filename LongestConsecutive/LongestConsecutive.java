package LongestConsecutive;

import java.util.*;

public class LongestConsecutive {
    public static int bruteForce(int arr[]){
        HashSet<Integer> numSet = new HashSet<>();
        for (int i=0; i<arr.length; i++){
            numSet.add(arr[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            int streak = 0;
            int curr = arr[i];
            while(numSet.contains(curr)){
                streak++;
                curr++;
            }
            max = Math.max(streak, max);
        }
        return max;
    }

    public static int myBetterApproach(int arr[]){
        Arrays.sort(arr);
        int max = 0;
        int length = 1;
        for(int i = 0; i<arr.length-1; i++){
            if (arr[i+1] == arr[i]){
                continue;
            }
            if(arr[i+1] - arr[i] == 1){
                length++;
            }else{
                length = 1;
            }
            max = Math.max(length, max);
        }
        return max;
    }

    public static int optimal(int arr[]){
        HashSet<Integer> numSet = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            numSet.add(arr[i]);
        }
        for(int i = 0; i<arr.length; i++){
            int curr = arr[i];
            if (!numSet.contains(curr - 1)){
                int length = 1;
                while(numSet.contains(curr+length)){
                    length++;
                }
                max = Math.max(max,length);
            }
        }
        return max;
    }
    public static void main (String[] args){
        int arr[] = {2,20,4,1,3,4,5};
        System.out.println(bruteForce(arr));
        System.out.println(myBetterApproach(arr));
        System.out.println(optimal(arr));
    }
}
