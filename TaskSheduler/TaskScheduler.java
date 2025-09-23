package TaskSheduler;

import java.util.*;

public class TaskScheduler {
    public static int task(char tasks[], int k){
        int count[] = new int[26];
        for(int i = 0; i<tasks.length; i++){
            count[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for(int i = 0; i<count.length; i++){
            if (count[i] > 0){
                maxHeap.add(count[i]);
            }
        }
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if (maxHeap.isEmpty()){
                time = queue.peek()[1];
            }else{
                int cnt = maxHeap.poll()-1;
                if (cnt > 0){
                    queue.add(new int[]{cnt, time + k});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxHeap.add(queue.poll()[0]);
            }
        }
        return time;
    }
    public static void main(String[] args) {
        char tasks[] = {'A','A','A','B','C'};
        // char tasks1[] = {'X','X','Y','Y'};
        int  k = 3;
        System.out.println(task(tasks, k));
    }
}
