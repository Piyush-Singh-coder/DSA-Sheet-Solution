package PalindromePartitioning;

import java.util.*;
public class Partitioning {
    public static List<List<String>> partiton(String str){
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        validPartiton(str, 0, res, list);
        return res;
    }
    public static void validPartiton(String str, int idx, List<List<String>> res, List<String> list){
        if (idx >= str.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i<str.length(); i++){
            if (isPalindrome(str, idx, i)){
                list.add(str.substring(idx, i+1));
                validPartiton(str, i+1, res, list);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String str, int i, int j){
        while(i<j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "aab";
        System.out.println(partiton(str));
    }
}
