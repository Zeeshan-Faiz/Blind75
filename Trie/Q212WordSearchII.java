package Trie;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are 
horizontally or vertically neighboring. The same letter cell may not be used more than once in a 
word.

Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
*/

public class Q212WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> resList = new ArrayList<>();
        TrieNode trieRoot = trieFromArray(words);

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                char boardChar = board[y][x];
                if (trieRoot.children[boardChar - 'a'] != null) {
                    checkRecursive(board, x, y, trieRoot, resList);
                }
            }
        }

        return resList;
    }

    private final void checkRecursive(char[][] board, int x, int y, TrieNode parentNode, List<String> resultList) {
        if (x < 0 || y < 0 || y >= board.length || x >= board[y].length)
            return;

        char boardChar = board[y][x];
        if (boardChar == '$')
            return;

        TrieNode nextNode = parentNode.children[boardChar - 'a'];

        if (nextNode == null)
            return;
        if (nextNode.isEnd) {
            resultList.add(nextNode.word);

            if (nextNode.count > 0) {
                nextNode.isEnd = false;
            } else {
                parentNode.children[boardChar - 'a'] = null;
                parentNode.count--;
                return;
            }
        }

        board[y][x] = '$';
        try {
            checkRecursive(board, x - 1, y, nextNode, resultList); // left
            checkRecursive(board, x + 1, y, nextNode, resultList); // right
            checkRecursive(board, x, y - 1, nextNode, resultList); // top
            checkRecursive(board, x, y + 1, nextNode, resultList); // bottom

            if (nextNode.count == 0 && !nextNode.isEnd) {
                parentNode.children[boardChar - 'a'] = null;
                parentNode.count--;
            }
        } finally {
            board[y][x] = boardChar;
        }
    }

    private TrieNode trieFromArray(String[] words) {
        TrieNode root = new TrieNode();

        for (var w : words) {
            TrieNode curNode = root;

            for (var c : w.toCharArray()) {
                if (curNode.children[c - 'a'] == null) {
                    curNode.children[c - 'a'] = new TrieNode();
                    curNode.count++;
                }
                curNode = curNode.children[c - 'a'];
            }
            curNode.isEnd = true;
            curNode.word = w;
        }

        return root;
    }
}

class TrieNode {
    public static final int CHILDREN_CNT = 26;

    boolean isEnd = false;
    String word = null;
    TrieNode[] children = new TrieNode[CHILDREN_CNT];
    int count = 0;
}