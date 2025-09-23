package ValidParenthesis;

import java.util.*;
public class ValidParenthesis {
    public static boolean optimal(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{'){
                s.push(ch);
            }else if (ch == '}' || ch == ']' || ch == ')'){
                if (s.isEmpty()){
                    return false;
                }
                int top = s.pop();
                // only same opening parenthesis should pop same closing parenthesis 

                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')){     
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        String str = "([{}])";
        System.out.println(optimal(str));
    }
}
