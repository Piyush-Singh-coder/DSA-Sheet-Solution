package LetterCombOfPhoneNum;

import java.util.*;
public class LetterCombination {
    public static List<String> letterCombination(String digits){
        List<String> res = new ArrayList<>();
        String digitsToString[] = {"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};
        backtrack(digits, digitsToString, "",0,res);
        return res;
    }
    public static void backtrack(String digits, String digitsToString[],String currChar, int i, List<String> res){
        if (currChar.length() == digits.length()){
            res.add(currChar);
            return;
        }
        String chars = digitsToString[digits.charAt(i) - '0'];
        for(char ch: chars.toCharArray()){
            backtrack(digits, digitsToString, currChar + ch, i+1, res);
        }
    }
    public static void main(String[] args) {
        String digits = "34";
        System.out.println(letterCombination(digits));
    }

}
