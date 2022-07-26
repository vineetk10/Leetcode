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
        Deque<TreeNode> dq = new ArrayDeque<TreeNode>();
        
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        dq.offerLast(root);
        
        while(dq.size()>0)
        {
            int size = dq.size();
            List<Integer> res = new ArrayList<>();
            while(size>0 && dq.size()>0)
            {
                TreeNode n = dq.pollFirst();
                if(n.left!=null)
                    dq.offerLast(n.left);
                if(n.right!=null)
                    dq.offerLast(n.right);
                res.add(n.val);
                size--;
            }
            result.add(res);
        }
        
        return result;
    }
}