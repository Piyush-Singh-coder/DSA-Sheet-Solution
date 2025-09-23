package GroupAnagrams;

import java.util.*;
public class GroupAnagram {
    public static List<List<String>> optimal(String str[]){
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for(String s : str){
            int count[] = new int[26];
            for(int i = 0; i<s.length(); i++){
                char ch = s.charAt(i);
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!hashMap.containsKey(key)){
                hashMap.put(key, new ArrayList<>());
            }
            hashMap.get(key).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }
    public static void main(String[] args){
        String str[] = {"act","pots","tops","cat","stop","hat"};
        System.out.println(optimal(str));
    } 
}
