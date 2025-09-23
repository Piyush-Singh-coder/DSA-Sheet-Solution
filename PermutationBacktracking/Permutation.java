package PermutationBacktracking;

import java.util.*;
public class Permutation {
    public static List<List<Integer>> permute(int nums[]){
        boolean perm[] = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getPermutations(nums, res, list, perm);
        return res;
    }
    public static void getPermutations(int nums[], List<List<Integer>> res, List<Integer> list, boolean perm[]){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if (!perm[i]){
                perm[i] = true;
                list.add(nums[i]);
                getPermutations(nums, res, list, perm);
                list.remove(list.size()-1);
                perm[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(permute(nums));
    }
}
