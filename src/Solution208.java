/**
 * Created by slgu1 on 9/21/15.
 */
class TrieNode {
    // Initialize your data structure here.
    boolean flag;
    public TrieNode() {
        //26 character
        nxt = new TrieNode[26];
        flag = false;
    }
    TrieNode [] nxt;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode itr = root;
        for (Character c: word.toCharArray()) {
            int idx = c  - 'a';
            //important
            if (itr.nxt[idx] == null) {
                itr.nxt[idx] = new TrieNode();
            }
            itr = itr.nxt[idx];
        }
        //set flag
        itr.flag = true;
    }

    private TrieNode itrPrefix(String word) {
        TrieNode itr = root;
        for (Character c: word.toCharArray()) {
            int idx = c - 'a';
            if (itr.nxt[idx] == null) {
                return null;
            }
            itr = itr.nxt[idx];
        }
        return itr;
    }
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode itr = itrPrefix(word);
        if (itr == null)
            return false;
        if (!itr.flag)
            return false;
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode itr = itrPrefix(prefix);
        if (itr == null)
            return false;
        return true;
    }
}
public class Solution208 {
    public static void main(String [] args) {
        Trie a = new Trie();
        a.insert("fuck");
        a.insert("asd");
        a.insert("f");
        System.out.println(a.search("fuck"));
        System.out.println(a.search("fuc"));
    }
}
