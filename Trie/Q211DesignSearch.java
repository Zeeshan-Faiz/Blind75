package Trie;

/*
Design a data structure that supports adding new words and finding if a string matches any previously 
added string.

Implement the WordDictionary class:

    WordDictionary() Initializes the object.
    void addWord(word) Adds word to the data structure, it can be matched later.
    bool search(word) Returns true if there is any string in the data structure that matches word or 
    false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example 1:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
*/

public class Q211DesignSearch {
    
    Object[] trie;

    public Q211DesignSearch() {
        trie = new Object[27];
    }

    public void addWord(String word) {
        Object[] cur = trie;
        for (char c : word.toCharArray()) {
            if (cur[c - 'a'] == null) {
                cur[c - 'a'] = new Object[27];
            }
            cur = (Object[]) cur[c - 'a'];
        }
        cur[26] = new Object[1];
    }

    static boolean isWord(int ind, char[] word, Object[] subTrie) {
        if (word[ind] == '.') {
            boolean resp = false;
            for (int i = 0; i < 26; i++) {
                if (subTrie[i] != null) {
                    if (ind == word.length - 1) {
                        if (((Object[]) subTrie[i])[26] != null)
                            resp = true;
                    } else {
                        resp = isWord(ind + 1, word, (Object[]) subTrie[i]);

                    }
                    if (resp)
                        return true;
                }
            }
            return false;
        } else {
            if (subTrie[word[ind] - 'a'] != null) {
                if (ind == word.length - 1) {
                    Object[] next = (Object[]) subTrie[word[ind] - 'a'];
                    return next[26] != null;
                } else
                    return isWord(ind + 1, word, (Object[]) subTrie[word[ind] - 'a']);
            }
            return false;
        }
    }

    public boolean search(String word) {
        return isWord(0, word.toCharArray(), trie);
    }
}