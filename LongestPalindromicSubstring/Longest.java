package LongestPalindromicSubstring;

public class Longest {
    public static String recursion(String s){
        int resLen = 0;
        int resIdx = 0;
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        for(int i = n-1; i>= 0; i--){
            for(int j = i; j< n; j++){
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if ((j-i+1) > resLen){
                        resIdx = i;
                        resLen = j-i+1;
                    }
                }
            }
        }
        return s.substring(resIdx, resIdx + resLen);
    }
    public static void main(String[] args) {
        String s = "ababd";
        System.out.println(recursion(s));
    }   
}
