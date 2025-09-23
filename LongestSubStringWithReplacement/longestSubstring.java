package LongestSubStringWithReplacement;

public class longestSubstring {
    public static int bruteForce(String str, int k){
        int maxLen = 0;
        for(int i = 0; i<str.length(); i++){
            int hash[] = new int[26];
            int maxf = 0;
            for(int j = i; j<str.length(); j++){
                char ch = str.charAt(j);
                hash[ch-'A']++;
                maxf = Math.max(maxf,hash[ch-'A']);
                if (((j-i+1)- maxf) <=k){
                    maxLen = Math.max(maxLen, j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxLen;
    }

    public static int optimal(String str, int k ){
        int maxLen = 0; 
        int maxf = 0;
        int l= 0, r=0;
        int hash[] = new int[26];
        while(r<str.length()){
            char ch = str.charAt(r);
            hash[ch-'A']++;
            maxf = Math.max(maxf, hash[ch-'A']);
            if ((r-l+1) - maxf > k){
                l++;
            }
            if ((r-l+1) - maxf <=k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "XYYX";
        int k = 2;
        System.out.println(optimal(str, k));
    }
}
