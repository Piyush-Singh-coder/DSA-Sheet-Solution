package ValidAnagram;

import java.util.HashMap;

public class ValidAnagram {

    public static boolean optimal3(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        int frequency[] = new int[26];
        for(int i = 0; i<str1.length(); i++){

            frequency[str1.charAt(i) - 'a']++;
            frequency[str2.charAt(i) - 'a']--;
        }
        for(int i = 0; i<frequency.length; i++){
            if(frequency[i] != 0){
                return false;
            }
        }
        return true;
    }
    public static boolean optimal2(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        HashMap<Character, Integer> res1 = new HashMap<>();
        HashMap<Character, Integer> res2 = new HashMap<>();

        for(int i = 0; i<str1.length(); i++){
            char ch = str1.charAt(i);
            if (res1.containsKey(ch)){
                res1.put(ch, res1.get(ch)+1);
            }else{
                res1.put(ch, 1);
            }
        }
        for(int i = 0; i<str2.length(); i++){
            char ch = str2.charAt(i);
            if (res2.containsKey(ch)){
                res2.put(ch, res2.get(ch)+1);
            }else{
                res2.put(ch, 1);
            }
        }
        System.out.println(res1);
        System.out.println(res2);
        return res1.equals(res2);
    }


    public static boolean optimal(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i=0; i<str1.length(); i++){
            char ch = str1.charAt(i);
            if(hashMap.containsKey(ch)){
                hashMap.put(ch, hashMap.get(ch)+1);
            }else{
                hashMap.put(ch,1);
            }
        }
        for(int i = 0; i<str2.length(); i++){
            char ch = str2.charAt(i);
            if(hashMap.containsKey(ch)){
                hashMap.put(ch, hashMap.get(ch)-1);
                if(hashMap.get(ch) == 0){
                    hashMap.remove(ch);
                }else{
                    return false;
                }
            }
        }
        return hashMap.isEmpty();
    }
    public static void main(String[] args){
        String str1 = "catt";
        String str2 = "taac";
        System.out.println(optimal3(str1, str2));
    }
}
