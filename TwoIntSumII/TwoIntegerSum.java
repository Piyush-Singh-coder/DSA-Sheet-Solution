package TwoIntSumII;

import java.util.Arrays;

public class TwoIntegerSum{
    public static int[] bruteForce(int nums[], int target){
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                int currSum = nums[i] + nums[j];
                if(currSum == target){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int [] optimal(int nums[], int target){
        int n = nums.length; 
        int i = 0;
        int j = n-1;
        while(i<j){
            int currSum = nums[i] + nums[j];
            if (currSum == target){
                return new int[]{i+1,j+1};
            }else if(currSum > target){
                j--;
            }
            else if(currSum < target){
                i++;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args){
        int nums[] = {1,2,3,4};
        int target = 3;
        System.out.println(Arrays.toString(optimal(nums, target)));
        System.out.println(Arrays.toString(bruteForce(nums, target)));
    }
}