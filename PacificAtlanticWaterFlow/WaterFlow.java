package PacificAtlanticWaterFlow;

import java.util.*;
public class WaterFlow {
    static class Pair{
        int first;
        int second; 
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static ArrayList<int[]> waterFlow(int heights[][]){  //public static List<List<Integer>> waterFlow(int heights[][]){
        ArrayList<int[]> res = new ArrayList<>();  // List<List<Integer>> res = new ArrayList<>()
        int m = heights.length;
        int n = heights[0].length;
        boolean pac[][] = new boolean[m][n];
        boolean atl[][] = new boolean[m][n];

        Queue<Pair> pacq = new LinkedList<>();
        Queue<Pair> atlq = new LinkedList<>();

        for (int i = 0; i<n; i++){
            pacq.add(new Pair(0, i));
            atlq.add(new Pair(m-1, i));
        }
        for (int i = 0; i<m; i++){
            pacq.add(new Pair(i, 0));
            atlq.add(new Pair(i, n-1));
        }
        bfs(heights, pacq, pac);
        bfs(heights, atlq, atl);
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (pac[i][j] && atl[i][j]){
                    res.add(new int[]{i,j});  // res.add(Arrays.asList(i,j))
                }
            }
        }
        return res;
    }
    public static void bfs(int heights[][], Queue<Pair> q, boolean ocean[][]){
        int n = heights[0].length;
        int m = heights.length;
        int delrow [] = {-1,0,1,0};
        int delcol [] = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            ocean[row][col] = true;
            for(int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && !ocean[nrow][ncol] && heights[nrow][ncol]>= heights[row][col]){
                    q.add(new Pair(nrow, ncol));
                }

            }
        }
    }
    public static void main(String[] args) {
        int heights[][] = {
                          {4,2,7,3,4},
                          {7,4,6,4,7},
                          {6,3,5,3,5}
        };
        ArrayList<int[]> res = waterFlow(heights);
        for (int i = 0; i<res.size(); i++){
            System.out.print(Arrays.toString(res.get(i)) + " ");
        }
        System.out.println();
    }
}
