package ConnectedComponentsInGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountConnectedComponents {
    public static int count(int n, int edges[][]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int res = 0;
        int vis[] = new int[n];
        for (int i = 0; i<n ; i++){
            if (vis[i] == 0){
                res ++;
                bfs(adj, vis, i);
            }
        }
        return res;
    }
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int vis[], int node){
        Queue<Integer> q = new LinkedList<>();
        vis[node] = 1;
        q.add(node);
        while(!q.isEmpty()){
            int val = q.remove();
            for (int it: adj.get(val)){
                if (vis[it] == 0){
                    q.add(it);
                    vis[it] = 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int [][]edges={{0,1}, {1,2},{2,3},{4,5}};
        System.out.println(count(n, edges));
    }
}
