package NetworkDelayTime;

import java.util.*;

public class NetworkDelayTime {
    static class Pair {
        int v;
        int wt;

        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public static int dijikstra(int times[][], int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0]).add(new ArrayList<>(Arrays.asList(time[1], time[2])));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(k, 0));
        int dis[] = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dis[i] = (int) (1e9);
        }
        dis[k] = 0;
        while (!pq.isEmpty()) {
            int wt = pq.peek().wt;
            int v = pq.peek().v;
            pq.poll();
            for (int i = 0; i < adj.get(v).size(); i++) {
                int adjV = adj.get(v).get(i).get(0);
                int ajdWt = adj.get(v).get(i).get(1);
                if (wt + ajdWt < dis[adjV]) {
                    dis[adjV] = wt + ajdWt;
                    pq.add(new Pair(adjV, dis[adjV]));
                }
            }
        }
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == (int) 1e9)
                return -1; // node unreachable
            maxDist = Math.max(maxDist, dis[i]);
        }
        return maxDist;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 1;
        int times[][] = { { 1, 2, 1 }, { 2, 3, 1 }, { 1, 4, 4 }, { 3, 4, 1 } };
        System.out.println(dijikstra(times, n, k));
    }
}
