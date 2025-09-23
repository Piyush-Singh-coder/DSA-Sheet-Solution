package Duplicate;

import java.util.Arrays;

public class Duplicate {
    // Brute Force Approach - Sorting and comparing
    public static int bruteForce(int arr[]){
        Arrays.sort(arr);
        for (int i = 1; i<arr.length;i++){
            if (arr[i-1] == arr[i]){
                return arr[i];
            }
        }
        return -1;
    }

    // Better Approach - Hashing
    public static int better(int arr[]){
        int hash[] = new int[arr.length];
        for (int i = 0; i<arr.length; i++){
            if (hash[arr[i]-1] == 1){
                return arr[i];
            }
            else{
                hash[arr[i]-1]++;
            }
        }
        return -1;
    }

    // Optimal Approach - fast and slow Pointer
    public static int optimal(int arr[]){
        int slow = arr[0];
        int fast = arr[arr[0]];  
        while(slow != fast){
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        fast = arr[0];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
    public static void main(String[] args){
        int arr[] = {3,1,3,4,2};
        System.out.println(bruteForce(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }
}
