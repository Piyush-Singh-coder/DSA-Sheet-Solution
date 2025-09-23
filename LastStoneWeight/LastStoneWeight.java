package LastStoneWeight;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int stones[]){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int i= 0; i<stones.length; i++){
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 == stone2){
                continue;
            }
            else if (stone1 > stone2){
                maxHeap.add(stone1 - stone2);
            }
            else if (stone2 > stone1){
                maxHeap.add(stone2 - stone1);
            }
        }
        return !maxHeap.isEmpty() ? maxHeap.peek() : 0;
    }
    public static void main(String[] args) {
        int stones[] = {2,3,6,2,4};
        System.out.println(lastStoneWeight(stones));
    }
}
