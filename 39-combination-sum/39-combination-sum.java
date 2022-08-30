class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        CombinationSum(candidates,0, 0, target,curr, res);
        return res;
    }
    
    public static void CombinationSum(int[] candidates, int i, int currSum, int target,List<Integer> curr, List<List<Integer>> res)
    {
        if(i>=candidates.length || currSum>target){
            // curr.clear();
            return;
            
        }
        if(currSum==target)
        {
            res.add(new ArrayList<>(curr));
            // curr.clear();
            // currSum=0;
            return;
        }
        
        
        CombinationSum(candidates,i+1,currSum , target,curr, res);
        curr.add(candidates[i]);
        CombinationSum(candidates, i, currSum+candidates[i], target,curr, res);
        curr.remove(curr.size()-1);
    }
}