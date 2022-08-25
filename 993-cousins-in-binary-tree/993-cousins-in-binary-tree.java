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
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDep = -1;
    int yDep = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        FindParentAndLevel(root, x, y, 0, null);
        return (xDep==yDep && xParent!=yParent) ? true : false;
    }
    
    public void FindParentAndLevel(TreeNode root, int x, int y, int depth, TreeNode parent)
    {
        if(root==null)
            return;
        
        if(root.val==x)
        {
            xParent = parent;
            xDep = depth;
        }
        else if(root.val==y)
        {
            yParent = parent;
            yDep = depth;
        }
        
        FindParentAndLevel(root.left, x, y, depth+1, root);
        FindParentAndLevel(root.right, x, y, depth+1, root);
    }
}