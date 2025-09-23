package BinarySearch;

public class BinarySearch {
    public static boolean optimal(int arr[], int target){
        int i = 0;
        int j = arr.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if (arr[mid] == target){
                return true;
            }else if(target < arr[mid]){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,5,7,9};
        System.out.println(optimal(arr, 10));
    }
}
