package TopKFrequent;

import java.util.*;

public class TopKFrequent {
    public static int[] better(int arr[], int k){
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i<arr.length; i++){
            if (temp.containsKey(arr[i])){
                temp.put(arr[i], temp.get(arr[i])+1);
            }else{
                temp.put(arr[i], 1);
            }
        }
        List<int[]> valKeyPair = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : temp.entrySet()){
            valKeyPair.add(new int[]{entry.getValue(), entry.getKey()});
        }
        valKeyPair.sort((a,b) -> b[0] - a[0]);
        // for(int i = 0; i<valKeyPair.size(); i++){
        //     System.out.println(Arrays.toString(valKeyPair.get(i)));
        // }
        int res[] = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = valKeyPair.get(i)[1];
        }
        return res;
    }
    @SuppressWarnings("unchecked")
    public static int[] optimal(int arr[], int k){
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> frequency[] = new List[arr.length + 1];
        for(int i = 0; i<frequency.length; i++){
            frequency[i] = new ArrayList<>();
        }
        for(int i = 0; i< arr.length; i++){
            if(count.containsKey(arr[i])){
                count.put(arr[i],count.get(arr[i])+1);
            }else{
                count.put(arr[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            frequency[entry.getValue()].add(entry.getKey());
        }
        int res[] = new int[k];
        int index = 0; 
        for(int i = frequency.length -1 ; i>=0 && index < k; i--){
            for(int j = 0; j<frequency[i].size(); j++){
                res[index++] = frequency[i].get(j);
                if (index == k){
                    return res;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,3};
        int k = 2;
        System.out.println(Arrays.toString(optimal(arr, k)));
        
    }
}
