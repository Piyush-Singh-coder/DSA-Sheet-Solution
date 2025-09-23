package CoinChange;

public class CoinChange {
    public static int coinChange(int coins[], int amount, int i){
        if (amount == 0){
            return 0;
        }
        if (i == coins.length){
            return Integer.MAX_VALUE -1;
        }
        int take = Integer.MAX_VALUE;
        if (amount >= coins[i]){
            take = 1 + coinChange(coins, amount - coins[i], i);
        }
        int skip = coinChange(coins, amount, i+1);
        return Math.min(take, skip);
    }
    public static int dp(int coins[], int amount){
        int m = coins.length; 
        int n = amount;
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            for(int j = 0; j<= n; j++){
                if (j == 0){
                    dp[i][j] = 0;
                }
                if (i == 0 ){
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i = 1; i<= m; i++){
            for(int j = 1; j<= n; j++){
                if (coins[i-1] <= j){
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return (dp[m][n] == Integer.MAX_VALUE - 1 ) ? -1 : dp[m][n];
    }
    public static void main(String[] args){
        int coins [] = {1,5,10};
        int amount = 12;
        int res = coinChange(coins, amount, 0);
        if (res >= Integer.MAX_VALUE-1){
            System.out.println("Not possible to form");
        }else{
            System.out.println(res);
        }
        System.out.println(dp(coins, amount));
    }   
}
