package WordLadder;

import java.util.*;

public class WordLadder {
    static class Pair{
        String first;
        int second;

        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }

    }
    public static int wordLadderLength(String[] wordList, String startWord, String targetWord){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 0));
        Set<String> s = new HashSet<>();
        for (int i = 0; i<wordList.length; i ++){
            s.add(wordList[i]);
        }
        s.remove(startWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if (word.equals(targetWord)) return steps;
            for (int i = 0; i<word.length(); i++){
                for (char ch = 'a' ; ch<= 'z' ; ch ++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (s.contains(replacedWord) == true){
                        s.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String beginWord = "cat";
        String endWord = "sag";
        String wordList[] = {"bat","bag","sag","dag","dot"};
        System.out.println(wordLadderLength(wordList, beginWord, endWord));
    }
}
