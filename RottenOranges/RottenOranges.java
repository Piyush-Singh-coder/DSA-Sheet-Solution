package RottenOranges;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Pair{
        int first;
        int second;
        int third;

        public Pair(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public static int rottenOranges(int grid[][]){
        Queue<Pair> q = new LinkedList<>();
        int freshCnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i<m ; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j,0));
                   
                }
                else if (grid[i][j] == 1){
                    freshCnt ++;
                }
            }
        }
        int count = 0;
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        int time = 0;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int t = q.peek().third;
            time = Math.max(time, t);
            q.poll();
            
            for(int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow <m && ncol < n && grid[nrow][ncol] == 1){
                    count ++;
                    q.add(new Pair(nrow, ncol, t + 1));
                    grid[nrow][ncol] = 2;
                }
            }
        }
        return count != freshCnt ? -1 : time;
    }
    public static void main(String[] args) {
        int oranges [][] = {{1,1,0},{0,1,1},{0,1,2}};
        System.out.println(rottenOranges(oranges));
    }
}
