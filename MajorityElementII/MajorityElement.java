package MajorityElementII;
// Repeated element should have frequency more than n/3

import java.util.*;

public class MajorityElement {

    // Brute Force
    public static ArrayList<Integer> bruteForce(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (list.size() == 0 || list.get(0) != arr[i]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }
                if(count > n/3){
                    list.add(arr[i]);
                }
            }
            if (list.size() == 2) {
                break;
            }
        }
        return list;
    }

    // Better Approach
    public static ArrayList<Integer> better(int arr[]){
        int n = arr.length; 
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        int minimum = (int) (n/3)+1;
        for( int i = 0; i<arr.length; i++){
            int value = hash.getOrDefault(arr[i], 0);
            hash.put(arr[i], value+1);

            if (hash.get(arr[i]) == minimum){
                list.add(arr[i]);
            }
            if(list.size() == 2){
                break;
            }
        }
        return list;
    }

    //Better Approach
    public static ArrayList<Integer> optimal(int arr[]){
        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;
        for (int i = 0; i<arr.length; i++){
            if (count1 == 0 && element2 != arr[i]){
                count1 = 1;
                element1 = arr[i];
            }else if (count2 == 0 && element1 != arr[i]){
                count2 = 1;
                element2 = arr[i];
            }else if (arr[i] == element1){
                count1++;
            }else if(arr[i] == element2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        count1 = 0; 
        count2 = 0;
        for(int i = 0; i<arr.length; i++){
            if (element1 == arr[i]){
                count1++;
            }
            if(element2 == arr[i]){
                count2++;
            }
        }
        int minimum = (int)(arr.length/3) + 1;
        if (count1 >= minimum){
            list.add(element1);
        }
        if(count2 >= minimum){
            list.add(element2);
        }
        return list;
    }
    public static void main(String[] args) {
        int arr[] = { 11, 33, 33, 11, 33, 11 };
        System.out.println(optimal(arr));
    }
}
