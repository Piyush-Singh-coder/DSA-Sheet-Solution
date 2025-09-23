package ClimbingStairs;

public class ClimbingStairs {
    public static int recursion(int n){
        return dfs(n, 0);
    }
    public static int dfs(int n , int i ){
        if (i >= n){
            return i == n ? 1 : 0;
        }
        return dfs(n, i+1) + dfs(n , i+2);
    }
    public static int memo(int n){
        int memo [] = new int[n];
        for(int i = 0; i<memo.length; i++){
            memo[i] = -1;
        }
        return topDown(n, 0 , memo);
    }
    public static int topDown(int n, int i, int memo[]){
        if (i>= n){
            return i == n ? 1: 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        return topDown(n, i+1, memo) + topDown(n, i+2, memo);

    }
    public static void main(String[] args) {
        int n  = 3;
        System.out.println(memo(n));
    }
}
