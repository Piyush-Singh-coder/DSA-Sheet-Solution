package NoOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
    static class Pair{
        int first; 
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void bfs(int row, int col, int vis[][], char grid[][]){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        int m = grid.length; 
        int n = grid[0].length;
        while(!q.isEmpty()){
            int nrow = q.peek().first;
            int ncol = q.peek().second;
            q.poll();
            for(int i = 0; i<delrow.length; i++){
                    int r = nrow+ delrow[i];
                    int c = ncol + delcol[i];
                    if (r >= 0 && r<m && c>=0 && c<n && vis[r][c] == 0 && grid[r][c] == '1'){
                        vis[r][c] = 1;
                        q.add(new Pair(r, c));
                    }
            }
        }
    }
    public static int numIslands(char [][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int count = 0;
        for(int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (vis[i][j] == 0 && grid[i][j] == '1'){
                    count ++;
                    bfs(i,j, vis, grid);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + numIslands(grid));
    }
}
