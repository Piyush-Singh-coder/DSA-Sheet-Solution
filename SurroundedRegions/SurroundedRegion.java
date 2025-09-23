package SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion {
    static class Pair{
        int first; 
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void region(char board[][]){
        int m = board.length;
        int n = board[0].length;
        bfs(board);
        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){
                if (board[i][j] == 'T'){
                    board[i][j] = '0';
                }else if(board[i][j] == '0'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void bfs(char board[][]){
        Queue<Pair> q = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if ((i == 0 || i == m-1 || j == 0 || j == n-1) && board[i][j] == '0'){
                    q.add(new Pair(i, j));
                }
            }
        }
        int delrow [] = {-1,0,1,0};
        int delcol [] = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            if (board[row][col] == '0'){
                board[row][col] = 'T';
            }
            for (int i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >=0 && nrow < m && ncol >= 0 && ncol < n && board[nrow][ncol] == '0'){
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
    public static void main(String[] args) {
        char board[][] = {
                         {'X','X','X','X'},
                         {'X','0','0','X'},
                         {'X','0','0','X'},
                         {'X','X','X','0'}
        };
        region(board);
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
