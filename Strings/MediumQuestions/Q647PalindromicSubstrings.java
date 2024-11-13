package Strings.MediumQuestions;

/*
Given a string s, return the number of palindromic substrings in it. A string is a palindrome when 
it reads the same backward as forward. A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/

public class Q647PalindromicSubstrings {
    
    public int countSubstrings(String s) {
        
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int even = palindromeCount(s, i, i + 1);
            int odd = palindromeCount(s, i - 1, i + 1);
            ans += even + odd + 1;
        }
        return ans;
    }

    public int palindromeCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
        return count;
    }
}