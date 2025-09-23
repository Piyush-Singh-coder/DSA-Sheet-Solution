package SubsetV2;

import java.util.*;

public class Subset {
    public static List<List<Integer>> subset(int nums[]){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        allSubsets(nums, 0,res, list );
        return res;
    }
    public static void allSubsets(int nums[], int idx, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = idx; i<nums.length; i++){
            if (i > idx && nums[i] == nums[i-1]) continue;

            list.add(nums[i]);
            allSubsets(nums, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,2,1};
        Arrays.sort(nums);
        System.out.println(subset(nums));
    }
}
