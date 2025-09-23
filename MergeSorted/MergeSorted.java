package MergeSorted;

import java.util.Arrays;

public class MergeSorted {
    public static void myApproach(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        for(int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                if (arr1[i]<arr2[j]){
                    continue;
                }else{
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    
    //Brute force Approach
    public static void bruteForce(int arr1[], int arr2[]){
        int ans[] = new int[arr1.length+arr2.length];
        int i = 0, j = 0, k = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                ans[k++] = arr1[i++];
            }else{
                ans[k++] = arr2[j++];
            }
        }
        while(i<arr1.length){
            ans[k++] = arr1[i++];
        }
        while(j<arr2.length){
            ans[k++] = arr2[j++];
        }
        int index = 0;
        for(i = 0; i<arr1.length; i++){
            arr1[i] = ans[index++];
        }
        for(i = 0; i<arr2.length; i++){
            arr2[i] = ans[index++];
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    // Optimal Approach 1
    public static void optimal1(int arr1[], int arr2[]){
        int i = arr1.length-1;
        int j = 0;
        while(i >= 0 && j<arr2.length){
            if (arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    // Optimal Approach - Gap Approach
    public static void optimal2(int arr1[], int arr2[]){
        int len = arr1.length + arr2.length;
        int gap = (len/2) + (len%2);
        while(gap > 0){
            int left = 0;
            int right = left+gap;
            while(right < len){
                if(left < arr1.length && right >= arr1.length){
                    swapIfGreater(arr1, arr2, left, right-arr1.length);
                }
                else if(left >= arr1.length){
                    swapIfGreater(arr1, arr2, left-arr1.length, right - arr2.length);
                }else{
                    swapIfGreater(arr1, arr2, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1){
                break;
            }
            gap = (gap/2) + (gap %2);
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    public static void swapIfGreater(int arr1[], int arr2[], int left, int right){
        if (arr1[left] > arr2[right]){
            int temp = arr1[left];
            arr1[left] = arr2[right];
            arr2[right] = temp;
        }
    }
    public static void main(String[] args) {
        int arr1[] = {1,3,5,7};
        int arr2[] = {0,2,6,8,9};
        // myApproach(arr1, arr2);
        bruteForce(arr1, arr2);
        optimal1(arr1, arr2);
        optimal2(arr1, arr2);
    }
}
