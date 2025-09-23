package KadaneAlgorithm;

public class KadaneAlgo {
    // Brute Force Approach
    public static int bruteForce(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){
                int sum = 0;
                for (int k=i; k<=j; k++ ){
                    sum+= arr[k];
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }
    // Better Approach
    public static int better(int arr[]){
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++){
            int sum = 0;
            for (int j= i; j<arr.length; j++){
                sum += arr[j];
                max = Math.max(sum,max);
            }
        }
        return max;
    }
    // Optimal Approach - Kadane's Algorithm 
    public static int optimal(int arr[]){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            max = Math.max(max, sum);
            if (sum < 0){
                sum = 0;
            }
        }
        return max;
    }

    // Maximum subarray is asked
    public static void maxSubarray(int arr[]){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int startIndex = -1, endIndex = -1;
        for(int i = 0; i<arr.length; i++){
            if (sum == 0){
                start = i;
            }
            sum += arr[i];
            if (sum > 0){
                max = sum;
                startIndex = start;
                endIndex = i;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        // Maximum Subarray
        for (int i = startIndex; i<= endIndex; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("The sum of the subarray is " + max );
    }
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(bruteForce(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
        maxSubarray(arr);
    }
}
