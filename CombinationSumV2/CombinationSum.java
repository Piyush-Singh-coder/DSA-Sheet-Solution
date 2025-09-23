package CombinationSumV2;

import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> sum(int candidates[], int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum(candidates, target, 0, res, list);
        return res;
    }
    public static void combinationSum(int nums[], int target, int idx, List<List<Integer>> res, List<Integer> list ){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i<nums.length; i++){
            if (i > idx && nums[i] == nums[i-1]) continue;
            if (target < nums[i]) break;

            list.add(nums[i]);
            combinationSum(nums,  target - nums[i], i+1, res, list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int candidates[] ={9,2,2,4,6,1,5};
        int target = 8;
        Arrays.sort(candidates);
        System.out.println(sum(candidates, target));
    }
}
