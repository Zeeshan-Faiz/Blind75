/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., 
grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The 
robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take 
to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
*/

import java.util.Arrays;

public class Q62UniquePaths {
    
    public int uniquePaths(int m, int n) {
        
        // Create a 2D DP array to store the results
        int dp[][] = new int[m][n];

        // Initialize the DP array with -1 to indicate uncomputed values
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Call the countWaysUtil function to calculate and return the result
        return countWaysUtil(m, n, dp);
    }

    public int countWaysUtil(int m, int n, int[][] dp) {
        
        // Loop through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base condition: If we are at the top-left cell (0, 0), there's one way to reach it.
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];

                // Store the total number of ways to reach the current cell in the DP array
                dp[i][j] = up + left;
            }
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return dp[m - 1][n - 1];
    }
}