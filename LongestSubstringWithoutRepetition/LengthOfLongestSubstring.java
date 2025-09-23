package LongestSubstringWithoutRepetition;


import java.util.*;
public class LengthOfLongestSubstring {
    public static int bruteForce(String str){
        int res = 0;
        for(int i=0; i<str.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j = i; j<str.length(); j++){
                if(set.contains(str.charAt(j))){
                    break;
                }
                set.add(str.charAt(j));
            }
            res = Math.max (set.size(), res);
        }
        return res;
    }
   
    public static int optimal(String str){
        int l = 0;
        int r = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(r<str.length()){
            while(set.contains(str.charAt(r))){
                set.remove(str.charAt(l));
                l++;
            }
            set.add(str.charAt(r));
            res = Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "zxyzxyz";
        System.out.println(optimal(str));
    }
}
