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
    int maxLevel = Integer.MIN_VALUE;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        RightSideView(root, arr, 0);
        return arr;
    }
    
    public void RightSideView(TreeNode root, List<Integer> arr, int level)
    {
        if(root==null)
            return;
        if(level>maxLevel){
            arr.add(root.val);
            maxLevel = level;
        }
        RightSideView(root.right, arr, level+1);
        RightSideView(root.left, arr, level+1);
    }
        
}