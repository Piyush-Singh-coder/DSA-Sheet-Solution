package KthLargestElement;

import java.util.PriorityQueue;

public class KthLargest {
    int k;
    private PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int []nums){
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int i = 0; i<nums.length; i++){
            minHeap.add(nums[i]);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    public int add(int val){
        minHeap.add(val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
    public static void main (String[] args){
        KthLargest k = new KthLargest(3,new int []{1,2,3,3});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(6));
        System.out.println(k.add(7));
        System.out.println(k.add(8));

        
    }
}
