package MinCostToConnectPoints;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinCostToConnectPoints {
    static class Pair{
        int first; 
        int second; 
        int par;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
            
        }
    }
    public static int minCost(int points[][]){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for (int i=0;i<points.length; i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i<points.length; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i+1; j<points.length; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dis = Math.abs(x1-x2) + Math.abs(y1 - y2);
                adj.get(i).add(new Pair(dis, j));
                adj.get(j).add(new Pair(dis, i));
            }
        }
        // for(ArrayList<Pair> it: adj){
        //     for (Pair p : it){
        //         System.out.print("("+p.first +"," + p.second+")");
        //     }
        //     System.out.println();
        // }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.first - b.first);
        pq.add(new Pair(0,0));
        int sum = 0;
        int vis[] = new int[points.length];
        while(pq.size() != 0){
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.poll();
            if (vis[node] == 1) continue;
            vis[node] = 1;
            sum += dis;
            for (int i = 0; i<adj.get(node).size(); i++){
                int adjWt = adj.get(node).get(i).first;
                int adjNode = adj.get(node).get(i).second;
                if (vis[adjNode] == 0){
                    pq.add(new Pair(adjWt, adjNode));
                }
            }
        } 
        return sum;
    }
    public static void main(String[] args) {
        int points[][] = {{0,0},{2,2},{3,3},{2,4},{4,2}};
        System.out.println(minCost(points));
    }
}
