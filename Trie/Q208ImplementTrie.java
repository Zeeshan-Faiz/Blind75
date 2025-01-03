package Trie;

/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and 
retrieve keys in a dataset of strings. There are various applications of this data structure, such 
as autocomplete and spellchecker.

Implement the Trie class:
    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted 
    before), and false otherwise.
    boolean startsWith(String prefix) Returns true if there is a previously inserted string word 
    that has the prefix prefix, and false otherwise.

Example 1:
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
*/

public class Q208ImplementTrie {
    
    Node root;

    public Q208ImplementTrie() {
        root = new Node();
    }

    public void insert(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    class Node {
        Node[] nodes;
        boolean isEnd;

        Node() {
            nodes = new Node[26];
        }

        private void insert(String word, int idx) {
            if (idx >= word.length())
                return;
            int i = word.charAt(idx) - 'a';
            if (nodes[i] == null) {
                nodes[i] = new Node();
            }

            if (idx == word.length() - 1)
                nodes[i].isEnd = true;
            nodes[i].insert(word, idx + 1);
        }

        private boolean search(String word, int idx) {
            if (idx >= word.length())
                return false;
            Node node = nodes[word.charAt(idx) - 'a'];
            if (node == null)
                return false;
            if (idx == word.length() - 1 && node.isEnd)
                return true;

            return node.search(word, idx + 1);

        }

        private boolean startsWith(String prefix, int idx) {
            if (idx >= prefix.length())
                return false;
            Node node = nodes[prefix.charAt(idx) - 'a'];
            if (node == null)
                return false;
            if (idx == prefix.length() - 1)
                return true;

            return node.startsWith(prefix, idx + 1);
        }
    }
}