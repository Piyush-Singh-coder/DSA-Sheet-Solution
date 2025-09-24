package CourseScheduleV1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleV1 {
    public static boolean canFinish(int numCourses, int prerequisites [][]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int inorder[] = new int[numCourses];
        for(ArrayList<Integer> adjList: adj){
            for (int val: adjList){
                inorder[val]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<numCourses; i++){
            if (inorder[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            topo.add(node);
            for(int it: adj.get(node)){
                inorder[it]--;
                if (inorder[it] == 0){
                    q.add(it);
                }
            }
        }
        return topo.size() == numCourses;
    }
    public static void main(String[] args) {
        int numCourses = 2;
        int prerequisites[][] = {{0,1}}; // True
        // int prerequisites[][] = {{0,1},{1,0}}; -- false
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
