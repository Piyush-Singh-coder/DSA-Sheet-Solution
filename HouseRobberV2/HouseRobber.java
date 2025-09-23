package HouseRobberV2;

public class HouseRobber {
    public static int recursion(int nums[]){
        return Math.max(dfs(nums, 0, true), dfs(nums, 1, false));
    }
    public static int dfs(int nums[], int i, boolean flag){
        if (i >= nums.length || (flag && i == nums.length-1)){
            return 0;
        }
        return Math.max(dfs(nums, i+1, false), nums[i] + dfs(nums, i+2, flag || i == 0));
    }
    public static void main(String[] args) {
        int nums[] = {2,9,8,3,6};
        System.out.println(recursion(nums));
    }
}
