package HouseRobberV1;

public class HouseRobber {
    public static int recursion(int nums[]){
        return dfs(nums, 0);
    }
    public static int dfs(int nums[], int i){
        if (i >= nums.length){
            return 0;
        }
        return Math.max(dfs(nums, i+1), nums[i]+ dfs(nums, i+2));
    }
    public static void main(String[] args) {
        int nums[] = {2,9,8,3,6};
        System.out.println(recursion(nums));
    }
}
