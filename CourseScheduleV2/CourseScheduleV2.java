package CourseScheduleV2;

import java.util.*;
public class CourseScheduleV2 {
    public static int[] canFinish(int numCourse, int prerequisites[][]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< numCourse; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int inorder [] = new int[numCourse];
        for (ArrayList<Integer> it : adj){
            for (int val: it){
                inorder[val]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<numCourse; i++){
            if (inorder[i] == 0){
                q.add(i);
            }
        }
        int topo[] = new int[numCourse];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo[i] = node;
            i++;
            for(int val: adj.get(node)){
                inorder[val]--;
                if (inorder[val] == 0){
                    q.add(val);
                }
            }
        }
        return i == numCourse ? topo : new int[]{};
    }
    public static void main(String[] args) {
        int numCourse = 4;
        int prerequisites [][] = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(canFinish(numCourse, prerequisites)));
    }
}