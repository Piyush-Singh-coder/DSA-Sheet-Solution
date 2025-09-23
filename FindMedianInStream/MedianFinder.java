package FindMedianInStream;

import java.util.*;

public class MedianFinder {
    private ArrayList<Integer> res;

    public MedianFinder(){
        res = new ArrayList<>();
    }
    public void addNum(int num){
        res.add(num);
    }
    public double findMedian(){
        Collections.sort(res);
        int n = res.size();
        if (n % 2 == 0){
            return (res.get(n/2)+ res.get((n/2)-1)) /2.0;
        }
        else{
            return res.get(n/2);
        }
    }
    public static void main(String[] args) {
        MedianFinder mid = new MedianFinder();
        mid.addNum(1);
        System.out.println(mid.findMedian());
        mid.addNum(3);
        System.out.println(mid.findMedian());
        mid.addNum(2);
        System.out.println(mid.findMedian());

    }
}
