package Strings.MediumQuestions;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring
of s such that every character in t (including duplicates) is included in the window. If there is 
no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
*/

public class Q76MinWindowSubstring {
    
    public String minWindow(String s, String t) {
        
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) { // in t
                counter--;
            }
            while (counter == 0) { // valid
                if (end - begin < d) {
                    d = end - (head = begin);
                }
                if (map[s.charAt(begin++)]++ == 0) { // make it invalid
                    counter++;
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}