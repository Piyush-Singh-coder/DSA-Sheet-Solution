package ProductExceptSelf;

import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] bruteForce(int arr[]){
        int result[] = new int[arr.length];
        for(int i=0; i<arr.length;i++){
            int product = 1;
            for(int j=0; j<arr.length;j++){
                if(i == j){
                    continue;
                }else{
                    product *= arr[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    public static int[] optimal1(int arr[]){
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        int ans[] = new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1;
        for(int i = 1; i<n; i++){
            prefix[i] = prefix[i-1] * arr[i-1];
            // suffix[n-i-1] = suffix[n-i] * arr[n-i];
        }
        for(int i = n-2; i>=0; i--){
            suffix[i] = suffix[i+1] * arr[i+1];
        }
        for(int i = 0; i<n; i++){
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }

    public static int[] optimal(int arr[]){
        int n = arr.length; 
        int ans[] = new int[n];
        ans[0] = 1;
        for(int i=1; i<n; i++){
            ans[i] = ans[i-1] * arr[i-1];
        }
        int suffix = 1;
        for(int i = n-2; i>=0; i--){
            suffix = suffix * arr[i+1];
            ans[i] *= suffix;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,6};
        System.out.println(Arrays.toString(bruteForce(arr)));
        System.out.println(Arrays.toString(optimal(arr)));
        
    }   
}
