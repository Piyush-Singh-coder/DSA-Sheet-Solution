package PeakIndexInMountain;

public class PeakIndex {
    public static int optimal (int arr[]){
        int l = 1; 
        int r = arr.length -2;
        while(l<=r){
            int mid = l+(r-l)/2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]  ){
                return mid;
            }
            if (arr[mid-1] < arr[mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {0,3,8,9,5,2};
        System.out.println(optimal(arr));
    }
}
