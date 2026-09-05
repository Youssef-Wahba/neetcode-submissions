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
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode curr, int leftBound, int rightBound){
        if(curr == null) return true;
        if(!(curr.val<rightBound && curr.val>leftBound)) return false;
        return isValid(curr.left, leftBound, curr.val) && isValid(curr.right, curr.val, rightBound);
    }

}
