package RepeatedNDuplicate;

import java.util.Arrays;

public class RepeatedNDuplicate {
    public static int[] bruteForce(int arr[]){
        int ans[] = new int[2];
        int n = arr.length;
        for(int i = 1; i<=n; i++){
            int count = 0; 
            for(int j = 0; j<n; j++){
                if (arr[j] == i){
                    count++;
                }
            }
            if (count == 2){
                ans[0] = i;
            }
            else if (count == 0){
                ans[1] = i;
            }
        }
        return ans;
    }
    public static int[] optimal1(int arr[]){
        int n = arr.length;
        int Sn = (n*(n+1))/2;
        int Sn2 = (n*(n+1)*(2*n+1))/6;
        int S = 0;
        int S2 = 0;
        for (int i = 0; i<n; i++){
            S += arr[i];
            S2 += (arr[i])*(arr[i]);
        }
        // X-Y
        int val1 = S - Sn;
        // (X+Y)(X-Y)
        int val2 = S2 - Sn2;
        // X+Y 
        val2 = val2/val1;  
        // X-Y+X+Y = 2X
        int x = (val1 + val2)/2;
        // X - (X-Y) = X-X+Y = Y
        int y = x - val1;
        return new int[]{x,y};
    }
    public static void main(String[] args) {
        int arr[] = {4,1,2,1,3};
        System.out.println(Arrays.toString(bruteForce(arr)));
        System.out.println(Arrays.toString(optimal1(arr)));
    }
}
