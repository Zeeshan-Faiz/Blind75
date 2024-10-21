package Array_Hashing_BinarySearch.MediumQuestions;

/*
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

public class Q152MaximumProductSubArray {
    
    public int maxProduct(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        long leftProd = 1, rightProd = 1;
        long maxProd = nums[0];

        for (int i = 0; i < n; i++) {

            // if any of leftProd or rightProd become 0 then update it to 1
            leftProd = (leftProd == 0 || leftProd < Integer.MIN_VALUE) ? 1 : leftProd;
            rightProd = (rightProd == 0 || rightProd < Integer.MIN_VALUE) ? 1 : rightProd;

            // prefix product
            leftProd = leftProd * nums[i];

            // suffix product
            rightProd = rightProd * nums[n - 1 - i];

            maxProd = Math.max(maxProd, Math.max(leftProd, rightProd));
        }
        return (int) maxProd;
    }
}