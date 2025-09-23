package PermutationInString;

public class Permutation {
    public static boolean isFreqEqual(int hash1[], int hash2[]){
        for(int i = 0; i<26; i++){
            if (hash1[i] != hash2[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean optimal(String s1, String s2){
        int hash1[] = new int[26];
        for(int i = 0; i<s1.length(); i++){
            hash1[s1.charAt(i)-'a']++;
        }
        int windowSize = s1.length();
        for(int i = 0; i<s2.length(); i++){
            int windowidx = 0, idx = i;
            int hash2[] = new int[26];
            while(windowidx < windowSize && idx <s2.length()){
                hash2[s2.charAt(idx) - 'a']++;
                windowidx++;
                idx++;
            }
            if (isFreqEqual(hash1, hash2)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "lecabee";
        System.out.println(optimal(s1, s2));
    }
}
