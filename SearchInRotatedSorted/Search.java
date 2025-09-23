package SearchInRotatedSorted;

public class Search{
    public static int optimal(int arr[], int target){
        int l = 0; 
        int r = arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[l] <= arr[mid]){
                if (target < arr[l] || target > arr[mid]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }else{
                if (target < arr[mid] || target > arr[r]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {3,4,5,6,1,2};
        System.out.println(optimal(arr, 3));
    }
}