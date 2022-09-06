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
    public void flatten(TreeNode root) {
        Flatten(root);
    }
    
    public static void Flatten(TreeNode root)
    {
        if(root==null)
            return;
        
        Flatten(root.left);
        Flatten(root.right);
        
        TreeNode n = root.left;
        if(n==null)
            return;
        
        while(n.right!=null)
        {
            n = n.right;
        }
        
        n.right = root.right;
        root.right = root.left;
        root.left = null;
        
    }
}