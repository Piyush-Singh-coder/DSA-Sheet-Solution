package wordBreak;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, String [] wordDict, int i){
        if (i == s.length()){
            return true;
        }
        for(String word: wordDict){
            if(i+ word.length() <= s.length() && s.substring(i, i+word.length()).equals(word)){
                if (wordBreak(s, wordDict, i+word.length())){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean topdown(String s, String[] wordDict){
        Map<Integer,Boolean> memo = new HashMap<>();
        memo.put(s.length(), true);

        return dfs(s, wordDict, memo, 0);
    }
    public static boolean dfs(String s, String[] wordDict, Map<Integer, Boolean> memo, int i){
        if (memo.containsKey(i)){
            return memo.get(i);
        }
        for(String word: wordDict){
            if (i + word.length() <= s.length() && s.substring(i, i+word.length()).equals(word)){
                if(dfs(s, wordDict, memo, i+word.length())){
                    memo.put(i,true);
                    return true;
                }
            }
        }
        memo.put(i, false);
        return false;
    }
    public static void main(String[] args) {
        String s = "neetcode";
        String wordDict [] = {"neet","code"};
        System.out.println(wordBreak(s, wordDict, 0));
        System.out.println(topdown(s,wordDict));
    }

}
