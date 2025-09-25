package GraphValidTree;


import java.util.*;

public class GraphValidTree {
    static class Pair{
        int node;
        int parent;

        public Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public static boolean isValidTree(int n, int edges[][]){
        if (edges.length != n-1 ) return false;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int vis[] = new int[n];
        Queue<Pair> q = new LinkedList<>();
        vis[0] = 1;
        q.add(new Pair(0, -1));
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.poll();
            for ( int val : adj.get(node)){
                if (vis[val] == 0){
                    q.add(new Pair(val, node));
                    vis[val] = 1; 
                }else if (val != parent){
                    return false;
                }
            }
        }
        for (int i = 0; i<n; i++){
            if (vis[i] == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 5;
        int edges [][] = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(isValidTree(n, edges));
    }
}
