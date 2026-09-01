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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int currLen = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < currLen; i++) {
                TreeNode currNode = queue.poll();
                level.add(currNode.val);
                if(currNode.left!=null) queue.add(currNode.left);
                if(currNode.right!=null) queue.add(currNode.right);
            }
            res.add(level);
        }
        return res;
    }
}
