package FindMedianInStream;

import java.util.*;
public class MedianFinderV2 {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;
    
    public MedianFinderV2(){
        smallHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        largeHeap = new PriorityQueue<>();
    }
    public void addNum(int num){
        smallHeap.add(num);
        if (smallHeap.size() - largeHeap.size() > 1 || !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()){
            largeHeap.add(smallHeap.poll());
        }
        if (largeHeap.size() - smallHeap.size() > 1){
            smallHeap.add(largeHeap.poll());
        }
    }
    public double findMedian(){
        if (smallHeap.size() == largeHeap.size()){
            return (double) (largeHeap.peek() + smallHeap.peek())/2;
        }else if (largeHeap.size() > smallHeap.size()){
            return (double) largeHeap.peek();
        }else{
            return (double) smallHeap.peek();
        }
    }
    public static void main(String[] args) {
        MedianFinderV2 mid = new MedianFinderV2();
        mid.addNum(1);
        System.out.println(mid.findMedian());
        mid.addNum(3);
        System.out.println(mid.findMedian());
        mid.addNum(2);
        System.out.println(mid.findMedian());
    }
}
