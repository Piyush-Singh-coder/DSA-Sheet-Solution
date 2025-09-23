package Subsets;

import java.util.*;

public class Subset {
    public static List<List<Integer>> subset(int nums[]){
        List<List<Integer>> res = new ArrayList<>();
        allSubsets(nums, 0,  res, new ArrayList<>());
        return res;
    }
    public static void allSubsets(int nums[], int i,  List<List<Integer>> res, List<Integer> list ){
        if (i == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        allSubsets(nums, i+1, res, list);
        list.remove(list.size()-1);
        allSubsets(nums, i+1, res, list);
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(subset(nums));
    }
}
