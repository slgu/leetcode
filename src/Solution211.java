import com.sun.scenario.animation.shared.TimerReceiver;

/**
 * Created by slgu1 on 10/28/15.
 */
class WordDictionary {
    static class TrieNode {
        private int flg = 0;
        private TrieNode[] nodeList = new TrieNode[26];
    }
    private TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        int n = word.length();
        TrieNode itr = root;
        for (int i = 0; i < n; ++i) {
            int pos = word.charAt(i) - 'a';
            if (itr.nodeList[pos] != null) {
                itr = itr.nodeList[pos];
            }
            else {
                itr.nodeList[pos] = new TrieNode();
                itr = itr.nodeList[pos];
            }
        }
        itr.flg = 1;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    private boolean innerSearch(String word, int idx, TrieNode itr) {
        if (idx == word.length()) {
            if (itr.flg == 1)
                return true;
            return false;
        }
        char tmp = word.charAt(idx);
        if (tmp == '.') {
            for (int i = 0; i < 26; ++i) {
                if (itr.nodeList[i] != null) {
                    if (innerSearch(word, idx + 1, itr.nodeList[i]))
                        return true;
                }
            }
            return false;
        }
        else {
            int pos = tmp - 'a';
            if (itr.nodeList[pos] == null)
                return false;
            else
                return innerSearch(word, idx + 1, itr.nodeList[pos]);
        }
    }
    public boolean search(String word) {
        return innerSearch(word, 0, root);
    }
}

public class Solution211 {
    public static void main(String [] args) {
        WordDictionary a = new WordDictionary();
        a.addWord("bad");
        a.addWord("mad");
        a.addWord("dad");
        System.out.println(a.search("pad"));
        System.out.println(a.search("bad"));
        System.out.println(a.search(".ad"));
        System.out.println(a.search("b.."));
    }
}
