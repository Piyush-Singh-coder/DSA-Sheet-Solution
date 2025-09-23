package ThreeSum;

import java.util.*;
public class ThreeSum{
    public static List<List<Integer>> bruteForce(int arr[]){
        HashSet<List<Integer>> res = new HashSet<>();
        for (int i = 0; i<arr.length; i++){
            for(int j= i+1; j<arr.length; j++){
                for(int k = j+1; k<arr.length; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(temp);
                        res.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> better(int arr[]){
        HashSet<List<Integer>> res = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            HashSet<Integer> hashSet = new HashSet<>();
            for(int j = i+1; j<arr.length; j++){
                int target = -(arr[i] + arr[j]);
                if( hashSet.contains(target)){
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], target);
                    Collections.sort(temp);
                    res.add(temp);
                }
                hashSet.add(arr[j]);
            }
        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> optimal(int arr[]){
        Arrays.sort(arr);
        HashSet<List<Integer>> res = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            int j = i+1;
            int k = arr.length-1;
            while(j<k){
                int curr = arr[i] + arr[j] + arr[k];
                if(curr < 0){
                    j++;
                }
                else if(curr > 0){
                    k--;
                }else{
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    res.add(temp);
                    j++;
                    k--;
                    while(j<k &&arr[j] == arr[j-1]) j++;
                    while(j<k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        return new ArrayList<>(res);
    }
    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,4};
        System.out.println(bruteForce(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }
}