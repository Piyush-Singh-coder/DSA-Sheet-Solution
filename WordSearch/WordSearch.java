package WordSearch;

public class WordSearch {
    public static boolean wordExist(char board[][], String word){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if (dfs(board,word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char board[][], String word, int i, int rows, int cols){
        if (i == word.length()){
            return true;
        }

        if(rows < 0 || cols < 0 || rows >= board.length || cols>= board[0].length || board[rows][cols] != word.charAt(i) || board[rows][cols] == '#'){
            return false;
        }
        board[rows][cols] = '#';
        boolean res = dfs(board, word, i+1, rows+1, cols) || 
                      dfs(board, word, i+1, rows-1, cols) ||
                      dfs(board, word, i+1, rows, cols-1) ||
                      dfs(board, word, i+1, rows, cols+1);
        board[rows][cols] = word.charAt(i);
        return res;
    }
    public static void main(String[] args) {
        char board[][] = { 
                            {'A','B','C','D'},
                            {'S','A','A','T'},
                            {'A','C','A','E'}
                          };
        String word = "CAT";
        System.out.println(wordExist(board, word));

    }
}
