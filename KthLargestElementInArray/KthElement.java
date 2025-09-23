package KthLargestElementInArray;

import java.util.PriorityQueue;

public class KthElement {
    public static int kthLargest(int nums[], int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i<nums.length; i++){
            minHeap.add(nums[i]);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,5,5,4};
        int k = 3;
        System.out.println(kthLargest(nums, k));
    }
}
