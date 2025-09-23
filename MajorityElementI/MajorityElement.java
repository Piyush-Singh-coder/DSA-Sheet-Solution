package MajorityElementI;

// The repeated element should have frequency more than n/2
public class MajorityElement {
    // BruteForce
    public static int bruteForce(int arr[]){
        for (int i = 0; i<arr.length; i++){
            int count = 0;
            for (int j = 0; j<arr.length; j++){
                if (arr[i] == arr[j]){
                    count++;
                }
            }
            if (count > (arr.length/2)){
                return arr[i];
            }
        }
        return -1;
    }

    // Better Approach - Hashing
    public static int better(int arr[]){
        int n = arr.length;
        int hash[] = new int[n];
        for (int i = 0; i<n; i++){
            hash[arr[i]-1]++;
        }
        for (int i = 0; i<hash.length; i++){
            if(hash[i] > (n/2) ){
                return i+1;
            }
        }
        return -1;
    }
    
    //optimal Approach
    public static int optimal(int arr[]){
        int count = 0;
        int element = Integer.MIN_VALUE;
        for (int i = 0; i<arr.length; i++){
            if (count == 0){
                element = arr[i];
                count = 1;
            }
            else if (element == arr[i]){
                count++;
            }else{
                count--;
            }
        }
        int count1 = 0;
        for (int i = 0; i<arr.length; i++){
            if (element == arr[i]){
                count1++;
            }
        }
        if(count1 > (arr.length/2)){
            return element;
        }
        else{
            return-1;
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,2,1,3,4,2,2,2};
        System.out.println(optimal(arr));
    }
}
