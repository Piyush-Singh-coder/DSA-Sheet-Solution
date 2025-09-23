package MaxAreaIsland;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaIsland {
    static class Pair{
        int first;
        int second; 

        public Pair(int first, int second){
            this.first = first; 
            this.second = second;
        }
    }
    public static int bfs(int r, int c, int vis[][], int grid[][]){
        int sum = 0;
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        int m = grid.length;
        int n = grid[0].length;
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col =  q.peek().second;
            sum = sum + grid[row][col];
            q.poll();
            for(int i =0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow>= 0 && nrow < m && ncol>=0 && ncol<n && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }

            }
        }
        return sum;
    }
    public static int maxArea(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int vis[][] = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if (vis[i][j] == 0 && grid[i][j] == 1){
                    int sum = bfs(i,j, vis, grid);
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println("Number of islands: " + maxArea(grid));
    }
}
