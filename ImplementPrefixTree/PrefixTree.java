package ImplementPrefixTree;

class TrieNode{
        TrieNode children[] = new TrieNode[26];
        boolean endOfWords = false;
    }
public class PrefixTree {

    private TrieNode root;

    public PrefixTree(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.endOfWords = true;
    }

    public boolean search(String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWords;
    }

    public boolean startsWith(String prefix){
        TrieNode curr = root;
        for(int i = 0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        PrefixTree trie = new PrefixTree();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}
