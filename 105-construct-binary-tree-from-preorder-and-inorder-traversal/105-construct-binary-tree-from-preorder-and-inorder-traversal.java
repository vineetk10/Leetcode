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
    
    HashMap<Integer, Integer> inorderHm;
    int preIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderHm = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inorderHm.put(inorder[i], i);
        }
        return BuildTree(preorder, 0 , preorder.length-1);
    }
    
    public TreeNode BuildTree(int[] preorder,int left, int right)
    {
        if(left>right)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        // if(left==right)
        //     return root;
        TreeNode leftTree = BuildTree(preorder,left,  inorderHm.get(root.val)-1);
        TreeNode rightTree = BuildTree(preorder,inorderHm.get(root.val)+1,  right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}


