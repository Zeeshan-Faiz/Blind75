package Tree;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) 
of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
*/

public class Q230KthSmallestElementInBST {
    
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode res = helper(root, k);
        return res.val;
    }

    public TreeNode helper(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = helper(root.left, k);
        // we have found an answer somewhere below just return the same
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }

        return helper(root.right, k);
    }
}