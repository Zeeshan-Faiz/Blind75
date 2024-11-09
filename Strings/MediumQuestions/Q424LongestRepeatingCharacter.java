package Strings.MediumQuestions;

/*
You are given a string s and an integer k. You can choose any character of the string and change it 
to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing 
the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
*/

public class Q424LongestRepeatingCharacter {
    
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        char[] ans = s.toCharArray();
        int max = 0; // keep track of the maximum frequency of any single character
        int left = 0; 

        for (int right = 0; right < ans.length; right++) 
        {
            arr[ans[right] - 'A']++; // Increment the frequency of the current character
            max = Math.max(max, arr[ans[right] - 'A']);

            // If the number of characters to replace (j - i + 1 - max) is greater than k, shrink the window from the left
            while (right - left + 1 - max > k) {
                arr[ans[left++] - 'A']--; // Decrement the frequency of the character at the start of the window and move the left pointer
            }
        }
        return ans.length - left;
    }
}