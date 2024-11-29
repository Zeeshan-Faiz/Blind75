import java.util.ArrayList;
import java.util.List;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers 1 through 9 are used.
    Each number is used at most once.

Return a list of all possible valid combinations. The list must not contain the same combination twice, 
and the combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
*/

public class Q216CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        helper(k, n, ans, new ArrayList<>(), 1, 0);
        return ans;
    }

    private void helper(int k, int n, List<List<Integer>> ans, List<Integer> currList, int start, int sum) {

        if (currList.size() == k) {
            if (sum == n)
                ans.add(new ArrayList<>(currList));

            return;
        }

        for (int i = start; i < 10; i++) {

            if (sum + i <= n) {
                currList.add(i);
                helper(k, n, ans, currList, i + 1, sum + i);
                currList.remove(currList.size() - 1);
            } else
                break;
        }
    }
}