package Tree;

/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence 
has an edge connecting them. A node can only appear in the sequence at most once. Note that the 
path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.

Example 1:

*/

public class Q124BinaryTreeMaxPathSum {
    
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        helper(root);
        return ans;
    }
    int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + node.val;

        ans = Math.max(ans, pathSum);

        return Math.max(left, right) + node.val;
    }
}