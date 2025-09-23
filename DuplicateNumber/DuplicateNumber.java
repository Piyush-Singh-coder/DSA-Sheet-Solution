

public class DuplicateNumber {
    public static int negativeMarking(int nums[]){
        for (int i = 0; i<nums.length; i++){
            int idx = Math.abs(nums[i])-1;
            if (nums[idx] < 0){
                return nums[i];
            }
            nums[idx] = nums[idx] * -1;
        }
        return -1;
    }
    public static int slowFastPointer(int nums[]){
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast){
                break;
            }
        }
        fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast){
                return slow;
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,3};
        System.out.println(slowFastPointer(nums));
    }
}
