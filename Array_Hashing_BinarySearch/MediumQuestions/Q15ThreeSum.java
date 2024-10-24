package Array_Hashing_BinarySearch.MediumQuestions;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, 
i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
*/

public class Q15ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) 
        {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) 
            {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    k--;
                } 
                else if (sum < 0) {
                    j++;
                } 
                else 
                {
                    // Found a triplet with zero sum
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    // Skip duplicate elements for j
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}