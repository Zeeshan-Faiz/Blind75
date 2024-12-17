package Tree;

/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary 
tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]
*/

public class Q106ConstructBinaryTreeFromInAndPreorder {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder,
            int postStart) {
        if (postStart < 0 || inStart < inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postStart]);
        int rIndex = inStart;
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == postorder[postStart]) {
                rIndex = i;
                break;
            }
        }
        root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart - 1);
        root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) - 1);
        return root;
    }
}