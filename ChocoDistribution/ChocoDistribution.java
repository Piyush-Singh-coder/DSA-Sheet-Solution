package ChocoDistribution;

import java.util.Arrays;

public class ChocoDistribution {
    public static void main(String[] args) {
        int arr[] = {7,3,2,4,9,12,56};
        int m = 5;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int i = 0;
        int j = m+i-1;
        while(j<arr.length){
            int diff = arr[j] - arr[i];
            minDiff = Math.min(diff, minDiff);
            i++;
            j++;
        }
        System.out.println(minDiff);
    } 
}
