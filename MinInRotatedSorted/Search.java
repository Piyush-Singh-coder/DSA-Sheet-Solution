package MinInRotatedSorted;

public class Search {
    public static int optimal(int arr[]){
        int low = 0; 
        int high = arr.length-1;
        int min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if (arr[low] <= arr[high]){
                min = Math.min(min, arr[low]);
                break;
            }
            if (arr[low] <= arr[mid]){
                min = Math.min(min, arr[low]);
                low = mid+1;
            }else{
                high = mid-1;
                min = Math.min(min, arr[mid]);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,0,1,2};
        System.out.println(optimal(arr));
    }
}
