package BookAllocation;

public class BookAllocation {
    public static boolean isValid(int arr[], int m, int max){
        int pages = 0;
        int s = 1;
        for (int i = 0; i<arr.length;i++){
            if (arr[i] > max){
                return false;
            }
            if((pages+arr[i])<= max){
                pages += arr[i];
            }else{
                s++;
                pages = arr[i];
            }
        }
        return s <= m ? true : false;
    }
    public static int optimal(int arr[], int m){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        int ans = -1;
        int l = 0, r = sum;
        while(l<=r){
            int mid = (l+r)/2;
            if (isValid(arr,m,mid)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {12,34,67,90};
        int m = 2;
        System.out.println(optimal(arr, m));
    }
}
