class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        for(int num: nums)
        {
            List<List<Integer>> newSubsets = new ArrayList();
            for(List<Integer> temp: result)
            {
                List<Integer> r = new ArrayList<>(temp);
                r.add(num);
                newSubsets.add(r);
            }
            
            for (List<Integer> curr : newSubsets) {
                result.add(curr);
              }
        }
        return result;
    }
}
