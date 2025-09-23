package CombinationSum;

import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int nums[], int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        sum(nums, target, 0, res, list);
        return res;
    }
    public static void sum(int nums[], int target,int idx, List<List<Integer>> res, List<Integer> list){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || idx == nums.length){
            return;
        }
        list.add(nums[idx]);
        sum(nums, target - nums[idx], idx, res, list);
        list.remove(list.size()-1);
        sum(nums, target, idx + 1, res, list);
    }
    
    public static void main(String[] args) {
        int nums[] = {2,5,6,9};
        int target = 9;
        System.out.println(combinationSum(nums, target));
    }
}
