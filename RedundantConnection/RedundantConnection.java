package RedundantConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RedundantConnection {
    public static int[] findRedundantConnection(int edges[][]){
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<= n; i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n+1];
        for (int i = 0; i<n ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<= n ;i++){
            if (indegree[i] == 1){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.remove();
            indegree[node]--;
            for (int it: adj.get(node)){
                indegree[it] --;
                if (indegree[it]== 1){
                    q.add(it);
                }
            }
        }
        for(int i = edges.length-1; i>=0; i--){
            int u = edges[i][0];
            int v = edges[i][1];
            if (indegree[u] == 2 && indegree[v] > 0){
                return new int[]{u,v};
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int [][]edges = {{1,2},{1,3},{1,4},{3,4},{4,5}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }
}
