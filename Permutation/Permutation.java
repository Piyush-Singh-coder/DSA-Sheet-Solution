package Permutation;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void permute(ArrayList<Integer> list, int index) {
        if (index == list.size()) {
            System.out.println(list);
            return;
        }
        for (int i = index; i < list.size(); i++) {
            swap(list, i, index);
            permute(list, index + 1);
            swap(list, i, index);
        }
    }

    public static void reverse(int arr[], int i, int j) {
        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void nextPermutation(int arr[]) {
        int index = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(arr, 0, arr.length - 1);
            return;
        }
        for (int i = arr.length - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }
        reverse(arr, index + 1, arr.length - 1);

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // permute(list, 0);
        int arr[] = {3,2,1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}