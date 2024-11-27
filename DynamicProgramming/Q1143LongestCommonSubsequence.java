
/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there 
is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters 
(can be none) deleted without changing the relative order of the remaining characters.
    For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
*/

public class Q1143LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        return lcsBU(s1, s2);
    }

    public static int lcsBU(char[] s1, char[] s2) {
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                int ans = 0;
                if (s1[i - 1] == s2[j - 1]) {
                    ans = 1 + dp[i - 1][j - 1];
                } else {
                    int a = dp[i - 1][j];
                    int b = dp[i][j - 1];
                    ans = Math.max(a, b);
                }
                dp[i][j] = ans;
            }
        }
        return dp[s1.length][s2.length];
    }
}