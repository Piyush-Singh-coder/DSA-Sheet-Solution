package PermutationBacktracking;

import java.util.*;
public class PermutationV2 {
    public static List<List<Integer>> permute(int nums[]){
        List<List<Integer>> res = new ArrayList<>();
        getPermutations(nums, 0, res);
        return res;
    }
    public static void getPermutations(int nums[], int idx, List<List<Integer>> res){
        if (idx == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<nums.length; i++){
                list.add(nums[i]);
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i<nums.length; i++){
            swap(i, idx, nums);
            getPermutations(nums, i+1, res);
            swap(i, idx, nums);
        }
    }
    public static void swap(int i, int idx, int nums[]){
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(permute(nums));
    }
}
