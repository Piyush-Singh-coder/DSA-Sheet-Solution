package validPalindrome;

public class ValidPalindrome {
    public static boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1 ;
        while(i<j){
            while(i<j && !isalphaNum(str.charAt(i))){
                i++;
            }
            while(j>i && !isalphaNum(str.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean isalphaNum(char ch){
        return (ch >= 'a' && ch <='z' || ch >='A' && ch <='Z' || ch>='0' && ch <='9');
    }
    public static void main(String[] args) {
        String str = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(str));
    }
}
