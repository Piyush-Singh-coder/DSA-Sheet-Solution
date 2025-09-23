package CountPalindromicSubstring;

public class Count {
    public static int count(String s){
        int res = 0;
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        for(int i = n-1; i>= 0; i--){
            for(int j = i; j<n; j++){
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    res ++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "ababd";
        System.out.println(count(s));
    }
}
