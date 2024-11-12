package Strings.MediumQuestions;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
*/

public class Q5LongestPalindromicSubString {
    
    int maxLen = 0;// length of longest palindrome
    int lo = 0;

    public String longestPalindrome(String s) {

        if (s.length() < 2)
            return s;

        char[] input = s.toCharArray();

        // i act as a centre of palindrome
        for (int i = 0; i < input.length; i++) {
            expandPalindrome(input, i, i);//check for odd length palindrome
            expandPalindrome(input, i, i + 1);//check for even length palindrome
        }
        return s.substring(lo, lo + maxLen);
    }

    public void expandPalindrome(char[] s, int j, int k) {
        
        while (j >= 0 && k < s.length && s[j] == s[k]) {
            j--;// expand left
            k++;// expand right
        }

        //resize the starting and end index of palindrome
        if (maxLen < k - j - 1) {
            maxLen = k - j - 1;
            lo = j + 1;
        }
    }
}