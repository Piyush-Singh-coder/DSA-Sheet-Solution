package MinimumSlidingWindow;

import java.util.*;

public class MinimumSlidingWindow {
    public static String optimal(String s, String t){
        HashMap<Character, Integer> freq1 = new HashMap<>();
        for(char ch : t.toCharArray()){
            freq1.put(ch, freq1.getOrDefault(ch, 0)+1);
        }
        int left = 0;
        int count = 0;
        int freq1Count = freq1.size();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        HashMap<Character,Integer> freq2 = new HashMap<>();
        for (int right = 0; right<s.length(); right++ ){
            char ch = s.charAt(right);
            freq2.put(ch, freq2.getOrDefault(ch,0)+1);
            if(freq1.containsKey(ch) && freq1.get(ch).intValue() == freq2.get(ch).intValue()){
                count++;
            }
            while(count == freq1Count){
                if (right-left +1 < minLen){
                    minLen = right - left +1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                freq2.put(leftChar, freq2.get(leftChar)-1);
                if (freq1.containsKey(leftChar) && freq2.get(leftChar).intValue() < freq1.get(leftChar).intValue() ){
                    count--;
                }
                left++;
            }
        }
        return minLen == Integer.MIN_VALUE ? "" : s.substring(start, start+minLen);
    }
    public static void main(String[] args) {
        String s  = "ADOBECODEBANC";
        String t = "ABC";
       System.out.println( optimal(s, t));
    }   
}
