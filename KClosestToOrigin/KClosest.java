package KClosestToOrigin;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosest {
    public static int[][] closest(int points[][], int k){
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0]+a[1]*a[1]));
        for(int i = 0; i<points.length; i++){
            maxHeap.add(points[i]);
            if (maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int res [][] = new int [k][2];
        int i = 0;
        while(!maxHeap.isEmpty()){
            res[i] = maxHeap.poll();
            i++;
        }
        return res;
    } 
    public static void main(String[] args) {
        int points[][] = {{0,2},{2,0},{2,2}};
        int k = 2;
        int res [][] = closest(points, k);
        for(int i = 0; i<res.length; i++){
            System.out.print(Arrays.toString(res[i]) + " ");
        }
        System.out.println();
    }
}
