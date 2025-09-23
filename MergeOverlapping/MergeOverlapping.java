package MergeOverlapping;

import java.util.*;
public class MergeOverlapping {

    public static List<List<Integer>> bruteForce(int arr[][]){
        int n = arr.length;
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));  // Sort array on the basis of first element
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i<n; i++){
            int start = arr[i][0];
            int end = arr[i][1];
            // Skip all the merged intervals
            if (!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }
            for(int j = i+1; j<n; j++){
                if (arr[j][0] <= end){
                    end = Math.max(arr[j][1],end);
                }else{
                    break;
                }
            }
            ans.add(Arrays.asList(start,end));
        }
        return ans;
    }

    // Optimal Approach
    public static List<List<Integer>> optimal(int arr[][]){
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i<arr.length; i++){
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(arr[i][0],arr[i][1]));
            }else{
                ans.get(ans.size()-1).set(1,(Math.max(ans.get(ans.size()-1).get(1), arr[i][1])));
            }
        }
        // System.out.println(ans);
        return ans;

    }
    public static void main(String[] args) {
        int arr[][] = {{1,3},{2,6},{8,10},{15,18}};
        // bruteForce(arr);
        optimal(arr);
    }
}
