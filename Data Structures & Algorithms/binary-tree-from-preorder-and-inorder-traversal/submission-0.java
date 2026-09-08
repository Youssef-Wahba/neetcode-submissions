/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int findIndex(int[] arr, int target) {
        if (arr == null) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Element found
            }
        }
        return -1; // Element not found
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootInOrder = findIndex(inorder,root.val);
        root.left=buildTree(
                Arrays.copyOfRange(preorder,1,rootInOrder+1),
                Arrays.copyOfRange(inorder,0,rootInOrder));
        root.right=buildTree(
                Arrays.copyOfRange(preorder,rootInOrder+1,preorder.length),
                Arrays.copyOfRange(inorder,rootInOrder+1,inorder.length));
        return root;
    }

}
