import java.util.*;

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/

public class Q300LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        // Start main pointer
        for (int i = 1; i < nums.length; i++) 
        {
            // Start second pointer
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    if (dp[j] + 1 > dp[i])
                        dp[i] = dp[j] + 1;
                }
            }
        }
        // find the max value
        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++)
            if (dp[i] > dp[maxIndex])
                maxIndex = i;

        return dp[maxIndex];
    }
}