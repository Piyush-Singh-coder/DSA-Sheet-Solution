package IslandsTreasure;

import java.util.LinkedList;
import java.util.Queue;

public class IslandsTreasure {
    static class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void islandsTreasure(int grid[][]){
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n; j++){
                if (grid[i][j] == 0){
                    q.add(new Pair(i, j));
                }
            }
        }
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            for(int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow>=0 && ncol >= 0 && nrow < m && ncol < n && grid[nrow][ncol] == (int)1e9){
                    grid[nrow][ncol] = 1 + grid[row][col];
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
    public static void main(String[] args) {
        int grid [][] = {
                        {(int)1e9, -1,0, (int)1e9},
                        {(int)1e9,(int)1e9,(int)1e9,-1},
                        {(int)1e9,-1,(int)1e9,-1},
                        {0,-1,(int)1e9,(int)1e9}
                        };
        islandsTreasure(grid);
        for (int i = 0;i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
