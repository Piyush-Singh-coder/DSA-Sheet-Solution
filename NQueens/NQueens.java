package NQueens;

import java.util.*;

public class NQueens {
    public static List<List<String>> nQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char board[][] = new char[n][n];
        
        // initialize board with '.'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(board, res, 0);
        return res;
    }

    public static void backtrack(char board[][], List<List<String>> res, int col) {
        if (col == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            res.add(new ArrayList<>(list));
            return; // important to return after adding a solution
        }

        for (int row = 0; row < board.length; row++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, res, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isValid(char board[][], int row, int col) {
        // check left side in the same row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check lower-left diagonal
        for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = nQueens(n);
        
        // print solutions
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
