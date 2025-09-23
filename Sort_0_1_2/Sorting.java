package Sort_0_1_2;

import java.util.Arrays;

public class Sorting {
    // Brute Force Approach
    public static void bruteForce(int arr[]){
        Arrays.sort(arr);
    }
    
    // Better Approach
    public static void better(int arr[]){
        int ans[] = new int[arr.length];
        int index = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i] == 0){
                ans[index] = 0;
                index++;
            }
        }
        for(int i=0;i<arr.length; i++){
            if(arr[i] == 1){
                ans[index] = 1;
                index++;
            }
        }
        for(int i=0;i<arr.length; i++){
            if(arr[i] == 2){
                ans[index] = 2;
                index++;
            }
        }
        for(int i = 0; i<ans.length;i++){
            arr[i]=ans[i];
        }
    }
    // Better Approach -2
    public static void betterApproach (int arr[]){
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i< arr.length; i++){
            if (arr[i] == 0){
                count0++;
            }
            else if(arr[i] == 1){
                count1++;
            }
            else {
                count2++;
            }
        }
        // Insead of this we can run three different loop for count1, count2, count0 ; 
        for(int i = 0; i<arr.length; i++){
            if (count0 != 0){
                arr[i] = 0;
                count0--;
            }
            else if(count1 !=0){
                arr[i] = 1;
                count1--;
            }
            else if (count2 != 0){
                arr[i] = 2;
                count2--;
            }
        }
    }

    //Optimal Approach - Dutch National Flag algorithm 
    // 0000 11111 0120 2222      0:- 0-low-1, 1:- low-mid-1, unsorted:- mid-high, 2:- high+1-arr.length
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;   
    }
    public static void optimal(int arr[]){
        int low = 0, mid = 0, high = arr.length-1;
        while(mid <= high){
            if (arr[mid] == 0){
                swap(arr, mid, low);
                mid++;
                low++;
            }else if (arr[mid] == 1){
                mid++;
            }else{
                swap(arr,mid,high);
                high--;
            }
        } 
    }
    public static void main(String[] args) {
        int arr[] = {2,0,2,1,1,0};
        // bruteForce(arr);
        // better(arr);
        // betterApproach(arr);
        optimal(arr);
        System.out.println(Arrays.toString(arr));
    }
}
